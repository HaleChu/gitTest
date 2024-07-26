package pers.god.demo.password;

import com.hazelcast.internal.util.MD5Util;
import pers.god.demo.util.SmUtil;

import java.net.URLEncoder;

/**
 * @Author chuhao
 * @Date 2024/5/17
 * @Version 1.0.0
 */
public class RsaTest {

    public static void main(String[] args) throws Exception {
//        String userName = "admin";
//        String password = "abc@123456";
//        String encryptUsername = RsaUtils.encryptByPublicKey(RsaUtils.PUBLIC_KEY, userName);
//        String encryptPassword = RsaUtils.encryptByPublicKey(RsaUtils.PUBLIC_KEY, password);
//        System.out.println("[用户名]公钥加密:" + encryptUsername);
//        System.out.println("[密码]公钥加密:" + encryptPassword);
//        String usernameStr = RsaUtils.decryptByPrivateKey(RsaUtils.privateKey, encryptUsername);
//        String passwordStr = RsaUtils.decryptByPrivateKey(RsaUtils.privateKey, encryptPassword);
//        System.out.println("[用户名]私钥解密:" + usernameStr);
//        System.out.println("[密码]私钥解密:" + passwordStr);

        String s = "[{\"uuid\":{\"destroyed\":false,\"keyIndex\":0,\"format\":\"RAW\",\"algorithm\":\"SM4\",\"encoded\":\"Pp0KCyx6rxbhD7oEOGxNfA==\"}},{\"encode\":\"222D2F455E5FB227A76B91DDDAF93B4A5B7729AFFD64688CBC7AB700F9D250BE8C22E4DE64C8B7647E8135051951EA015803C0FD56E65BE518BAE89B1C7B76C144028E068117A767CB25098311657A5EF476BD66C19426FF6B8DD8F54FDAB502614AE2D1017F47373C57B60A667912BE\"}]";
        System.out.println(URLEncoder.encode(s));

        System.out.println(MD5Util.toMD5String("430503198003280013"));

        System.out.println("-----SM4-----");
        String hexKey = SmUtil.generateKey();
        System.out.println("密钥" + SmUtil.generateKey());
        String password = "ABcd1234";
        System.out.println("原密码:" + password);
        String encrypted = SmUtil.encryptEcb(hexKey, password);
        System.out.println("加密密码:" + encrypted);
        System.out.println("解密加密密码:" + SmUtil.decryptEcb(hexKey, encrypted));
    }
}
