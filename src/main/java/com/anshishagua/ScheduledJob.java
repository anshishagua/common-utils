package com.anshishagua;

import java.util.List;

public class ScheduledJob {
    private String id;
    private String cron;
    private Runnable runnable;

    private List<String> dependencies;
}
