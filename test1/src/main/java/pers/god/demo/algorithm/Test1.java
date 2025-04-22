package pers.god.demo.algorithm;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import pers.god.demo.util.PersonInfoGenerator;

/**
 * @Author chuhao
 * @Date 2024/12/17
 * @Version 1.0.0
 */
public class Test1 {

    public static void main(String[] args) {
        String idCard = PersonInfoGenerator.generateRandomIDCard();
        System.out.println(idCard);
        System.out.println(IdcardUtil.isValidCard18(idCard));
    }

    public static void dealWithBirthday(String A01004) {
        if (StrUtil.isNotBlank(A01004)) {
            int length = A01004.length();
            if (length == 7 && A01004.contains(".")) {//1979.11
                A01004 = A01004 + ".01";
            }
            if (length == 7 && A01004.contains("-")) {//1979-11
                A01004 = A01004 + "-01";
            }
            if (length == 6 && A01004.contains(".")) {//1965.1
                A01004 = A01004.replaceAll("\\.", ".0") + ".01";
            }
            if (length == 6 && A01004.contains("-")) {//1979-1
                A01004 = A01004.replaceAll("-", "-0") + "-01";
            }
            if (length == 4 && NumberUtil.isNumber(A01004)) {//1979
                A01004 += ".01.01";
            }
            DateTime A01004Date = DateUtil.parse(A01004);
            System.out.println(A01004Date);
        }
    }
}
