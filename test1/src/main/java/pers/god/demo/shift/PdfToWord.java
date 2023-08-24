package pers.god.demo.shift;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PdfToWord {

    public static void main(String[] args) {
        String pdfFilePath = "D:\\meeting\\test\\11111.pdf";
        String filePath = "D:\\meeting\\test\\11111.docx";

        try (
                InputStream InputStream = new FileInputStream(pdfFilePath);
                OutputStream outputStream = new FileOutputStream(filePath)
        ) {
            IConverter converter = LocalConverter.builder().build();
            converter.convert(InputStream)
                    .as(DocumentType.PDF)
                    .to(outputStream)
                    .as(DocumentType.DOCX).execute();
            // 关闭
            converter.shutDown();
        } catch (Exception e) {
            System.out.println("[documents4J] pdf转word失败:" + e.toString());
        }
    }

}
