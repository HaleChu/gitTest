package pers.god.demo.domain;

public class Person {

    private String name;
    private Integer age;
    private String gender;

    public Person() {
        System.out.println("*****空参构造方法被调用*****");
    }

    public Person(String name, Integer age) {
        System.out.println("*****带参构造方法被调用*****");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private Person(String name, Integer age, String gender) {
        System.out.println("*****私有带参构造方法被调用*****");
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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


}
