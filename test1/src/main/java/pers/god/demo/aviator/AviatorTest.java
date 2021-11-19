package pers.god.demo.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.List;

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

        System.out.println("====================");

        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
// Execute with injected variables.
        Boolean result =
                (Boolean) compiledExp.execute(compiledExp.newEnv("a", 100.3, "b", 45, "c", -199.100));
        System.out.println(result);

        System.out.println("====================");

        System.out.println(Math.PI);
        System.out.println(AviatorEvaluator.VERSION);
        System.out.println(AviatorEvaluator.COMPILE);

        System.out.println("====================");

        Expression expression1 = AviatorEvaluator.compile("use  com.googlecode.aviator.AviatorEvaluator;p(AviatorEvaluator.VERSION);");
        expression1.execute();

        System.out.println("====================");

        Expression exp = AviatorEvaluator
                .compile("b=2; if(a > 1) { a + b } elsif( a > 10) { return a + c; } else { return 10; }");
        List<String> vars = exp.getVariableNames();
        System.out.println(vars);
    }
}
