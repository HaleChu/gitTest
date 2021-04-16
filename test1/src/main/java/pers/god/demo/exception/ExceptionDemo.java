package pers.god.demo.exception;

public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println(getMessage());

    }

    private static String getMessage() {
        String msg = "操作成功";
        try {
            String i = "操作一次";
//            int j = 1/0;
            return i;
        } catch (Exception e) {
            msg = "操作失败";
        }
        return msg;
    }
}
