package pers.god.demo.number;

import cn.hutool.extra.pinyin.PinyinUtil;
import pers.god.demo.util.PinyinNewUtil;

/**
 * @Author chuhao
 * @Date 2023/8/2
 * @Version 1.0.0
 */
public class PinyinTest {

    public static void main(String[] args) {
        String name = "单铭婕";
        System.out.println(PinyinUtil.getPinyin(name) + " " + PinyinUtil.getFirstLetter(name, ""));
        System.out.println(PinyinNewUtil.getPinyin(name) + " " + PinyinNewUtil.getFirstLetters(name, ""));

        String id = "4028816d7f8c6426017f8c781585062c";
        System.out.println(id.length());

        String s = "" + (char) 11;
        name = name + s;
        System.out.println(name);
        System.out.println(name.substring(0, name.length() - 1));
    }
}
