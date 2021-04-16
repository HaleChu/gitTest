package pers.god.demo.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PdfDemo {

    public static void main(String[] args) throws IOException {
        PdfReader reader = new PdfReader("D:\\Java编程思想第4版.pdf");
        List list = SimpleBookmark.getBookmark(reader);
        for (Iterator i = list.iterator(); i.hasNext(); ) {
            showBookmark((Map) i.next());
        }
    }

    /**
     * 获取pdf目录
     */
    private static void showBookmark(Map bookmark) {
        System.out.println(bookmark.get("Title"));
        ArrayList kids = (ArrayList) bookmark.get("Kids");
        if (kids == null)
            return;
        for (Iterator i = kids.iterator(); i.hasNext(); ) {
            showBookmark((Map) i.next());
        }
    }
}
