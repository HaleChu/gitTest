package pers.god.demo.map;

import org.junit.Test;
import pers.god.demo.domain.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap底层实现原理
 * ----HashMap是基于哈希表的Map接口的实现。这个实现提供了所有可选的键值操作，而且允许存储null的键和null的值
 * ----除了线程不安全和允许null值，HashMap大致相当于Hashtable
 * ----HashMap不保证元素是有序存储的，特别地，不保证存储元素的顺序是一直不变的
 * <p>
 * ----在哈希函数能够正常地将元素分散至桶中的情况下，HashMap提供了Map的put和get的基本操作的常规实现
 * --1.初始化
 *
 * @Author GodChu
 * @Date 2020/8/27
 */
public class MapTest {

    @Test
    public void test1() {
        Map map = new HashMap();
        map.put("姓名", "张三");
        map.put("姓名", "李四");
        map.put("Aa", "Aa");
        map.put("BB", "BB");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        String a = "Aa";
        String b = "BB";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Test
    public void test3() {
        Person p1 = new Person("张三", 20, "男");
        Person p2 = new Person("张三", 20, "男");
        System.out.println(p1 == p2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
    }

    @Test
    public void test4() {
        String s1 = new String("张三");
        String s2 = new String("张三");
        String s3 = "李四";
        String s4 = "李四";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
    }
}
