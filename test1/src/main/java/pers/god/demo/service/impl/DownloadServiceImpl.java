package pers.god.demo.service.impl;

import org.springframework.stereotype.Service;
import pers.god.demo.service.DownloadService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/10/29
 */
@Service
public class DownloadServiceImpl implements DownloadService {

    @Override
    public void downloadFile(HttpServletResponse response) {
        String source = "D:/code/cadre-education/upload-dir/template/carUseRecord/e21580e9-9ab7-46ad-8c76" +
                "-18ed677f0ff2.docx";
        InputStream in = null;
        ServletOutputStream os = null;
        try {
            String fileName = "派车单.docx";
            response.addHeader( "Content-Type", "application/octet-stream");
            response.addHeader( "Content-Disposition", "attachment; filename=" + new String(fileName.getBytes( "UTF-8"), "ISO-8859-1"));

            in = new FileInputStream(new File(source));

            os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) > 0) {
                os.write(buffer, 0, len);
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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
