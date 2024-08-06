package pers.god.demo.snowFlake;

import cn.hutool.core.util.CharsetUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by rain chen on 2017/12/21.
 *
 * @author rain chen
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
     * 短信账户密码
     */
    private static final String SMS = "shrcbbzsdb2019jhh";
//    private static final String SMS = "testmima";

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
            System.out.println(sInfo);
            byte[] decryptBytes = Base64.getDecoder().decode(sInfo);
            cipherByte = decryptCipher.doFinal(decryptBytes);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            System.out.println("=================================解密失败:" + e.getMessage());
            throw new RuntimeException("解密失败");
        }
        return new String(cipherByte, StandardCharsets.UTF_8);
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

    /**
     * MD5加密
     *
     * @param password 原始密码
     * @return MD5加密后的密码
     */
    public static String md5Encode(String password) {
        if (encryptCipher == null) {
            throw new RuntimeException("加密工具初始化失败");
        }
        String encode = "";
        if (password == null) return null;
        try {

            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            byte strBytes[] = password.getBytes();

            messagedigest.update(strBytes);
            byte digestBytes[] = messagedigest.digest();
            int k = 0;
            char digestChars[] = new char[digestBytes.length * 2];

            for (int l = 0; l < digestBytes.length; l++) {
                int i1 = digestBytes[l];

                if (i1 < 0)
                    i1 = 127 + i1 * -1;
                encodeInt(i1, k, digestChars);
                k += 2;
            }

            return new String(digestChars, 0, digestChars.length);


        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密失败");
        }

    }

    /**
     * RSA解密
     */
    public static String passwordRsaDecrypt(String ciphertext) {
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALUoaR4M5UGYjXuwNY3evXGr+1czzM/eFGS516Oxtqp4i85XZNKI5wkomqpjQ5F9VDh5HP2ksz/RW0t8/8t514WAgatAsU39T9lLqOrnLdiJ9y/OHr7wQsWvaG0lTPg9g+Zu3pVJjueydcA85ZocR9kvvEc+EYmMr/WMRG9lZ8OlAgMBAAECgYAEAlRMGWyupIhyJasFveCod9GVrDU3O3O0QNhMU6J6D0QOzSh+IbsYwG4YfYJjDBMjxOsPsID/lWu3DtKmQ8bjWxzmoXhlO7hdaHEr6UH1lv7XlkhhD4kwxTRFPUVu3QMb3H4Pq9OF+oXPgsdWSxy83Q7kVrRd9gWhbER2NL2ywQJBAOMgrQirPdYezaK1Y2MXOkaZeUkelmJ5wD0EUd/NvdUANUiLbuy7jHqj9lA5qi2TtiUmO4lO7oCtPfxsorOTW8ECQQDML8IgP9VdiyZWP457HT1aiPAaTsGrcrk70sWsLKmaZcHNUJiO9/ALkWWQZ46i9iy3dvbYr/Rxc7xhQqe8ArDlAkBbyLSkMC9I/CG1gv+q55QRO6wbtFSpbvIUtk4v1wDDttXRfydQW2ollWTQfr0atfqBgLXGgzM2pMvL2krVrtMBAkBKuW+hvbqn8TSme7v48kpxx4uXFRtrUyDW89vDltS63GKAcO5j4/jFQwCYSE269byHp9HOmxYqLuDR90LLW3DBAkB++XCstmMwVzAKjDjjaHAqvYlCiEuHlBXRQSCX97vpFwx+N4KZFjppFX6x+d0y6HYG+PW3uc7683waSzlT/jAp";
        try {
            String decrypt = AlipaySignature.rsaDecrypt(ciphertext, privateKey, CharsetUtil.UTF_8);
            return decrypt;
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 短信加密
     *
     * @param str
     * @return
     */
    public static String md5Sms(String str) {
        if (encryptCipher == null) {
            throw new RuntimeException("加密工具初始化失败");
        }
        String encode = "";
        if (str == null) return null;
        str = SMS + str;
        try {

            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            byte strBytes[] = str.getBytes();

            char[] charArray = str.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++)
                byteArray[i] = (byte) charArray[i];
            byte[] md5Bytes = messagedigest.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }


            return hexValue.toString();


        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密失败");
        }

    }

    /**
     * 科委专利 加密
     *
     * @param body
     * @return
     */
    public static String kwRsaEncrypt(String body) {
        /**
         * 科委加密公钥
         */
        String kwPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQbyeSsNaEiK6DsEQ8IFM0cE55fKvCI0DQtBBF1v5ajv0oA0rzhvAV+QJoD93GnTzukOsq/UBW5WcHu/AHKn/BdzJcGwHfmDDMOfVIruu8sJDs8R/Sys39CPmajQAMOUYtXCmWAqVi0uqta+qlX5xRg7l4qK3dahQYUvuslKAVGQIDAQAB";
        try {
            String rsaEncrypt = AlipaySignature.rsaEncrypt(body, kwPublicKey, "utf-8");
            return rsaEncrypt;
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 科委专利 解密
     *
     * @param body
     * @return
     */
    public static String kwRsaDecrypt(String body) {
        /**
         * 科委解密私钥
         */
        String kwPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIku4IgCpuc7V66e+Cne9vL7azRGek2rc4U2khCpK25NUht526WBLaYQ8BKL2Tl4eVzmfsyUdkzF01GUHOjzURVrttUJ1L2fDaQw80mgotRfREDw0UhimRdqShwPAKXUnyQ1a43V0zBA5nsk9lAlp6v1oBj+27ZpWkkb4IpNtAdFAgMBAAECgYA8aHsRCXHrovMSfwgyj+9YwiPMCjjzGMuu3n/lfEkWsk+0r61sLP0oAo9k61ZFe2qd4RX3Cm0pk3dhlgJBBlwumHuX+E+i15gWJT/RBLzulJx6yUMs8SZsfLIyswHIuNUzhuCFk0GwzcHtG1w9VyQkklhUGebsCZbhKmNfdSsipQJBAMCiYmf4c+fdWBOJt+G094XKzchNtkB4QALBR9boJlbyOOqT4U/dNlPUb8PMs2GDfqhSML0lOL4Zg7hKWbpvtqMCQQC2TvtLnTBul2LfybClf0uWMsg9VXfIzkjuSJDlvprFksPaOnIBUI37s2CbWfOZJkgofeKPRPI+Tbl24nPhpvD3AkEAnHIE652bPF7GTi/V2Afp0o3vbFK4xkki61nfp0ipAon78X8iSINGwPRRxLn1oSdy8O63SJX3LGR6VmyDzOc3cwJATvlr9teDMYU2+ca/VRINxmT9RUSO/VgPU9nvmva0yT3IxfJnjJY+y3hrMyEGW6Ovwoq16GZvofm9i/iRRoExBQJAAjc8qZDi9PM0TrNc75V/xfUatKl52QWiCSFHn8biPYtKn02a3ZRnhp+Dk2UNRXSlnveULMa/tqI5MQ1VYleD6Q==";
        try {
            String decrypt = AlipaySignature.rsaDecrypt(body, kwPrivateKey, "utf-8");
            return decrypt;
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static char[] encodeInt(int i, int j, char digestChars[]) {
        if (i < 16) {
            digestChars[j] = '0';
        }
        j++;
        do {
            digestChars[j--] = hexChar[i & 0xf];
            i >>>= 4;
        } while (i != 0);
        return digestChars;
    }
}
