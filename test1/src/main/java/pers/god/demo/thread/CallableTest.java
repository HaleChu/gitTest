package pers.god.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author GodChu
 * @Date 2020/9/3
 */
public class CallableTest {

    public static void main(String[] args) {
        Callable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        new Thread(futureTask).start();
    }

}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("调用了Call方法");
        return "调用了Call方法";
    }
}