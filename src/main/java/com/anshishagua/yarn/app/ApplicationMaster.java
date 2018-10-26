package com.anshishagua.yarn.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.net.NetUtils;
import org.apache.hadoop.util.Shell;
import org.apache.hadoop.yarn.api.ApplicationConstants;
import org.apache.hadoop.yarn.api.protocolrecords.AllocateResponse;
import org.apache.hadoop.yarn.api.protocolrecords.RegisterApplicationMasterResponse;
import org.apache.hadoop.yarn.api.records.ApplicationAttemptId;
import org.apache.hadoop.yarn.api.records.Container;
import org.apache.hadoop.yarn.api.records.ContainerId;
import org.apache.hadoop.yarn.api.records.ContainerLaunchContext;
import org.apache.hadoop.yarn.api.records.ContainerStatus;
import org.apache.hadoop.yarn.api.records.FinalApplicationStatus;
import org.apache.hadoop.yarn.api.records.LocalResource;
import org.apache.hadoop.yarn.api.records.LocalResourceType;
import org.apache.hadoop.yarn.api.records.LocalResourceVisibility;
import org.apache.hadoop.yarn.api.records.NodeReport;
import org.apache.hadoop.yarn.api.records.Priority;
import org.apache.hadoop.yarn.api.records.Resource;
import org.apache.hadoop.yarn.client.api.AMRMClient;
import org.apache.hadoop.yarn.client.api.AMRMClient.ContainerRequest;

import org.apache.hadoop.yarn.client.api.async.AMRMClientAsync;
import org.apache.hadoop.yarn.client.api.async.NMClientAsync;
import org.apache.hadoop.yarn.client.api.async.impl.NMClientAsyncImpl;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.exceptions.YarnException;
import org.apache.hadoop.yarn.util.ConverterUtils;
import org.apache.hadoop.yarn.util.Records;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ApplicationMaster {
    private static final Log LOG = LogFactory.getLog(com.anshishagua.yarn.ApplicationMaster.class);

    private AMRMClientAsync<ContainerRequest> amRMClient = null;
    private NMClientAsyncImpl amNMClient = null;

    private int numTotalContainers = 1;
    private AtomicInteger numCompletedContainers = new AtomicInteger(0);
    private ExecutorService exeService = Executors.newCachedThreadPool();
    private Map<ContainerId, Container> runningContainers = new ConcurrentHashMap<>();
    private String [] args;
    private Configuration conf;

    private class LaunchContainerTask implements Runnable {
        private Container container;

        public LaunchContainerTask(Container container) {
            this.container = container;
        }

        @Override
        public void run() {
            List<String> commands = new ArrayList<>();

            System.out.println("Run");
            commands.add("echo 'hello,world!!!!!!!!!' 1> "
                    + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stdout" + " 2>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stderr");
            String command = String.format("%s/bin/java %s %s %s",
                    ApplicationConstants.Environment.JAVA_HOME.$(),
                    "com.anshishagua.yarn.app.Example",
                    " 1>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stdout",
                    " 2>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stderr");

            //commands.add(command);
            ContainerLaunchContext context = Records.newRecord(ContainerLaunchContext.class);
            context.setCommands(commands);

            /*
            Map<String, LocalResource> localResourceMap = new HashMap<>();

            try {
                FileSystem fs = FileSystem.get(conf);
                String localFile = "/tmp/app.jar";
                Path src = new Path(localFile);
                String pathSuffix =  localFile;
                Path dest = new Path(fs.getHomeDirectory(), pathSuffix);
                fs.copyFromLocalFile(false, true, src, dest);
                FileStatus fileStatus = fs.getFileStatus(dest);
                LocalResource resource = Records.newRecord(LocalResource.class);
                resource.setResource(ConverterUtils.getYarnUrlFromPath(dest));
                resource.setSize(fileStatus.getLen());

                resource.setTimestamp(fileStatus.getModificationTime());

                resource.setVisibility(LocalResourceVisibility.APPLICATION);

                localResourceMap.put("app.jar", resource);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            context.setLocalResources(localResourceMap);
            */

            Map<String, String> environment = new HashMap<>();

            StringBuilder classpath = new StringBuilder(ApplicationConstants.Environment.CLASSPATH.$()).append(File.pathSeparatorChar).append("./*");

            for (String c : conf.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH, YarnConfiguration.DEFAULT_YARN_APPLICATION_CLASSPATH)) {
                classpath.append(File.pathSeparatorChar);
                classpath.append(c.trim());
            }

            environment.put("CLASSPATH", classpath.toString());
            context.setEnvironment(environment);

            amNMClient.startContainerAsync(container, context);
        }
    }

    private class NMCallbackHandler implements NMClientAsync.CallbackHandler {
        @Override
        public void onContainerStarted(ContainerId containerId, Map<String, ByteBuffer> allServiceResponse) {
            System.out.println("Container Stared " + containerId.toString());
        }

        @Override
        public void onContainerStatusReceived(ContainerId containerId, ContainerStatus containerStatus) {

        }

        @Override
        public void onContainerStopped(ContainerId containerId) {
            System.out.println("Container " + containerId + " stopped");
        }

        @Override
        public void onStartContainerError(ContainerId containerId, Throwable t) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onGetContainerStatusError(ContainerId containerId,
                                              Throwable t) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStopContainerError(ContainerId containerId, Throwable t) {
            // TODO Auto-generated method stub

        }

    }

    private class RMCallbackHandler implements AMRMClientAsync.CallbackHandler {
        @Override
        public void onContainersCompleted(List<ContainerStatus> statuses) {
            for (ContainerStatus status : statuses) {
                System.out.println("Container Completed: " + status.getContainerId().toString()
                        + " exitStatus="+ status.getExitStatus());

                if (status.getExitStatus() != 0) {
                    // restart
                }

                ContainerId id = status.getContainerId();
                runningContainers.remove(id);
                numCompletedContainers.addAndGet(1);
            }
        }

        @Override
        public void onContainersAllocated(List<Container> containers) {
            for (Container c : containers) {
                System.out.println("Container Allocated"
                        + ", id=" + c.getId()
                        + ", containerNode=" + c.getNodeId());

                exeService.submit(new ApplicationMaster.LaunchContainerTask(c));
                runningContainers.put(c.getId(), c);
            }
        }

        @Override
        public void onShutdownRequest() {

        }

        @Override
        public void onNodesUpdated(List<NodeReport> updatedNodes) {

        }

        @Override
        public float getProgress() {
            float progress = (float) numCompletedContainers.get() / (float) numTotalContainers;

            System.out.println(progress);

            return progress;
        }

        @Override
        public void onError(Throwable e) {
            amRMClient.stop();
        }
    }

    @SuppressWarnings("unchecked")
    void run() throws YarnException, IOException {
        conf = new Configuration();

        amRMClient = AMRMClientAsync.createAMRMClientAsync(1000, new RMCallbackHandler());
        amRMClient.init(conf);
        amRMClient.start();

        RegisterApplicationMasterResponse registerApplicationMasterResponse = amRMClient.registerApplicationMaster(NetUtils.getHostname(), -1, "");

        for (int i = 0; i < numTotalContainers; ++i) {
            AMRMClient.ContainerRequest containerAsk = new AMRMClient.ContainerRequest(Resource.newInstance(1000, 1), null, null, Priority.newInstance(0));
            amRMClient.addContainerRequest(containerAsk);
        }

        amNMClient = new NMClientAsyncImpl(new NMCallbackHandler());
        amNMClient.init(conf);
        amNMClient.start();

        while (numCompletedContainers.get() < numTotalContainers) {
            System.out.println("Completed:" + numCompletedContainers.get() + ", total:" + numTotalContainers);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        amRMClient.unregisterApplicationMaster(FinalApplicationStatus.SUCCEEDED, "", "");
        System.out.println("Done!");

        amNMClient.stop();
        amRMClient.stop();
    }

    public static void main(String[] args) throws Exception {
        ApplicationMaster applicationMaster = new ApplicationMaster();
        applicationMaster.run();
    }
}
