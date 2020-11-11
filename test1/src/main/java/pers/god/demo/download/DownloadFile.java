package pers.god.demo.download;

import java.io.*;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/10/28
 */
public class DownloadFile {

    public static void main(String[] args) {
        String source = "D:/code/cadre-education/upload-dir/template/carUseRecord/d0fd4ec2-cccd-4de8-83da" +
                "-574e90802bc4.docx";
        String dest = "D:/code/派车单.docx";
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File(source));
            out = new FileOutputStream(new File(dest));

            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            System.out.println("出错了");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
