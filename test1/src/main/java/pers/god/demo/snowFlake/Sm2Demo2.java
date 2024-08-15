package pers.god.demo.snowFlake;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;

import java.security.KeyPair;

public class Sm2Demo2 {

    public static void main(String[] args) {
        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        String privateKey = Base64.encode(pair.getPrivate().getEncoded());
        String publicKey = Base64.encode(pair.getPublic().getEncoded());
        System.out.println("私钥:" + privateKey);
        System.out.println("公钥:" + publicKey);

        String data = "ABcd1234";
        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);
        String encryptBase64 = sm2.encryptBase64(data, KeyType.PublicKey);
        System.out.println(encryptBase64);

        String source = sm2.decryptStr(encryptBase64, KeyType.PrivateKey);
        System.out.println(source);
    }
}
