package pers.god.demo.map;

import org.junit.Test;

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
}
