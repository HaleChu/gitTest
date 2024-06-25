package pers.god.demo.password;

import pers.god.demo.algorithm.RsaUtils;

/**
 * @Author chuhao
 * @Date 2024/5/17
 * @Version 1.0.0
 */
public class RsaTest {

    public static void main(String[] args) throws Exception {
        String userName = "admin";
        String password = "abc@123456";
        String encryptUsername = RsaUtils.encryptByPublicKey(RsaUtils.PUBLIC_KEY, userName);
        String encryptPassword = RsaUtils.encryptByPublicKey(RsaUtils.PUBLIC_KEY, password);
        System.out.println("[用户名]公钥加密:" + encryptUsername);
        System.out.println("[密码]公钥加密:" + encryptPassword);
        String usernameStr = RsaUtils.decryptByPrivateKey(RsaUtils.privateKey, encryptUsername);
        String passwordStr = RsaUtils.decryptByPrivateKey(RsaUtils.privateKey, encryptPassword);
        System.out.println("[用户名]私钥解密:" + usernameStr);
        System.out.println("[密码]私钥解密:" + passwordStr);
    }
}
