package com.anshishagua;

import java.util.concurrent.ThreadFactory;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicInteger;

public class JobThreadFactory implements ThreadFactory {
    public static final UncaughtExceptionHandler DEFAULT_UNCAUGHT_EXCEPTION_HANDLER = new UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Catch exception " + e + " in thread " + t);
        }
    };

    private static final AtomicInteger threadNumber = new AtomicInteger(0);
    private String threadPrefix;
    private UncaughtExceptionHandler uncaughtExceptionHandler;

    public JobThreadFactory(String threadPrefix) {
        this(threadPrefix, DEFAULT_UNCAUGHT_EXCEPTION_HANDLER);
    }

    public JobThreadFactory(String threadPrefix, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.threadPrefix = threadPrefix;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);

        thread.setName(threadPrefix + "-thread-" + threadNumber.getAndIncrement());
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);

        return thread;
    }
}
