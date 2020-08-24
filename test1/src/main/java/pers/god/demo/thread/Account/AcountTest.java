package pers.god.demo.thread.Account;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 两个人同时向一个银行账号里存钱，每次存1000元，每人存3次
 *
 * @Author GodChu
 * @Date 2020/8/24
 */
public class AcountTest {

    public static void main(String[] args) {
        Account account = new Account(new BigDecimal(0));
        Person p1 = new Person(account);
        Person p2 = new Person(account);

        p1.setName("小王");
        p2.setName("小赵");

        p1.start();
        p2.start();
    }

    /**
     * BigDecimal加法运算
     */
    @Test
    public void test1() {
        BigDecimal b1 = new BigDecimal(10);
        BigDecimal b2 = new BigDecimal(10);
        b1 = b1.add(b2);
        System.out.println(b1);
        System.out.println(b2);
    }

}
