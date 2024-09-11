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
        map.put("timestamp", System.currentTimeMillis());
        map.put("secretKey", "talentService");
        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(map));
        map.remove("secretKey");
        map.put("sign", sign);
        String publicKey = "047698C0BA2DB2CEEB53BF7A09E44F01F95EF58CAFD2774CCF089F5345AC1E0B7B0ECDC7C076FDAD7227D4CB5C337D3D470B093C62C52FDD7F070CA5307059C86F";
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encrypted = sm2.encryptBase64(JSONObject.toJSONString(map), KeyType.PublicKey);
        System.out.println(encrypted);
    }
}
