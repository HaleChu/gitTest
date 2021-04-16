package pers.god.demo.generic;

public class ClassName<T> {

    void show1(T t) {
        System.out.println("show_1 " + t.toString());
    }

    <E> void show2(E e) {
        System.out.println("show_2 " + e.toString());
    }

    <T> void show3(T t) {
        System.out.println("show_3 " + t.toString());
    }

    public static void main(String[] args) {
        ClassName<Fruit> fruitClassName = new ClassName<>();
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Dog dog = new Dog();
        System.out.println("===== show1 =====");
        fruitClassName.show1(fruit);
        fruitClassName.show1(apple);
//        fruitClassName.show1(dog);
        System.out.println("===== show2 =====");
        fruitClassName.show2(fruit);
        fruitClassName.show2(apple);
        fruitClassName.show2(dog);
        System.out.println("===== show3 =====");
        fruitClassName.show3(fruit);
        fruitClassName.show3(apple);
        fruitClassName.show3(dog);
    }


}

class Fruit {

    public String toString() {
        return "fruit";
    }
}

class Apple extends Fruit {

    @Override
    public String toString() {
        return "apple";
    }
}

class Dog {
    public String toString() {
        return "dog";
    }
}
