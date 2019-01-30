package com.anshishagua;

import java.util.List;

public interface Job extends Runnable {
    public static final int DEFAULT_TRY_TIME = 3;
    String getId();
    String getName();
    String getDescription();
    List<String> getDependencies();
    void run(JobContext jobContext) throws JobException;
    JobStatus getJobStatus();
    JobException getException();
}
