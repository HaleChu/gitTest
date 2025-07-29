package pers.god.demo.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlCursor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/11/3
 */
public class WordDemo {

    public static void main(String[] args) {
        FileInputStream in;
        try {
            in = new FileInputStream("D:\\电子政务外网服务器访问方式.docx");
            XWPFDocument document = new XWPFDocument(in);
            // 循环所有段落(循环[除表格和图片外的]每一行数据)
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (int i = 0; i < paragraphs.size(); i++) {
                XWPFParagraph paragraph = paragraphs.get(i);
                System.out.println(paragraph.getText());
                System.out.println("==============================");
                if (StringUtils.isEmpty(paragraph.getText())) {
                    continue;
                }
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    int textPosition = run.getTextPosition();
                    System.out.println(textPosition);
                }
                if (paragraph.getText().length() < 37) {
                    XmlCursor cursor = paragraph.getCTP().newCursor();
                    XWPFParagraph newPara = document.insertNewParagraph(cursor);
                    XWPFRun newParaRun = newPara.createRun();
                    newParaRun.setText(paragraph.getText());

                    XmlCursor cursor2 = paragraph.getCTP().newCursor();
                    XWPFParagraph newPara2 = document.insertNewParagraph(cursor2);
                    XWPFRun newParaRun2 = newPara2.createRun();
                    newParaRun2.setText(StringUtils.EMPTY);

                    document.removeBodyElement(document.getPosOfParagraph(paragraph));
                }
            }
            // 将修改后的文件保存到新的文件内
            FileOutputStream fos = new FileOutputStream("D:\\测试文档NEW.docx");
            document.write(fos);
            fos.flush();
            fos.close();
            document.close();
            in.close();
            System.out.println("修改成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
