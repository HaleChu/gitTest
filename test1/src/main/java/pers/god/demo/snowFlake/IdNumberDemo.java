package pers.god.demo.snowFlake;

import org.apache.commons.codec.digest.DigestUtils;
import pers.god.demo.util.PersonInfoGenerator;

/**
 * 身份证生成
 */
public class IdNumberDemo {

    public static void main(String[] args) {
//        String randomIDCard1 = PersonInfoGenerator.generateRandomIDCard();
//        System.out.println("Random ID Card: " + randomIDCard1);
//        System.out.println("MD5: " + MD5Util.toMD5String(randomIDCard1));
//        String randomIDCard2 = PersonInfoGenerator.generateRandomIDCard();
//        System.out.println("Random ID Card: " + randomIDCard2);
//        System.out.println("MD5: " + MD5Util.toMD5String(randomIDCard2));
//        String randomIDCard3 = PersonInfoGenerator.generateRandomIDCard();
//        System.out.println("Random ID Card: " + randomIDCard3);
//        System.out.println("MD5: " + MD5Util.toMD5String(randomIDCard3));
//        String randomIDCard4 = PersonInfoGenerator.generateRandomIDCard();
//        System.out.println("Random ID Card: " + randomIDCard4);
//        System.out.println("MD5: " + MD5Util.toMD5String(randomIDCard4));
//        String randomIDCard5 = PersonInfoGenerator.generateRandomIDCard();
//        System.out.println("Random ID Card: " + randomIDCard5);
//        System.out.println("MD5: " + MD5Util.toMD5String(randomIDCard5));

//        System.out.println(PersonInfoGenerator.generateRandomIDCard() + "," + PersonInfoGenerator.generateRandomPhoneNumber());
        String idCard = PersonInfoGenerator.generateRandomIDCard();
//        String idCard = "A12345678";
        System.out.println(idCard);
        System.out.println(DigestUtils.md5Hex(idCard));
//
//        String idNumber = "450417199608261491";
//        System.out.println(Integer.parseInt(idNumber.substring(idNumber.length() - 2, idNumber.length() - 1)));
    }
}

