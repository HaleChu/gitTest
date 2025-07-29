package pers.god.demo.password;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * 3DES加密
 */
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


    public static void main(String[] args) {

        System.out.println(decryptByDES("ONteQluo3Ko="));

        //System.out.println(encodeByDES("ONteQluo3Ko="));

    }


}
