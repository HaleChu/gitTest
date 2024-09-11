package pers.god.demo.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author chuhao
 * @Date 2024/9/4
 * @Version 1.0.0
 */
public class ImageCompressor {

    public static void compressImage(File source, File destination, int width, int height, String format) throws IOException {
        // 读取原始图片
        BufferedImage originalImage = ImageIO.read(source);
        // 创建缩放后的图片
        BufferedImage scaledImage = new BufferedImage(width, height, originalImage.getType());
        // 绘制缩放后的图片
        Graphics2D graphics2D = scaledImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, width, height, null);
        graphics2D.dispose();
        // 写入目标文件
        ImageIO.write(scaledImage, format, destination);
    }

    public static void main(String[] args) throws IOException {

        File source = new File("original.jpg");
        File destination = new File("compressed.jpg");
        int width = 800;
        int height = 600;

        String format = "JPEG";
        compressImage(source, destination, width, height, format);
    }

}
