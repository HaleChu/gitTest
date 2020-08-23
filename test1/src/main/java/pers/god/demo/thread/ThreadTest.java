package pers.god.demo.thread;

/**
 * Java多线程
 * <p>
 * 1.start()
 * 2.run()
 * 3.currentThread()
 * 4.getName()
 * 5.setName()
 * 6.yield()
 * 7.join()
 * 8.stop()
 * 9.sleep(long milliTime)
 * 10.isAlive()
 * <p>
 * MIN_PRIORITY
 * NORM_PRIORITY
 * MAX_PRIORITY
 *
 * @Author GodChu
 * @Date 2020/8/23
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "运行：" + i + ",当前线程优先级:" + Thread.currentThread().getPriority());

            /*if (i == 20) {
                myThread.join();
            }*/
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        Thread.currentThread().setName("自定义线程1");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "运行：" + i + ",当前线程优先级:" + Thread.currentThread().getPriority());
            /*if (i % 30 == 0) {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
}