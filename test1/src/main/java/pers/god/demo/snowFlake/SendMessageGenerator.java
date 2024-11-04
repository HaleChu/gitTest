package pers.god.demo.snowFlake;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author chuhao
 * @Date 2024/9/7
 * @Version 1.0.0
 */
public class SendMessageGenerator {

    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("identificationNumber", "421102198602140515");
        map.put("serviceCode", "07");
        map.put("timestamp", System.currentTimeMillis());
        map.put("secretKey", "talentService");
        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(map));
        map.remove("secretKey");
        map.put("sign", sign);
        String publicKey = "044C783CD6450D1BCC626DDC8EC14D100E9C7F33FFC60CB0CD2C55CEF71653AD83963B87562E0658A50600F67B0130C6CDEB23C94A3D04E9F9CEF5A386BF364B4E";
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encrypted = sm2.encryptHex(JSONObject.toJSONString(map), KeyType.PublicKey);
        System.out.println(encrypted);
    }
}
