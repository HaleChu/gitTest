package pers.god.demo.foreachTest;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/10/30
 */
public class ForeachTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newLinkedList();
        for (int i = 1; i <= 10000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        testFori(list);
        long end = System.currentTimeMillis();
        System.out.println("所需时间为:" + (end - start));
    }

    public static void testFori(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }
    }

    public static void testForeach(List<Integer> list) {
        list.forEach(x -> System.out.println(x));
    }

    public static void testSteamForeach(List<Integer> list) {
        list.stream().forEach(x -> System.out.println(x));
    }

}
