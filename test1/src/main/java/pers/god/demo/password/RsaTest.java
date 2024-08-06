package pers.god.demo.password;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SM4;
import com.hazelcast.internal.util.MD5Util;
import pers.god.demo.util.Sm4Util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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

        String s = "[{\"uuid\":{\"algorithm\":\"SM4\",\"destroyed\":false,\"encoded\":\"uDYnq6Pkh5BpT8/bw+uUJg==\",\"format\":\"RAW\",\"keyIndex\":0}},{\"encode\":\"594E214B105249D9B078BDA7A3ABDF88A76C0FC0CA9680F91CABAB62E9A08F37\"}]";
        System.out.println(URLEncoder.encode(s, "utf-8"));

        System.out.println(MD5Util.toMD5String("430503198003280013"));

        System.out.println("-----SM4-----");
        String hexKey = Sm4Util.generateKey();
        System.out.println("密钥" + Sm4Util.generateKey());
        String password = "ABcd1234";
        System.out.println("原密码:" + password);
        String encrypted = Sm4Util.encryptEcb(hexKey, password);
        System.out.println("加密密码:" + encrypted);
        System.out.println("解密加密密码:" + Sm4Util.decryptEcb(hexKey, encrypted));

        String key = "B59223FABCC08F66DD4AAAF409F9EA65";
        String encode = "/8FPVWiKHxr+GbQCjLitRPZ8Z5UkI6TurlCzmU3HCLf1CK3GwI4RWvj2X2zxlNKpiS7b3IwJe04iPyhpTmk01CV/ayowjXi2jmK10CdkpZDj2sX+XlRPnGWAWNbd7BysQOABDuSao7m0I/0WT6HzZg==";
        System.out.println(Sm4Util.decryptEcb(key, encode));

        SM4 sm4 = SmUtil.sm4(HexUtil.decodeHex("B59223FABCC08F66DD4AAAF409F9EA65"));
        String str = sm4.decryptStr("Yn5BOTydSdzS1GO2Iksy1A79mUXjA8xiOYtvQ1IumUsgQ9Fd6YMKenrY0MkG5Fb0va9VkcYm7wLqimhFEukvTiaCR8cMaifbvhUVJ+00rjPwW52JAnIBFvhx31DTqbk7WX+nOla9S91CC991qBPj5g==");
        System.out.println(str);

//        String text = "shzkr@Sinosoft";
//        KeyPair pair = SecureUtil.generateKeyPair("SM2");
//        String privateKey = HexUtil.encodeHexStr(pair.getPrivate().getEncoded());
//        String publicKey = HexUtil.encodeHexStr(pair.getPublic().getEncoded());
//        System.out.println("私钥:" + privateKey);
//        System.out.println("公钥:" + publicKey);
        String privateKey = "3f2cca7da822ae5ff250e9b2f143d8c334dc38b3080362bb3347a854b3a541c0";
        SM2 sm2 = SmUtil.sm2(privateKey, null);
//        String sm2Encrypted = sm2.encryptHex(text, KeyType.PublicKey);
//        System.out.println(sm2Encrypted);
        String sm2Encrypted = "Dk3nzzOmGoZynA4j4iXKA1Z7httw+tef8iAF1YKIJyRApbKijoSg/aSvYvdpHYJ0JPLiOPKs8dKakcVO5kAHol1j6uWwVR76AT1cZmqP7FqaTIsom2Uc/UQYeYQmkkXRrdiu67KD4hUDB3H8VZy+KCsnvcVvnnxBU3caYtSq6OuRS8Y81NfczODVsnq7vf3eWtnfhU0bQjKh6x/oHqBEHJRHavHpNd5vmu1u4IeID4Qur2+UuMWs5YYWbuLFu3xbw+L4pL5eO8PU+A4=";
        String decryptStr = StrUtil.utf8Str(sm2.decryptStr(sm2Encrypted, KeyType.PrivateKey, StandardCharsets.UTF_8));
        System.out.println(decryptStr);
    }
}
