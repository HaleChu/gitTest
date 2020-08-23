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
        t1.setName("窗口1");
        Thread t2 = new Thread(window);
        t2.setName("窗口2");
        Thread t3 = new Thread(window);
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {

    /**
     * 不需要加static
     */
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println("当前窗口:" + Thread.currentThread().getName() + ",票号:" + ticket);
                ticket--;
            } else {
                System.out.println("票已买完,当前窗口:" + Thread.currentThread().getName());
                break;
            }
        }
    }
}
