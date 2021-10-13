package pers.god.demo.thread.ForTest;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chuhao
 * @Date 2021/10/12
 * @Version 1.0.0
 */
public class ListAddTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<String> stringList = Collections.synchronizedList(Lists.newArrayList());
        for (int i = 0; i < 100; i++) {
            int j = i;
            pool.execute(() -> stringList.add(Thread.currentThread().getName() + "-" + j));
        }
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
