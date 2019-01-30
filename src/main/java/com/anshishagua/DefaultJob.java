package com.anshishagua;

public class DefaultJob extends AbstractJob {
    public DefaultJob() {
        super("");
    }

    public DefaultJob(String name) {
        super(name);
    }

    @Override
    public void run(JobContext jobContext) throws JobException {
        //nothing to do
    }
}
