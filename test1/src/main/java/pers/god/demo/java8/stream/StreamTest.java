package pers.god.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author chuhao
 * @Date 2022/1/11
 * @Version 1.0.0
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Children> col = Arrays.asList(
                new Children("小明", 20),
                new Children("小刚", 22),
                new Children("小红", 21),
                new Children("小名", 21),
                new Children("小健", 22));
        Map<Integer, List<Children>> map = col.stream().collect(Collectors.groupingBy(Children::getAge));

        map.forEach((age, list) -> {
            System.out.println("====================");
            System.out.println(age);
            System.out.println(list);
            System.out.println("====================");
        });
    }
}

class Children {

    private String name;
    private int age;

    public Children() {
    }

    public Children(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
