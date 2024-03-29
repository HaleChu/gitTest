package pers.god.demo.java8.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * Java8 stream
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("aaa", "bbb", "ccc");
        System.out.println("普通foreach");
        Stream<String> stream = list.stream();
        System.out.println(stream);
        list.forEach(System.out::println);
        System.out.println("stream+foreach");
        list.stream().forEach(System.out::println);
        System.out.println("parallelStream+foreach");
        list.parallelStream().forEach(System.out::println);
    }
}
