package pers.god.demo.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SyncTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
//        test2();
//        System.out.println("==========invokeAll==========");
//        test3();
//        System.out.println("==========invokeAny==========");
//        test4();
//        System.out.println("==========CompletionService==========");
//        test5();
        test6();
    }

    public static void test1() {
        FutureTask<String> futureTask = new FutureTask<>(() -> "你妈的头像皮球");
        String result = null;
        try {
            futureTask.run();
            result = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(futureTask.isCancelled());
        System.out.println(futureTask.isDone());
    }

    public static void test2() {
        Object obj1 = new Object();
        new Thread(() -> {
            System.out.println("线程1开始...");
            synchronized (obj1) {
                try {
                    for (int i = 1; i <= 10; i++) {
                        Thread.sleep(i * 1000);
                        System.out.println("等待" + i + "秒...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("线程2开始...");
            synchronized (obj1) {
                System.out.println("线程2获取到对象obj1...");
            }
        }).start();
    }

    public static void test3() throws InterruptedException, ExecutionException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(() -> {
                Random random = new Random();
                int second = random.nextInt(10);
                Thread.sleep(second * 1000);
                return Thread.currentThread().getName() + "睡眠时间:" + second + "s";
            });
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = executorService.invokeAll(tasks);
        for (int i = 0; i < futures.size(); i++) {
            System.out.println(futures.get(i).get());
        }

        executorService.shutdown();
    }

    public static void test4() throws InterruptedException, ExecutionException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(() -> {
                Random random = new Random();
                int second = random.nextInt(10);
                Thread.sleep(second * 1000);
                return Thread.currentThread().getName() + "睡眠时间:" + second + "s";
            });
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        String result = executorService.invokeAny(tasks);
        System.out.println(result);
        executorService.shutdown();
    }

    public static void test5() throws InterruptedException, ExecutionException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(() -> {
                Random random = new Random();
                int second = random.nextInt(10);
                Thread.sleep(second * 1000);
                return Thread.currentThread().getName() + "睡眠时间:" + second + "s";
            });
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        tasks.forEach(completionService::submit);
        for (Callable<String> task : tasks) {
            System.out.println(completionService.take().get());
        }
        executorService.shutdown();
    }

    public static void test6() {
        // 1. 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 2. 提交任务，并调用join()阻塞等待所有任务执行完成
        CompletableFuture[] completableFutures = list.stream().map(i -> CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是" + i);
        })).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();
        executorService.shutdown();
    }
}
