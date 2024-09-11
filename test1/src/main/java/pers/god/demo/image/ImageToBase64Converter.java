package pers.god.demo.image;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @Author chuhao
 * @Date 2024/9/8
 * @Version 1.0.0
 */
public class ImageToBase64Converter {

    public static void main(String[] args) {
        String filePath = "E:\\测试二维码.png"; // 替换为实际图片路径

        try {
            Path path = Paths.get(filePath);
            byte[] imageData = Files.readAllBytes(path);
            String base64 = Base64.getEncoder().encodeToString(imageData);
            System.out.println(base64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
