package com.anshishagua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    class GraphNode<T> {
        T data;
        List<GraphNode<T>> inNodes;
        List<GraphNode<T>> outNodes;

        public GraphNode(T data) {
            this.data = data;
            this.inNodes = new ArrayList<>();
            this.outNodes = new ArrayList<>();
        }

        public void addInNode(GraphNode<T> inNode) {
            this.inNodes.add(inNode);
        }

        public void addOutNode(GraphNode<T> outNode) {
            this.outNodes.add(outNode);
        }

        public List<GraphNode<T>> getInNodes() {
            return inNodes;
        }

        public List<GraphNode<T>> getOutNodes() {
            return outNodes;
        }
    }

    private Map<String, Job> jobMap;
    private Map<String, GraphNode<Job>> graphNodeMap;

    private Scheduler() {
        jobMap = new HashMap<>();
        graphNodeMap = new HashMap<>();
    }

    public static Scheduler getInstance() {
        return new Scheduler();
    }

    public void addJobs(Job ... jobs) throws JobException {
        for (Job job : jobs) {
            addJob(job);
        }
    }

    public void addJob(Job job) throws JobException {
        Objects.requireNonNull(job);

        if (jobMap.containsKey(job.getName())) {
            throw new JobException("Duplicated job name: " + job.getName());
        }

        List<String> dependentJobs = job.getDependencies();

        if (dependentJobs == null) {
            dependentJobs = new ArrayList<>();
        }

        if (dependentJobs.contains(job.getName())) {
            throw new JobException("Dependent to itself");
        }

        jobMap.put(job.getName(), job);
    }

    private void buildGraphNodeMap() {
        for (Job job : jobMap.values()) {
            graphNodeMap.put(job.getName(), new GraphNode<>(job));
        }

        for (Job job : jobMap.values()) {
            if (job.getDependencies() != null) {
                for (String jobName : job.getDependencies()) {
                    GraphNode<Job> inNode = graphNodeMap.get(jobName);
                    GraphNode<Job> outNode = graphNodeMap.get(job.getName());

                    inNode.addOutNode(outNode);
                    outNode.addInNode(inNode);
                }
            }
        }
    }

    public void scheduleAllJobs() throws JobException {
        buildGraphNodeMap();

        List<Job> jobs = new ArrayList<>();
        int totalJobs = jobMap.values().size();

        while (jobs.size() < totalJobs) {
            GraphNode<Job> select = null;

            for (GraphNode<Job> graphNode : graphNodeMap.values()) {
                if (graphNode.inNodes.isEmpty()) {
                    select = graphNode;
                    break;
                }
            }

            jobs.add(select.data);

            for (GraphNode<Job> outNode : select.getOutNodes()) {
                outNode.inNodes.remove(select);
            }

            graphNodeMap.remove(select.data.getName());
        }

        JobThreadFactory threadFactory = new JobThreadFactory("job");
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        int corePoolSize = 3;
        int maxPoolSize = 10;
        long keepAliveTime = 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                timeUnit,
                blockingQueue,
                threadFactory,
                rejectedExecutionHandler);

        for (Job job : jobs) {
            if (job.getDependencies().isEmpty()) {
                executor.submit(job);
            } else {
                boolean allFinished = true;

                List<String> jobNames = job.getDependencies();

                for (String jobName : jobNames) {
                    if (jobMap.get(jobName).getJobStatus() == JobStatus.SUCCESS) {

                    }
                }

            }
            //System.out.println("Start to run job:" + job.getName());

            //System.out.println("Job " + job.getName() + " finished");
        }

        executor.shutdown();
    }
}
