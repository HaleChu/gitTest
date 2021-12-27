package pers.god.demo.authority;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/14
 */
public class ChocolateChip extends Cookie {

    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    public void chomp() {
        bite();
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
