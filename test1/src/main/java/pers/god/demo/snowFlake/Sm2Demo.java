package pers.god.demo.snowFlake;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;

/**
 * @Author chuhao
 * @Date 2024/7/2
 * @Version 1.0.0
 */
public class Sm2Demo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        String privateKey = Base64.encode(pair.getPrivate().getEncoded());
        String publicKey = Base64.encode(pair.getPublic().getEncoded());
        System.out.println("私钥:" + privateKey);
        System.out.println("公钥:" + publicKey);

        String data = "1221221";
//
//        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);
//        String encryptBase64 = sm2.encryptBase64(data, KeyType.PublicKey);s
//        System.out.println(encryptBase64);
//        System.out.println(sm2.decryptStr(encryptBase64, KeyType.PrivateKey));
//
//        SM2 newSm2 = SmUtil.sm2(privateKey, null);
//        System.out.println(newSm2.decryptStr(encryptBase64, KeyType.PrivateKey));
////
////        SM2 sm2 = SmUtil.sm2("3f2cca7da822ae5ff250e9b2f143d8c334dc38b3080362bb3347a854b3a541c0", null);
////        String data2 = "Dk3nzzOmGoZynA4j4iXKA1Z7httw+tef8iAF1YKIJyRApbKijoSg/aSvYvdpHYJ0JPLiOPKs8dKakcVO5kAHol1j6uWwVR76AT1cZmqP7FqaTIsom2Uc/UQYeYQmkkXRrdiu67KD4hUDB3H8VZy+KCsnvcVvnnxBU3caYtSq6OuRS8Y81NfczODVsnq7vf3eWtnfhU0bQjKh6x/oHqBEHJRHavHpNd5vmu1u4IeID4Qur2+UuMWs5YYWbuLFu3xbw+L4pL5eO8PU+A4=";
////        String source = sm2.decryptStr(data2, KeyType.PrivateKey);
////        System.out.println(source);
//
//        String s = "[{\"uuid\":{\"algorithm\":\"SM4\",\"destroyed\":false,\"encoded\":\"TcA2mXk8MtET2hB8gcf1fA==\",\"format\":\"RAW\",\"keyIndex\":0}},{\"encode\":\"8BC90886AF8E21EF505B58292856270A\"}]";
//        String encode = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
//        System.out.println(encode);

//        String publicKey2 = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEn0GsB0TxMGrRJFTXGQPvfvYfeazVTBjr28v0Vnvx6n9J5V+jbIZfBw8pWs3m3eeLTBKaOXNgC1LQttTGPe97aA==";
        String publicKey2 = "0424065d9dc802d7c185a51d5ab2487821a87532e6bd1fda83036fd743b2c0a445cbe0d2a8249f74364c919107597610aa8002aa9e6cf4ea50b4b178ca0645cad8";
//        String privateKey2 = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgm7Z0rXfdcIxTTXIRzAAxQhIkl2fh9vAHcpCqlN5WLrOgCgYIKoEcz1UBgi2hRANCAASfQawHRPEwatEkVNcZA+9+9h95rNVMGOvby/RWe/Hqf0nlX6Nshl8HDylazebd54tMEpo5c2ALUtC21MY973to";
        String privateKey2 = "bbf2c00e2bec258d096935d36e3ad7d5a26623d4ab61e9877d4a0e48c3131c70";
        SM2 sm2 = SmUtil.sm2(privateKey2, publicKey2);
        String s3 = "abcd1234";
        String encrypted = sm2.encryptBase64(s3, KeyType.PublicKey);
        System.out.println("加密:" + encrypted);
        String decrypted = sm2.decryptStr(encrypted, KeyType.PrivateKey);
        System.out.println("解密:" + decrypted);
    }
}
