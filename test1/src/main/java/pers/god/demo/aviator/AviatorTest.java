package pers.god.demo.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

/**
 * @Author chuhao
 * @Date 2021/10/8
 * @Version 1.0.0
 */
public class AviatorTest {

    public static void main(String[] args) {
        /*String expression = "a*b+a/b";
        Expression exp = AviatorEvaluator.compile(expression);
        Map<String, Object> params = ImmutableMap.of("a", 10, "b", 5);
        Object execute = exp.execute(params);
        System.out.println("result:" + execute);*/


        Expression expression = AviatorEvaluator.getInstance().compile("println('Hello, AviatorScript!');");
        expression.execute();
    }
}
