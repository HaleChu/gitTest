package pers.god.demo.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.File;
import java.io.IOException;

/**
 * @author chuhao
 * @version 1.0
 * @date 2021/11/11
 */
public class JavaBeanTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/AviatorScript.av");
        Expression exp = AviatorEvaluator.getInstance().compileScript(file.getPath());
        exp.execute();
    }
}
