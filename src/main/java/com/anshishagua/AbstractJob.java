package com.anshishagua;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractJob implements Job {
    private static final AtomicLong JOB_ID_GENERATOR = new AtomicLong();
    private String id;
    private String name;
    private String description;
    private List<String> dependencies;
    private int maxTryTime = Job.DEFAULT_TRY_TIME;
    private JobStatus jobStatus = JobStatus.NEW;
    private JobException jobException;
    private JobContext jobContext = new JobContext();

    public AbstractJob() {

    }

    public AbstractJob(String name) {
        this.id = "Job-" + JOB_ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.dependencies = new ArrayList<>();
    }

    public int getMaxTryTime() {
        return maxTryTime;
    }

    public void setMaxTryTime(int maxTryTime) {
        this.maxTryTime = maxTryTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public abstract void run(JobContext jobContext) throws JobException;

    @Override
    public JobStatus getJobStatus() {
        return jobStatus;
    }

    @Override
    public JobException getException() {
        return jobException;
    }

    public final void run() {
        jobStatus = JobStatus.RUNNING;
        int tryTime = maxTryTime;

        boolean isFirstRun = true;
        System.out.println("Start to run job:" + name);

        do {
            --tryTime;

            if (!isFirstRun) {
                System.out.println("Rerun job:" + name);
            }

            try {
                run(jobContext);
            } catch (Exception ex) {
                jobException = new JobException(ex);
            }

            isFirstRun = !isFirstRun;
        } while (tryTime > 0 && jobException != null);

        if (jobException != null) {
            jobStatus = JobStatus.FAIL;
        } else {
            jobStatus = JobStatus.SUCCESS;
        }

        System.out.println("Job " + name + " finished with status " + jobStatus);
    }
}
