package pers.god.demo.initialization;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/10
 */
public class OrderOfInitialization {

    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}

class Window {
    Window(int maker) {
        System.out.println("Window(" + maker + ")");
    }
}

class House {
    Window w1 = new Window(1);

    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);
}
