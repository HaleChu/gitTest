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
        map.put("identificationNumber", "430725198812200334");
//        map.put("serviceCode", "04");
        map.put("timestamp", System.currentTimeMillis());
        map.put("secretKey", "talentService");
        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(map));
        map.remove("secretKey");
        map.put("sign", sign);
        String publicKey = "049EB7BB5595EF635E6CBE43BA3B4A204BDE318D1AB3F37AC7582756FCE05072C3E26C64F425DB5E8F835BDEFA234F256FC2BD066AD1686B8B5B438B98DEF23F5B";
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encrypted = sm2.encryptHex(JSONObject.toJSONString(map), KeyType.PublicKey);
        System.out.println(encrypted);
    }
}
