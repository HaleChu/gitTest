package pers.god.demo.password;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by maqidong 2018/8/21.
 *
 * @author maqidong
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2017. SinoSoft All Rights Received
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
     * 密钥对象
     */
    private static SecretKey secretKey = null;

    /**
     * 加密对象
     */
    private static Cipher encryptCipher = null;

    /**
     * 解密对象
     */
    private static Cipher decryptCipher = null;

    static {
        try {
            // 初始化日志
            secretKey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), ENCODING_ALGORITHM);
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
     * 加密密码
     *
     * @param password 原始密码
     * @return 加密后的密码
     */
    public static String encode(String password) {
        if (encryptCipher == null) {
            throw new RuntimeException("加密工具初始化失败");
        }
        // 定义要生成的密文
        byte[] cipherByte;
        // 对要加密的内容进行编码处理,
        try {
            cipherByte = encryptCipher.doFinal(password.getBytes("UTF-8"));
        } catch (IllegalBlockSizeException | UnsupportedEncodingException | BadPaddingException e) {
            throw new RuntimeException("加密失败");
        }
        // 返回密文的十六进制形式
        return new String(Base64.getEncoder().encode(cipherByte));
    }

    /**
     * 根据密匙进行DES解密
     *
     * @param sInfo 要解密的密文
     * @return String 返回解密后信息
     */
    public static String decryptByDES(String sInfo) {
        if (decryptCipher == null) {
            throw new RuntimeException("解密工具初始化失败");
        } else if (!StringUtils.hasText(sInfo)) {
            throw new RuntimeException("解密密码为空");
        }
        byte[] cipherByte;
        // 对要解密的内容进行编码处理
        try {
            byte[] decryptBytes = Base64.getDecoder().decode(sInfo);
            cipherByte = decryptCipher.doFinal(decryptBytes);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new RuntimeException("解密失败");
        }
        return new String(cipherByte);
    }

    /**
     * 根据字符串生成密钥字节数组
     *
     * @param keyStr 密钥字符串
     */
    private static byte[] build3DesKey(String keyStr) {
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp = keyStr.getBytes(Charset.forName("UTF-8"));    //将字符串转成字节数组
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
}
