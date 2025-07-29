package pers.god.demo.util;

import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.dictionary.py.PinyinDictionary;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author chuhao
 * @Date 2023/8/2
 * @Version 1.0.0
 */
public class PinyinNewUtil {
    /**
     * 获取中文完整拼音
     *
     * @param chineseStr
     * @return
     */
    public static String getPinyin(String chineseStr) {
        List<Pinyin> pinyins = PinyinDictionary.convertToPinyin(chineseStr);
        StringBuilder stringBuilder = new StringBuilder();
        for (Pinyin pinyin : pinyins) {
            stringBuilder.append(pinyin.getPinyinWithoutTone());
        }
        return stringBuilder.toString();
    }


    /**
     * 获取中文拼音首字母
     *
     * @param chineseStr
     * @return
     */
    public static String getInitial(String chineseStr) {
        List<Pinyin> pinyins = PinyinDictionary.convertToPinyin(chineseStr);
        if (CollectionUtils.isEmpty(pinyins)) {
            return StringUtils.EMPTY;
        }
        return String.valueOf(pinyins.get(0).getPinyinWithoutTone().charAt(0));
    }

    /**
     * 获取中文拼音首字母
     */
    public static String getFirstLetters(String chineseStr, String separator) {
        List<Pinyin> pinyinList = PinyinDictionary.convertToPinyin(chineseStr);
        if (CollectionUtils.isEmpty(pinyinList)) {
            return StringUtils.EMPTY;
        }
        return pinyinList.stream().map(pinyin -> String.valueOf(pinyin.getFirstChar())).collect(Collectors.joining(separator));
    }

}
