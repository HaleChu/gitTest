package pers.god.demo.business;

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
public class BigDataDecryptDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<String> list = Arrays.asList(
                "[{\"uuid\":{\"destroyed\":false,\"keyIndex\":0,\"format\":\"RAW\",\"algorithm\":\"SM4\",\"encoded\":\"1Yw9dPm3DueBJLJS0wmrMQ==\"}},{\"encode\":\"F2143663552A87E59C44F1ACF4521EB0\"},{\"b64SignedData\":\"4BCsY+mDNCuDiigbZ901K9GPtzsxN3LrM1r0CijHrdTSyjOFrZfgNa0Je2gm9Y5eRi3cXH2Fq+3lHDElSF1AMA==\"}] ");
        String url = "https://shrctcpt.sh-italent.cn/talent-unified/api/talent-util/decryptdata/decryptDataAndVerifySigned?encode=";
        for (String s : list) {
            String urlString = url + URLEncoder.encode(s, "utf-8");
            String result = HttpUtil.post(urlString, "");
            Map map = JSONObject.parseObject(result, Map.class);
            String password = map.get("data").toString().trim();
            System.out.println(password);
        }
    }
}
