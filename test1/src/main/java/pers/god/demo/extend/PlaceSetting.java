package pers.god.demo.extend;

/**
 * @Author chuhao
 * @Date 2022/1/12
 * @Version 1.0.0
 */
public class PlaceSetting extends Custom {

    private Spoon sp;
    private Fork fk;
    private Knife kn;
    private DinnerPlate dp;

    PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        fk = new Fork(i + 3);
        kn = new Knife(i + 4);
        dp = new DinnerPlate(i + 5);
        System.out.println("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        PlaceSetting placeSetting = new PlaceSetting(9);
    }
}

class Plate {
    Plate(int i) {
        System.out.println("Plate constructor");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate constructor");
    }
}

class Utensil {
    Utensil(int i) {
        System.out.println("Utensil constructor");
    }
}

class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        System.out.println("Spoon constructor");
    }
}

class Fork extends Utensil {
    Fork(int i) {
        super(i);
        System.out.println("Fork constructor");
    }
}

class Knife extends Utensil {
    Knife(int i) {
        super(i);
        System.out.println("Knife constructor");
    }
}

class Custom {
    Custom(int i) {
        System.out.println("Custom constructor");
    }
}