package pers.god.demo.arrays;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/11
 */
public class NewVarArgs {

    static void printArray(Object... args) {
        for (Object arg : args) {
            System.out.println(arg + "");
        }
    }

    public static void main(String[] args) {

        printArray(new Integer(47), new Float(3.14), new Double(11.11));
        printArray(47, 3.14F, 11.11);
        printArray("one", "two", "three");
        printArray(new A(), new A(), new A());
        printArray((Object[]) new Integer[]{1, 2, 3, 4});
        printArray();
    }
}

class A {

}
