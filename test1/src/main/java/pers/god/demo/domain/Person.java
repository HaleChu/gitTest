package pers.god.demo.domain;

public class Person {

    private String name;
    private int age;
    private String gender;

    public Person() {
        System.out.println("*****空参构造方法被调用*****");
    }

    private Person(String name, int age) {
        System.out.println("*****私有带参构造方法被调用*****");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, int age, String gender) {
        System.out.println("*****公共带参构造方法被调用*****");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void talk() {
        System.out.println("*****公共方法talk()被调用*****");
    }

    private void run() {
        System.out.println("*****私有方法run()被调用*****");
    }
}
