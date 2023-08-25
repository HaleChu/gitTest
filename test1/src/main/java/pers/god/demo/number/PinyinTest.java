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

    }
}
