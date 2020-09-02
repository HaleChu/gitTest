package pers.god.demo.coll;

import org.junit.Test;
import pers.god.demo.domain.Person;

import java.util.*;

/**
 * 集合
 * <p>
 * Collection
 * --List 存储有序的，可重复的元素
 * ----ArrayList（主要使用的子类）底层结构是数组，线程不安全；适用于频繁查询的场景
 * ----LinkedList 底层结构是链表，线程不安全；适用于频繁增删元素的场景
 * ----Vector 底层结构是数组，线程安全（已弃用）
 * --Set 存储无序的，不可重复的元素
 * ----HashSet（主要使用的子类）底层结构是HashMap，线程不安全
 * ------LinkedHashSet 底层结构是LinkedHashMap，线程不安全；能够按照插入顺序获取元素
 * ----TreeSet 底层结构是TreeMap，线程不安全
 *
 * @Author GodChu
 * @Date 2020/8/26
 */
public class CollTest {

    /**
     * List
     */
    @Test
    public void listTest() {
        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add("你好");
        arrayList.add(new Person("张三", 20, "男"));
        List linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add("你好");
        linkedList.add(new Person("李四", 24, "男"));
        List vector = new Vector();
        vector.add(1);
        vector.add("你好");
        vector.add(new Person("王五", 28, "男"));

        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println(vector);
    }

    /**
     * Set
     */
    @Test
    public void setTest() {

        Set hashSet = new HashSet();
        hashSet.add(new Person("张三", 20, "男"));
        hashSet.add("你好");
        hashSet.add(1);

        Set linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Person("李四", 26, "男"));
        linkedHashSet.add("你不好");
        linkedHashSet.add(2);

        Set treeSet = new TreeSet();
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);

        Iterator iterator1 = hashSet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        Iterator iterator2 = linkedHashSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        Iterator iterator3 = treeSet.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
    }

    /**
     * 测试ArrayList添加元素底层逻辑
     */
    @Test
    public void test3() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        System.out.println(list);
    }
}
