package pers.god.demo.snowFlake;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author chuhao
 * @Date 2024/9/9
 * @Version 1.0.0
 */
public class BigDataEncryptDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<String> list = Arrays.asList("[{\"uuid\":{\"destroyed\":false,\"keyIndex\":0,\"format\":\"RAW\",\"algorithm\":\"SM4\",\"encoded\":\"TX7VYcZHMX+cwKEeVJX8NA==\"}},{\"encode\":\"8C3BC333B01C3C9ABF96CABE8C167C3E\"}]");
        String url = "https://shrctcpt.sh-italent.cn/talent-unified/api/talent-util/decryptdata/decryptData?encode=";
        for (String s : list) {
            String urlString = url + URLEncoder.encode(s, "utf-8");
            String result = HttpUtil.post(urlString, "");
            Map map = JSONObject.parseObject(result, Map.class);
            System.out.println(map.get("data").toString().trim());
        }
    }
}
