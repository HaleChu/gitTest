package pers.god.demo.snowFlake;

import com.hazelcast.internal.util.MD5Util;
import pers.god.demo.password.PasswordEncoderHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Sm2Demo2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        KeyPair pair = SecureUtil.generateKeyPair("SM2");
//        String privateKey = Base64.encode(pair.getPrivate().getEncoded());
//        String publicKey = Base64.encode(pair.getPublic().getEncoded());
//        System.out.println("私钥:" + privateKey);
//        System.out.println("公钥:" + publicKey);
//
//        String data = "ABcd1234";
//        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);
//        String encryptBase64 = sm2.encryptBase64(data, KeyType.PublicKey);
//        System.out.println(encryptBase64);
//
//        String source = sm2.decryptStr(encryptBase64, KeyType.PrivateKey);
//        System.out.println(source);

        System.out.println(System.currentTimeMillis());

        String str = "{\"handleTime\":\"1724246505387\",\"sourceLabel\":\"GMGROUP\",\"sign\":\"a3588d00c35423f0c8422067fa28f601\",\"identificationNumber\":\"34F905428B0B5931F5C706B50E38FFDC\",\"handleStatus\":\"完成\",\"productName\":\"【套餐一】2024年浦发银行元旦套餐\",\"timestamp\":1724831778175}";
        System.out.println(URLEncoder.encode(str, "utf-8"));

        String str2 = "";
        System.out.println(URLEncoder.encode(str2, StandardCharsets.UTF_8.toString()));

        String password = "YznhZjDGhI7StUEBvTG9qB3QoV1NfChgOYZxp1Uz+qbu5MFSHdNILinpPSsQAG7JQbVSOPwGRY1st2/Oir9KE4H6vO0+ZBt1OqJzmrtRjKXyVydNZTqo5U9AXV3bxvZdO4sc5JbQcPuwokgB1gh2whKvQOJIrLfHbJkELquT0FqHdLjOB4gKcRJNM0EdQYnpab8yfGa5/eqYFnbPmqtznnCFgbE/xxNFrVjTCeP7LOUzwQIcxGfAxt05Nvo1Xget4I6aqPXRGh5hwyL/l9J4NC0Qk0C4xhDU6UJ1s/HSNLM63AG20F0V8qJBrypPAofnwf0K8xna48kf+Wwk8Smphm2s/G+MDYAMZKo+Dk8qp2l/CEN2aDoMepQxRRDXfCGPa9vENbjEzYUAObSzmmTbhA==";
        String decrypted = PasswordEncoderHelper.decryptByDES(password);
        System.out.println(decrypted);

        System.out.println(MD5Util.toMD5String("420300196803040332"));
    }
}
