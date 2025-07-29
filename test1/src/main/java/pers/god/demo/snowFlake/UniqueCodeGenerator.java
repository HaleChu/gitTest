package pers.god.demo.snowFlake;

/**
 * @Author chuhao
 * @Date 2024/9/5
 * @Version 1.0.0
 */
public class UniqueCodeGenerator {

    public static void main(String[] args) {
//        Random random = new Random();
//        char firstLetter = Character.toUpperCase((char) (97 + random.nextInt(26)));
//        int randomNumber = random.nextInt(8999) + 1000;
//        System.out.println(String.valueOf(firstLetter) + randomNumber);

        for (int i = 201; i < 250; i++) {
            if (i < 10) {
                System.out.println("A0000" + i);
            } else if (i < 100) {
                System.out.println("A000" + i);
            } else if (i < 1000) {
                System.out.println("A00" + i);
            } else {
                System.out.println("A0" + i);
            }
        }

//        System.out.println(Character.toUpperCase((char) 96));
//        System.out.println(Character.toUpperCase((char) 95));
//        System.out.println(Character.toUpperCase((char) 97));
//        System.out.println(Character.toUpperCase((char) 122));
//        System.out.println(Character.toUpperCase((char) 121));
//        System.out.println(Character.toUpperCase((char) 123));

//        String maxUniqueCode = "A0547";
//        String sortStr = (int) maxUniqueCode.charAt(0) + maxUniqueCode.substring(1);
//        String newCodeSort = String.valueOf(Integer.parseInt(sortStr) + 1);
//        System.out.println(Character.toUpperCase((char) Integer.parseInt(newCodeSort.substring(0, newCodeSort.length() - 4))) + newCodeSort.substring(newCodeSort.length() - 4));
    }
}
