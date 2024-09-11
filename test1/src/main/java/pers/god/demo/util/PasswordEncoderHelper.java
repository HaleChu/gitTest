package pers.god.demo.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class PasswordEncoderHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordEncoderHelper.class);

    /**
     * 采用的加密算法
     */
    private static final String ENCODING_ALGORITHM = "DESede";
    /**
     * 加密解密的密钥
     */
    private static final String PASSWORD_CRYPT_KEY = "sinosoft64248319,,llxf491,,123ofsja@l123";

    /**
     * 加密对象
     */
    private static Cipher encryptCipher = null;

    /**
     * 解密对象
     */
    private static Cipher decryptCipher = null;

    /**
     * 初始化3DES加密，解密对象
     */
    private static void initDES() {
        try {
            // 密钥对象
            SecretKey secretKey = new SecretKeySpec(build3DesKey(), ENCODING_ALGORITHM);
            // 加密工具始化
            encryptCipher = Cipher.getInstance(ENCODING_ALGORITHM);
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // 解密工具初始化
            decryptCipher = Cipher.getInstance(ENCODING_ALGORITHM);
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            LOGGER.warn("加密/解密算法不存在", e);
        } catch (InvalidKeyException e) {
            LOGGER.warn("加密/解密密钥异常", e);
        }
    }

    /**
     * 根据字符串生成密钥字节数组
     */
    private static byte[] build3DesKey() {
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp = PASSWORD_CRYPT_KEY.getBytes(StandardCharsets.UTF_8);    //将字符串转成字节数组
        /*
         * 执行数组拷贝
         * System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
         */
        if (key.length > temp.length) {
            // 如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            // 如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }

    /**
     * 3DES加密
     */
    public static String encodeByDES(String str) {
        initDES();
        if (encryptCipher == null) {
            throw new RuntimeException("加密工具初始化失败");
        }
        if (!StringUtils.hasText(str)) {
            throw new NullPointerException("加密字段为空");
        }
        // 定义要生成的密文
        byte[] cipherByte;
        // 对要加密的内容进行编码处理,
        try {
            cipherByte = encryptCipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException("加密失败");
        }
        // 返回密文的十六进制形式
        return Base64.encodeBase64String(cipherByte);
    }

    /**
     * 3DES解密
     */
    public static String decryptByDES(String encryptInfo) {
        initDES();
        if (decryptCipher == null) {
            throw new NullPointerException("解密工具初始化失败");
        }
        if (!StringUtils.hasText(encryptInfo)) {
            throw new NullPointerException("解密字段为空");
        }
        byte[] cipherByte = new byte[0];
        // 对要解密的内容进行编码处理
        try {
            byte[] decryptBytes = Base64.decodeBase64(encryptInfo);
            cipherByte = decryptCipher.doFinal(decryptBytes);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return new String(cipherByte, StandardCharsets.UTF_8);
    }

    /**
     * RSA加密
     */
    public static String dataRsaEncrypt(String parameter) {
        String kwPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1KGkeDOVBmI17sDWN3r1xq/tXM8zP3hRkudejsbaqeIvOV2TSiOcJKJqqY0ORfVQ4eRz9pLM/0VtLfP/LedeFgIGrQLFN/U/ZS6jq5y3Yifcvzh6" +
                "+8ELFr2htJUz4PYPmbt6VSY7nsnXAPOWaHEfZL7xHPhGJjK/1jERvZWfDpQIDAQAB";
        try {
            return AlipaySignature.rsaEncrypt(parameter, kwPublicKey, Charsets.UTF_8.name());
        } catch (AlipayApiException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * RSA解密
     */
    public static String dataRsaDecrypt(String parameter) {
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALUoaR4M5UGYjXuwNY3evXGr+1czzM/eFGS516Oxtqp4i85XZNKI5wkomqpjQ5F9VDh5HP2ksz/RW0t8/8t514WAgatAsU39T9lLqOrnLdiJ9y" +
                "/OHr7wQsWvaG0lTPg9g+Zu3pVJjueydcA85ZocR9kvvEc+EYmMr/WMRG9lZ8OlAgMBAAECgYAEAlRMGWyupIhyJasFveCod9GVrDU3O3O0QNhMU6J6D0QOzSh+IbsYwG4YfYJjDBMjxOsPsID" +
                "/lWu3DtKmQ8bjWxzmoXhlO7hdaHEr6UH1lv7XlkhhD4kwxTRFPUVu3QMb3H4Pq9OF+oXPgsdWSxy83Q7kVrRd9gWhbER2NL2ywQJBAOMgrQirPdYezaK1Y2MXOkaZeUkelmJ5wD0EUd" +
                "/NvdUANUiLbuy7jHqj9lA5qi2TtiUmO4lO7oCtPfxsorOTW8ECQQDML8IgP9VdiyZWP457HT1aiPAaTsGrcrk70sWsLKmaZcHNUJiO9/ALkWWQZ46i9iy3dvbYr/Rxc7xhQqe8ArDlAkBbyLSkMC9I/CG1gv" +
                "+q55QRO6wbtFSpbvIUtk4v1wDDttXRfydQW2ollWTQfr0atfqBgLXGgzM2pMvL2krVrtMBAkBKuW+hvbqn8TSme7v48kpxx4uXFRtrUyDW89vDltS63GKAcO5j4" +
                "/jFQwCYSE269byHp9HOmxYqLuDR90LLW3DBAkB++XCstmMwVzAKjDjjaHAqvYlCiEuHlBXRQSCX97vpFwx+N4KZFjppFX6x+d0y6HYG+PW3uc7683waSzlT/jAp";
        try {
            return AlipaySignature.rsaDecrypt(parameter, privateKey, Charsets.UTF_8.name());
        } catch (AlipayApiException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
            return "";
        }
    }

}
