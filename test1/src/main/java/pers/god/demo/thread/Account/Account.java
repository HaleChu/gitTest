package pers.god.demo.thread.Account;

import java.math.BigDecimal;

/**
 * @Author GodChu
 * @Date 2020/8/24
 */
public class Account {

    private BigDecimal money;

    public Account(BigDecimal money) {
        this.money = money;
    }

    public void saveMoney(BigDecimal amt) {
        money = money.add(amt);
        System.out.println("本次存款:" + amt + ",账户余额:" + money);
    }
}
