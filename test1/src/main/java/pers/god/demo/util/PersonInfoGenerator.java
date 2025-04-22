package pers.god.demo.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 身份证生成
 */
public class PersonInfoGenerator {

    /**
     * 姓名
     */
    public static String generateRandomName() {
        String[] familyNames = {"王", "李", "张", "刘", "陈", "黄", "周", "吴", "郑", "徐",
                "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫",
                "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕",
                "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜",
                "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏",
                "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马",
                "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍",
                "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤",
                "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于",
                "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜",
                "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵",
                "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧",
                "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪",
                "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵",
                "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童",
                "颜", "郭", "梅", "盛", "林", "刁", "钟", "徐", "邱", "骆",
                "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万",
                "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪",
                "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单",
                "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "龚", "程",
                "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "於",
                "惠", "甄", "麴", "家", "封", "芮", "羿", "储", "靳", "汲",
                "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴",
                "弓", "牧", "隋", "山", "谷", "车", "侯", "宓", "蓬", "全",
                "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾",
                "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘", "景",
                "詹", "束", "龙"};
        String[] firstNames = {"芳", "燕", "雨", "晶", "婷", "瑶", "琪", "晨", "曼", "梦"};

        Random random = new Random();

        String familyName = familyNames[random.nextInt(familyNames.length)];
        String firstName = firstNames[random.nextInt(firstNames.length)];

        return familyName + firstName;
    }

    /**
     * 身份证
     */
    public static String generateRandomIDCard() {
        // Generate the first 17 digits
        StringBuilder idCardNumber = new StringBuilder();
        Random random = new Random();

        // Province code (2 digits)
        int provinceCode = random.nextInt(34);
        idCardNumber.append(String.format("%02d", provinceCode));

        // City code (2 digits)
        int cityCode = random.nextInt(34);
        idCardNumber.append(String.format("%02d", cityCode));

        // County code (2 digits)
        int countyCode = random.nextInt(34);
        idCardNumber.append(String.format("%02d", countyCode));

        // Birthdate (8 digits)
        int year = random.nextInt(100) + 1900;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        idCardNumber.append(String.format("%04d%02d%02d", year, month, day));

        // Sequence number (3 digits)
        idCardNumber.append(String.format("%03d", random.nextInt(1000)));

        // Sex code (1 digit)
        idCardNumber.append(String.valueOf(random.nextInt(2) == 0 ? 1 : 2));

        // Calculate the checksum
        int[] coefficients = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += (idCardNumber.charAt(i) - '0') * coefficients[i];
        }

        // Calculate the remainder
        int remainder = sum % 11;
        String[] checksums = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        idCardNumber.append(checksums[remainder]);

        return idCardNumber.toString();
    }

    /**
     * 手机号
     */
    public static String generateRandomPhoneNumber() {
        List<String> startCodeList = Arrays.asList("134", "135", "136", "137",
                "138", "139", "147", "150", "151", "152", "157", "158", "159",
                "182", "183", "187", "188", "178", "130", "131", "132", "155",
                "156", "185", "186", "133", "153", "177", "180", "181", "189");
        Random random = new Random();
        int index = random.nextInt(startCodeList.size());
        int endCode = random.nextInt(99999999);
        return startCodeList.get(index) + endCode;
    }
}

