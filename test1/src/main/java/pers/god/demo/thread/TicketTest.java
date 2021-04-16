package pers.god.demo.thread;

/**
 * 实现Runnable接口方式三个窗口买票
 *
 * @Author GodChu
 * @Date 2020/8/23
 */
public class TicketTest {

    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前窗口:" + Thread.currentThread().getName() + ",票号:" + ticket);
                    ticket--;
                } else {
                    System.out.println("票已买完,当前窗口:" + Thread.currentThread().getName());
                    break;
                }
            }
        }
    }
}
