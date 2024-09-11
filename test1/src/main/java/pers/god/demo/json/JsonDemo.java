package pers.god.demo.json;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author chuhao
 * @Date 2024/9/4
 * @Version 1.0.0
 */
public class JsonDemo {

    public static void main(String[] args) {
        String uniqueCode = "A15675";
        String sortStr = (int) uniqueCode.charAt(0) + uniqueCode.substring(1);
        String newCodeSort = String.valueOf(Integer.parseInt(sortStr) + 1);
        uniqueCode = Character.toUpperCase((char) Integer.parseInt(newCodeSort.substring(0, newCodeSort.length() - 5))) + newCodeSort.substring(newCodeSort.length() - 5);
        System.out.println(uniqueCode);

        String idNumber = "46010119800101031X";
        System.out.println(DigestUtils.md5Hex(idNumber));
    }
}
