package pers.god.demo.password;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/11/16
 */
public class PasswordEncoderDemo {

    public static void main(String[] args) {
        String password = "Aa@123456";
        String passwordDes = PasswordEncoderHelper.encode(password);
        System.out.println("原密码:" + password);
        System.out.println("加密密码:" + passwordDes);

        String passDes = "XjniR1m8mHt9Le7fOU57eA==";
        System.out.println("加密密码:" + passDes + "原密码:" + PasswordEncoderHelper.decryptByDES(passDes));
    }

}
