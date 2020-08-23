package pers.god.demo.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author GodChu
 * @Date 2020/8/23
 */
public class RunableTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        MyRunable myRunable = new MyRunable();
        Thread t1 = new Thread(myRunable);
        t1.start();
    }
}

class MyRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
