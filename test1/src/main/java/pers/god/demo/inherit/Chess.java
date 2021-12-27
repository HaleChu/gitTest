package pers.god.demo.inherit;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/15
 */
public class Chess extends BoardGame {
    Chess() {
        super(1);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }
}

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}
