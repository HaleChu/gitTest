package pers.god.demo.extend;

/**
 * @Author chuhao
 * @Date 2022/1/12
 * @Version 1.0.0
 */
public class Chess extends BoardGame {
    Chess(int i) {
        super(i);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess chess = new Chess(1);
    }
}

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(1);
        System.out.println("BoardGame constructor");
    }
}