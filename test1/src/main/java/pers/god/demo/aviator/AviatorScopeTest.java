package pers.god.demo.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;

/**
 * @Author chuhao
 * @Date 2021/10/8
 * @Version 1.0.0
 */
public class AviatorScopeTest {

    public static void main(String[] args) throws IOException {
        String script = "";
        Expression exp = AviatorEvaluator.getInstance().compileScript("scope.av");
        exp.execute();
    }
}
