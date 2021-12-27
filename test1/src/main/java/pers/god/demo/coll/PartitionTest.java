package pers.god.demo.coll;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Author chuhao
 * @Date 2021/12/22
 * @Version 1.0.0
 */
public class PartitionTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<List<Integer>> partition = Lists.partition(list, 3);
        for (List<Integer> integerList : partition) {
            System.out.println(integerList);
        }
    }
}
