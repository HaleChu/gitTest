package pers.god.demo.snowFlake;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

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
        map.put("mobile", "15221068706");
        map.put("content", "【上海人才统筹平台】短信测试");
        map.put("timestamp", System.currentTimeMillis());
        map.put("secretKey", "talentService");
        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(map));
        map.remove("secretKey");
        map.put("sign", sign);
        String publicKey = "040DBD360F38FA09FFAC35829D3E3F8AFDA24A19926C01ECD48BEF1A21535E04306701669CBE6EEC67A5D8A20350050EFCB16805D01784F0817BD7EF635B3E3B1B";
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encrypted = sm2.encryptHex(JSONObject.toJSONString(map), KeyType.PublicKey);
        System.out.println(encrypted);
    }
}
