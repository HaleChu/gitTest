package pers.god.demo.password;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/11/16
 */
public class PasswordEncoderDemo {

    public static void main(String[] args) {
        String passDes = "YbsXngrNJ8Y=";
        System.out.println("加密密码:" + passDes + "原密码:" + PasswordEncoderHelper.decryptByDES(passDes));

    }

}
