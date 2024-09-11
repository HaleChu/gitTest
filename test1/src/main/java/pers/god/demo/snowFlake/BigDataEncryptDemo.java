package pers.god.demo.snowFlake;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author chuhao
 * @Date 2024/9/9
 * @Version 1.0.0
 */
public class BigDataEncryptDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("460101198001010010",
                "460101198001010037",
                "460101198001010053",
                "46010119800101007X",
                "460101198001010096",
                "460101198001010117",
                "460101198001010133",
                "46010119800101015X",
                "460101198001010176",
                "460101198001010192",
                "460101198001010213",
                "46010119800101023X",
                "460101198001010256",
                "460101198001010272",
                "460101198001010299",
                "46010119800101031X",
                "310108198910070522",
                "310104197603034089",
                "362326199001020068",
                "310109197911020828",
                "310108199204302829",
                "230606198206081767",
                "310109199406111525",
                "310109198210125023",
                "320222198001266549",
                "310230200101181460",
                "310107197704052824");
        String url = "https://shrctcpt.sh-italent.cn/talent-unified/api/talent-util/decryptdata/encrypt?source=";
        for (String s : list) {
            String result = HttpUtil.post(url + s, "");
            Map map = JSONObject.parseObject(result, Map.class);
            System.out.println(map.get("data").toString());
        }
    }
}
