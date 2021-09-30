package pers.god.demo.thread.ForTest;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Author chuhao
 * @Date 2021/9/24
 * @Version 1.0.0
 */
public class ForThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10000; i++) {
            int j = i;
            /*executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + j);
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });*/
            /*Future<String> future = executorService.submit(() -> Thread.currentThread().getName() + ":" + j);
            System.out.println(future.get());*/
            List<Callable<String>> task = Lists.newArrayList();
            task.add(() -> Thread.currentThread().getName() + ":" + j);
            List<Future<String>> futures = executorService.invokeAll(task);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        }
    }
}
