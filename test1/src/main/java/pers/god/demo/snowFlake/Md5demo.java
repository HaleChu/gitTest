package pers.god.demo.snowFlake;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author chuhao
 * @Date 2024/9/9
 * @Version 1.0.0
 */
public class Md5demo {

    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("userName", "谢兰俊");
        map.put("cardType", "1");
        map.put("gender", "1");
        map.put("uscc", "430725198812200334");
        map.put("loginName", "18621749060");
        map.put("talentLabel", "A");
        map.put("id", "324620d6-e274-40f2-b42d-ac215ba5e24c");
        String publicKey = "047254487f2c59cb0f0bc303bdc30d261f566ef7d14936bf4400f3943c00675201db695f0fe34057f2c03cf7c5797f73e1cf2e1b1566532e4f930657be7c56220f";
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encrypted = sm2.encryptHex(JSONObject.toJSONString(map), KeyType.PublicKey);
        System.out.println(encrypted);
    }
}
