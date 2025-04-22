package pers.god.demo.aspose;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 短信API
 * 执行main函数即可体验短信产品API功能
 */
public class SelfPhoneMessageUtils {

    private static final Logger log = LoggerFactory.getLogger(SelfPhoneMessageUtils.class);

    public static class TextMessagesInfo {
        /**
         * 手机号
         */
        private String phone;

        /**
         * 内容
         */
        private String content;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static final String GET_URL = "http://47.105.34.115:8888";//dc.28inter.com
    private final static String USER_ID = "2333";
    // 短信账户密码
    private static final String PASSWORD = "shhjyc2024!";
    private final static String USERNAME = "shhjyc";


    public static void main(String[] args) {
        TextMessagesInfo textMessagesInfo = new TextMessagesInfo();
        textMessagesInfo.setPhone("15221068706");
        textMessagesInfo.setContent("【上海人才申报统筹平台】您的验证码为：" + "666666" + "，本验证码5分钟有效，请妥善保管！");
        String send = SelfPhoneMessageUtils.send(textMessagesInfo);
        System.out.println(send);
    }


    public static String send(TextMessagesInfo textMessages) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = sdf.format(new Date());

            String content = textMessages.getContent();
            String sign = DigestUtil.md5Hex(USERNAME + PASSWORD + time);

            //@formatter:off
            String requestUrl = GET_URL + "/v2sms.aspx?action=send&rt=json"
                                        + "&userid=" + USER_ID
                                        + "&timestamp=" + time
                                        + "&sign=" + sign
                                        + "&mobile=" + textMessages.getPhone()
                                        + "&content=" + URLEncoder.encode(content, "utf-8")
                                        + "&sendTime=&extno=";
            //@formatter:on

            HttpRequest request = HttpUtil.createPost(requestUrl);
            HttpResponse response = request.execute();
            return response.body();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    /**
     * 短信加密
     */
    public static String getSign(String time) {
        String str = USERNAME + PASSWORD + time;
        try {

            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++)
                byteArray[i] = (byte) charArray[i];
            byte[] md5Bytes = messagedigest.digest(byteArray);
            StringBuilder hexValue = new StringBuilder();
            for (final byte md5Byte : md5Bytes) {
                int val = ((int) md5Byte) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }

            return hexValue.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密失败");
        }
    }

}
