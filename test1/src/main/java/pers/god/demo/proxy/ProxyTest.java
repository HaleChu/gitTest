package pers.god.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @Author GodChu
 * @Date 2020/8/21
 */
public class ProxyTest {

    public static void main(String[] args) {

        Human student = new Student();
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setHuman(student);
        Human proxyInstance = (Human) Proxy.newProxyInstance(
                student.getClass().getClassLoader(), student.getClass().getInterfaces(), handler);
        proxyInstance.eat("奥利给");
        proxyInstance.say();

    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public void setHuman(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        System.out.println("调用代理类方法开始");
        if ("eat".equals(method.getName())) {
            obj = method.invoke(object, args);
        }
        if ("say".equals(method.getName())) {
            obj = method.invoke(object);
        }
        System.out.println("调用代理类方法结束");
        return obj;
    }
}


class Student implements Human {

    @Override
    public void eat(String food) {
        System.out.println("学生正在吃" + food);
    }

    @Override
    public void say() {
        System.out.println("学生对你说：吔屎了你！");
    }
}



