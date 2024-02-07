package pers.god.demo.number;

import cn.hutool.crypto.SmUtil;
import cn.hutool.extra.pinyin.PinyinUtil;

import java.util.Locale;

/**
 * @Author chuhao
 * @Date 2023/2/15
 * @Version 1.0.0
 */
public class IKSegmentTest {

    public static void main(String[] args) {
        String s = "ccl780926";
        System.out.println(s);
        System.out.println(SmUtil.sm3(s));

        String str = "9dff5c54c701c571b5aee90b42eeb1fa3644f626cd7294cb945ed42dc5255a22";

        String name = "仇丹东";
        String idNumber = "320625197806082161";
        String pinyin = PinyinUtil.getFirstLetter(name.trim(), "");
        String pinyinCode = pinyin.substring(0, 1).toUpperCase(Locale.ROOT) + pinyin.substring(1);
        String password = pinyinCode + "@" + idNumber.substring(idNumber.length() - 6);
        System.out.println(password);
        System.out.println(SmUtil.sm3(password));
    }
}
