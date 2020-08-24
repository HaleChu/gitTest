package pers.god.demo.thread.Account;

import java.math.BigDecimal;

/**
 * @Author GodChu
 * @Date 2020/8/24
 */
public class Person extends Thread {

    private Account account;

    public Person(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            synchronized (account) {
                System.out.println("当前存款人:" + Thread.currentThread().getName());
                account.saveMoney(new BigDecimal(1000));
            }
        }
    }
}
