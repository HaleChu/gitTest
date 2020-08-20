package pers.god.demo.reflect;

import org.junit.Test;
import pers.god.demo.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Java反射
 *
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

    /**
     * 无参构造方法获得实例对象
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Class<?> clazz = Class.forName("pers.god.demo.domain.Person");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }

    /**
     * 公共构造方法获得实例对象
     *
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        Class<?> clazz = Class.forName("pers.god.demo.domain.Person");
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class, String.class);
        Object obj = constructor.newInstance("张三", 20, "男");
        System.out.println(obj);
    }

    /**
     * 私有构造方法获得实例对象
     *
     * @throws Exception
     */
    @Test
    public void test5() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("pers.god.demo.domain.Person");
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        Object obj = declaredConstructor.newInstance("李四", 21);
        System.out.println(obj);
    }

    /**
     * 反射调用公共方法
     */
    @Test
    public void test6() throws Exception {
        Class<?> clazz = Class.forName("pers.god.demo.domain.Person");
        Object obj = clazz.newInstance();
        Method talk = clazz.getMethod("talk");
        talk.invoke(obj);
    }

    /**
     * 反射调用私有方法
     */
    @Test
    public void test7() throws Exception {
        Class<?> clazz = Class.forName("pers.god.demo.domain.Person");
        Object obj = clazz.newInstance();
        Method run = clazz.getDeclaredMethod("run");
        run.setAccessible(true);
        run.invoke(obj);
    }
}
