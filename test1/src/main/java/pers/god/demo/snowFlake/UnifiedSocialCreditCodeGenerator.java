package pers.god.demo.snowFlake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 社会统一信用代码生成
 */
public class UnifiedSocialCreditCodeGenerator {

    //登记管理部门代码和机构类别代码参考标准可以得到一下枚举值
    private static String[] orgType = new String[]{"11", "12", "13", "19", "51", "52", "53", "59", "91", "92", "93", "Y1"};
    //存放地区编码
    private static Map<String, String> areaCodes;
    private static final Map<String, Integer> socialIdIndex = new HashMap<String, Integer>();
    //编码中不能含有ISOVZ，猜测是看上去容易混淆的字符不使用，比如字母O和数字0
    private static final String[] socialBasic = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "J", "K",
            "L", "M", "N", "P", "Q", "R", "T", "U", "W", "X", "Y"};
    //组织结构校验码权重
    private static final int[] orgCodeWeight = {3, 7, 9, 10, 5, 8, 4, 2};
    //统一社会信用代码权重
    private static final int[] socialIdWeight = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
    //用于生成随机数
    public static Random random = new Random();

    static {
        for (int i = 0; i < socialBasic.length; i++) {
            socialIdIndex.put(socialBasic[i], i);
        }
    }

    public static String getSocialCode() throws ClassNotFoundException {
        String res = "";
        res += getOrgType();
        res += getAreaCode();
        String orgCode = getOrgCode();
        String orgCheckCode = getOrgCheckCode(orgCode);
        res += orgCode + orgCheckCode;
        res += getSocialCheckCode(res);
        return res;
    }

    //得到前两位，即登记管理部门代码和机构类别代码
    private static String getOrgType() {
        int len = orgType.length;
        return orgType[random.nextInt(len)];
    }

    //得到最后一位（第18位）校验码
    private static String getSocialCheckCode(String res) {
        int checkCode = 0;
        for (int i = 0; i < res.length(); i++) {
            checkCode += socialIdIndex.get(res.substring(i, i + 1)) * socialIdWeight[i];
        }
        checkCode = 31 - checkCode % 31;
        if (checkCode == 31) {
            return "0";
        } else if (checkCode == 30) {
            return "Y";
        } else {
            return socialBasic[checkCode];
        }
    }

    //得到倒数第二位（第17位）组织机构代码校验码
    private static String getOrgCheckCode(String orgCode) {
        int checkCode = 0;
        for (int i = 0; i < orgCode.length(); i++) {
            checkCode += Integer.parseInt(orgCode.substring(i, i + 1), 36) * orgCodeWeight[i];
        }
        checkCode = 11 - checkCode % 11;
        if (checkCode == 11) {
            return "0";
        } else if (checkCode == 10) {
            return "X";
        } else {
            return checkCode + "";
        }
    }

    //组织机构代码（第9~16位）：8位随机码，
    private static String getOrgCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(socialBasic[random.nextInt(31)]);
        }
        return sb.toString();
    }

    //第3-8位登记管理机关行政区域码 GB/T 2260（读取2014.txt中的所有区域码）
    private static String getAreaCode() throws ClassNotFoundException {
        InputStream inputStream = Class.forName("pers.god.demo.snowFlake.UnifiedSocialCreditCodeGenerator").getResourceAsStream("/data/2014.txt");
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        areaCodes = new HashMap<>();
        try {
            while (r.ready()) {
                String line = r.readLine();
                String[] split = line.split("\t");
                String code = split[0];
                String name = split[1];
                areaCodes.put(code, name);
            }
        } catch (IOException e) {
            System.err.println("Error in loading GB2260 data!");
            throw new RuntimeException(e);
        }
        //利用list获取map中的随机值
        List<String> cods = new ArrayList<>(areaCodes.keySet());
        return cods.get(random.nextInt(areaCodes.size()));
    }


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(UnifiedSocialCreditCodeGenerator.getSocialCode());
    }
}

