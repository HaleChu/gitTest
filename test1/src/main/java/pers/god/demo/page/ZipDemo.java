package pers.god.demo.page;

import cn.hutool.core.util.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * @Author chuhao
 * @Date 2024/8/20
 * @Version 1.0.0
 */
public class ZipDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/tmp/file.zip");
        File outFilePath = new File("D:/tmp/outFilePath");
        Charset gbk = Charset.forName("GBK");
        File unzip = ZipUtil.unzip(Files.newInputStream(file.toPath()), outFilePath, gbk);
        File[] files = unzip.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
        System.out.println(unzip);
    }
}
