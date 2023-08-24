package pers.god.demo.shift;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author chuhao
 * @Date 2023/5/4
 * @Version 1.0.0
 */
public class DocToPdf {

    public static void main(String[] args) {
        String filePath = "D:\\meeting\\11111.docx";
        String pdfFilePath = "D:\\meeting\\11111.pdf";
        String suffix = "";
        if (filePath.contains(".")) {
            suffix = filePath.substring(filePath.lastIndexOf("."));
        }

        try (
                InputStream docxInputStream = new FileInputStream(filePath);
                OutputStream outputStream = new FileOutputStream(pdfFilePath)
        ) {
            // 原word地址
            // 转换后pdf生成地址
            IConverter converter = LocalConverter.builder().build();
            if (StringUtils.equals("DOC", suffix)) {
                converter.convert(docxInputStream)
                        .as(DocumentType.DOC)
                        .to(outputStream)
                        .as(DocumentType.PDF).execute();
            } else {
                converter.convert(docxInputStream)
                        .as(DocumentType.DOCX)
                        .to(outputStream)
                        .as(DocumentType.PDF).execute();
            }
            // 关闭
            converter.shutDown();
        } catch (Exception e) {
            System.out.println("[documents4J] word转pdf失败:" + e.toString());
        }
    }

}
