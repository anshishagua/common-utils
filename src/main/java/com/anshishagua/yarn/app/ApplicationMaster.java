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
import org.apache.hadoop.yarn.client.api.async.AMRMClientAsync;
import org.apache.hadoop.yarn.client.api.async.NMClientAsync;
import org.apache.hadoop.yarn.client.api.async.impl.NMClientAsyncImpl;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.exceptions.YarnException;
import org.apache.hadoop.yarn.util.ConverterUtils;
import org.apache.hadoop.yarn.util.Records;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ApplicationMaster {
    private static final Log LOG = LogFactory.getLog(com.anshishagua.yarn.ApplicationMaster.class);

    @SuppressWarnings("rawtypes")
    private AMRMClientAsync amRMClient = null;
    NMClientAsyncImpl amNMClient = null;

    private AtomicInteger numTotalContainers = new AtomicInteger(10);
    private AtomicInteger numCompletedContainers = new AtomicInteger(0);
    private ExecutorService exeService = Executors.newCachedThreadPool();
    private Map<ContainerId, Container> runningContainers = new ConcurrentHashMap<>();
    private String [] args;

    private class LaunchContainerTask implements Runnable {
        private Container container;

        public LaunchContainerTask(Container container) {
            this.container = container;
        }

        @Override
        public void run() {
            List<String> commands = new LinkedList<>();

            commands.add("echo 'hello,world!!!!!!!!!'");
            ContainerLaunchContext context = Records.newRecord(ContainerLaunchContext.class);
            context.setCommands(commands);

            amNMClient.startContainerAsync(container, context);
        }
    }

    private class NMCallbackHandler implements NMClientAsync.CallbackHandler {
        @Override
        public void onContainerStarted(ContainerId containerId,
                                       Map<String, ByteBuffer> allServiceResponse) {
            LOG.info("Container Stared " + containerId.toString());

        }

        @Override
        public void onContainerStatusReceived(ContainerId containerId,
                                              ContainerStatus containerStatus) {

        }

        @Override
        public void onContainerStopped(ContainerId containerId) {
            // TODO Auto-generated method stub

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
                LOG.info("Container Completed: " + status.getContainerId().toString()
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
                LOG.info("Container Allocated"
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
            float progress = 0;
            return progress;
        }

        @Override
        public void onError(Throwable e) {
            amRMClient.stop();
        }

    }

    private void logInformation() {
        System.out.println("This is System.out.println");
        System.err.println("This is System.err.println");

        String containerIdStr = System.getenv(ApplicationConstants.Environment.CONTAINER_ID.name());

        LOG.info("containerId " + containerIdStr);

        ContainerId containerId = ConverterUtils.toContainerId(containerIdStr);
        ApplicationAttemptId appAttemptId = containerId.getApplicationAttemptId();
        LOG.info("appAttemptId " + appAttemptId.toString());
    }

    @SuppressWarnings("unchecked")
    void run() throws YarnException, IOException {
        //logInformation();
        Configuration conf = new Configuration();

        // 1. create amRMClient
        amRMClient = AMRMClientAsync.createAMRMClientAsync(1000, new RMCallbackHandler());
        amRMClient.init(conf);
        amRMClient.start();
        // 2. Create nmClientAsync
        amNMClient = new NMClientAsyncImpl(new NMCallbackHandler());
        amNMClient.init(conf);
        amNMClient.start();

        // 3. register with RM and this will heartbeating to RM
        RegisterApplicationMasterResponse response = amRMClient.registerApplicationMaster(NetUtils.getHostname(), -1, "");

        int numContainers = 2;

        for (int i = 0; i < numTotalContainers.get(); i++) {
            AMRMClient.ContainerRequest containerAsk = new AMRMClient.ContainerRequest(
                    Resource.newInstance(100, 1), null, null,
                    Priority.newInstance(0));
            amRMClient.addContainerRequest(containerAsk);
        }

        amRMClient.unregisterApplicationMaster(FinalApplicationStatus.SUCCEEDED, "", "");
        System.out.println("Done!");
    }

    public void waitComplete() {

    }

    public static void main(String[] args) throws Exception {
        System.out.println(System.getenv("CLASSPATH"));
        ApplicationMaster applicationMaster = new ApplicationMaster();
        applicationMaster.run();
        applicationMaster.waitComplete();

    }
}
