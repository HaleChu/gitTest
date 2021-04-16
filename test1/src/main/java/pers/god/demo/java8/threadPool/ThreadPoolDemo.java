package pers.god.demo.java8.threadPool;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        testFixedThreadPool();
        ArrayList<Object> objects = Lists.newArrayList();
        objects.forEach(x -> System.out.println(x));
    }

    /**
     * CachedThreadPool
     */
    private static void testCachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(() -> {
                System.out.println(index);
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    /**
     * FixedThreadPool
     */
    private static void testFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            fixedThreadPool.execute(() -> {
                System.out.println(index);
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    /**
     * ScheduledThreadPool
     */
    private static void testScheduledThreadPool() {
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    }

    /**
     * SingleThreadExecutor
     */
    private static void testSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    }
}
