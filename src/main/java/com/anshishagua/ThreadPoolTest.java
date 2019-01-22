package com.anshishagua;

import org.apache.hadoop.yarn.util.resource.DominantResourceCalculator;
import org.apache.spark.executor.CoarseGrainedExecutorBackend;

import javax.validation.constraints.NotNull;
import java.nio.file.Files;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.logging.Logger;

public class ThreadPoolTest {
    public static void main(String [] args) {
        Logger logger = Logger.getLogger(ThreadPoolTest.class.getName());

        AtomicInteger atomicInteger = new AtomicInteger();
        int corePoolSize = 2;
        int maxPoolSize = 3;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                (Runnable r) -> {
                    Thread thread = new Thread(r);
                    thread.setName(String.format("%s-thread-%d", ThreadPoolTest.class.getSimpleName(), atomicInteger.addAndGet(1)));

                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                        @Override
                        public void uncaughtException(Thread t, Throwable e) {
                            logger.warning("werwerewr");
                            System.out.println(t + ":" + e);
                        }
                    });

                    return thread;
                }
                );

        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        };

        Runnable r = new Runnable() {
            @Override
            public void run() {
                //logger.info(Thread.currentThread().getName() + ":RRR");
                for (int i = 0; i < 15; ++i) {
                    throw new RuntimeException("ehhee");

                    //System.out.println("hello" + i);

                }
            }
        };

        Executor executor1;

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        for (int i = 0; i < 7; ++i) {
            executor.submit(r);
        }
        executor.shutdown();

        System.out.println(Runtime.getRuntime().availableProcessors());

        ArrayBlockingQueue a;

        DominantResourceCalculator calculator;

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
