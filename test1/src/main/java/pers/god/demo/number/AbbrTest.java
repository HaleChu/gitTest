package pers.god.demo.number;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author chuhao
 * @Date 2023/4/3
 * @Version 1.0.0
 */
public class AbbrTest {

    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("java -version");
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            String line;
            // 读取同步程序的控制台内容写入内存
            while (proc.isAlive() && (line = in.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
            System.out.println("exitValue: " + proc.exitValue());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
