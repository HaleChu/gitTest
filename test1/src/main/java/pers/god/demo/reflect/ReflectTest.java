package pers.god.demo.reflect;

import org.junit.Test;
import pers.god.demo.domain.Person;

/**
 * @Author GodChu
 * @Date 2020/8/19
 */
public class ReflectTest {
    /**
     * 获取Class对象的三种方式
     */
    @Test
    public void test1() throws Exception {
        Class<?> clazz1 = Person.class;
        Person person = new Person();
        Class<?> clazz2 = person.getClass();
        Class<?> clazz3 = Class.forName("pers.god.demo.domain.Person");
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
    }

    /**
     * 类加载器
     * BootstrapClassLoader
     * ExtClassLoader
     * AppClassLoader
     */
    @Test
    public void test2() {
        ClassLoader classLoader1 = Person.class.getClassLoader();
        ClassLoader classLoader2 = classLoader1.getParent();
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader1);
        System.out.println(classLoader2);
        System.out.println(classLoader3);
    }

    @Test
    public void test3() {

    }
}
