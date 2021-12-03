package pers.god.demo.coll;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/3
 */
public class LabeledFor {

    public static void main(String[] args) {

        System.out.println("============================================================");

        int i = 0;
        outer:
        for (; true; ) {
            inner:
            for (; i < 10; i++) {
                System.out.println("i=" + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println(" break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }

        System.out.println("============================================================");

        for (int l = 0; l < 2; l++) {
            System.out.println("i:" + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("j:" + j);
                if (j == 5) {
                    break;
                }
            }
        }

        System.out.println("============================================================");

        int a = 1;
        System.out.println((char) (a + 'a'));

        System.out.println("============================================================");

        StringInitial stringInitial = new StringInitial();
        System.out.println("StringInitial:" + stringInitial.a);

        StringNotInitial stringNotInitial = new StringNotInitial();
        System.out.println("StringNotInitial:" + stringNotInitial.a);

        System.out.println("============================================================");

        StringInitial stringInitial1 = new StringInitial();
        System.out.println(stringInitial1.a);
    }
}

class StringInitial {

    String a = "a";

    public StringInitial() {
    }
}

class StringNotInitial {

    String a;

    public StringNotInitial() {
    }
}
