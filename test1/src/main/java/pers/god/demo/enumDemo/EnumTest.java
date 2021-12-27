package pers.god.demo.enumDemo;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/13
 */
public class EnumTest {

    public static void main(String[] args) {

        Spiciness not = Spiciness.NOT;
        Spiciness mild = Spiciness.MILD;
        Spiciness medium = Spiciness.MEDIUM;
        Spiciness hot = Spiciness.HOT;
        Spiciness flaming = Spiciness.FLAMING;
        System.out.println(not);
        System.out.println(mild);
        System.out.println(medium);
        System.out.println(hot);
        System.out.println(flaming);

        System.out.println("====================foreach====================");

        for (Spiciness spiciness : Spiciness.values()) {
            System.out.println(spiciness);
        }
    }
}
