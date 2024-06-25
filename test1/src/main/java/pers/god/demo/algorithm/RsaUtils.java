package pers.god.demo.algorithm;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RsaUtils {

    // Rsa 私钥MII
    public static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJVhQV/K3Mht1bMDk5yT0hprtwpm1mvLEvbB+4+PgzAgvHzGEVokVhwWj7vYzj0LECUm0EZWdqG+aoDJrPCBsB80KHMcZkeXb8fpB6reXIW3e1XquQkMScCCkh5ukvf3CmUoSVlpsMocRl3KRMRgSqSd18x8dKhkkOfVpLDISKi3AgMBAAECgYBDm/cYwhpXZM7Z7P58WbM4XhREUvMtaoY0xOt0uIGp4Mcuuf7Ui6mloNiBLsl5e25dQkn16+BZqHNPwvfRCwGJDLChKG8UZj4JLgYtxv3txLMvZa4oxHJlCLUvxYsc9/PAfGa3hK3z5zAXaIddXy8u1BKgP3q2mEgN+cNXx7vT4QJBAM4oh2jYK6O1uR4LVwh1xpqcu2pDDHV90cD4AkDcMDV8nN5zkRUzmNe4lZcZBGPUubDqWv+colWqAqSty5Dz/7kCQQC5fp5qANqkSYmSJnaxZYXnZ0+ZJez2ZWOASK9kfkNNWHnnfOxBdF3ycVAx8E2tm1/OnyTdU0jrVp/a1lPZy8PvAkAVmSVmlI8t3ZIBVcrOdhhShm0UGuYpQP9CqjkCNo9Oazm8DHt8ryUqJIp3hAVzuAukP0k9Ulmng+I3AoY7L3TxAkA0PMwv3f20tmDfn6VdX9HN0PJBlsScvwC+Z7m8+zHI3lm2Lx/5buPmGrMS3TGC6naYoYioK4QlgkeSQTlr5E5RAkEAvwddJIln3DUuN1AzQ2Ia1Jzq8kDadU9MOOewbBA6T2gPxUkcejg3ZKLUurhBYrEhnPUMVKhLC392vSmm+8BexQ==";
    /**
     * 公钥
     */
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVYUFfytzIbdWzA5Ock9Iaa7cKZtZryxL2wfuPj4MwILx8xhFaJFYcFo+72M49CxAlJtBGVnahvmqAyazwgbAfNChzHGZHl2/H6Qeq3lyFt3tV6rkJDEnAgpIebpL39wplKElZabDKHEZdykTEYEqkndfMfHSoZJDn1aSwyEiotwIDAQAB";

    /**
     * 构建RSA密钥对
     *
     * @return 生成后的公私钥信息
     */
    public static RsaKeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyString = Base64.encodeBase64String(rsaPublicKey.getEncoded());
        String privateKeyString = Base64.encodeBase64String(rsaPrivateKey.getEncoded());
        return new RsaKeyPair(publicKeyString, privateKeyString);
    }

    /**
     * 公钥加密
     *
     * @param publicKeyString 公钥
     * @param text            待加密的文本
     * @return 加密后的文本
     */
    public static String encryptByPublicKey(String publicKeyString, String text) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec2 = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec2);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(result);
    }

    /**
     * 公钥解密
     *
     * @param publicKeyString 公钥
     * @param text            待解密的信息
     * @return 解密后的文本
     */
    public static String decryptByPublicKey(String publicKeyString, String text) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(text));
        return new String(result, StandardCharsets.UTF_8);
    }

    /**
     * 私钥加密
     *
     * @param privateKeyString 私钥
     * @param text             待加密的信息
     * @return 加密后的文本
     */
    public static String encryptByPrivateKey(String privateKeyString, String text) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(result);
    }

    /**
     * 私钥解密
     *
     * @param privateKeyString 私钥
     * @param text             待解密的文本
     * @return 解密后的文本
     */
    public static String decryptByPrivateKey(String privateKeyString, String text) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec5);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(text));
        return new String(result, StandardCharsets.UTF_8);
    }


    /**
     * 私钥解密
     *
     * @param text 私钥
     * @param text 待解密的文本
     * @return 解密后的文本
     */
    public static String decryptByPrivateKey(String text) throws Exception {
        return decryptByPrivateKey(privateKey, text);
    }


    /**
     * RSA密钥对对象
     */
    public static class RsaKeyPair {
        private final String publicKey;
        private final String privateKey;

        public RsaKeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }
    }
}

