package pers.god.demo.sax;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

/**
 * @Author chuhao
 * @Date 2024/4/9
 * @Version 1.0.0
 */
public class demo {

    public static void main(String[] args) throws DocumentException {
        Map<String, String> data = new HashMap<>();
        String deptFilePath = "D:\\import\\gwyinfo.xml";
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(deptFilePath));
        Element rootElement = document.getRootElement();
        Iterator<Element> it = rootElement.elementIterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (StringUtils.equals("node", next.getName())) {
                List<Attribute> attrs = next.attributes();
                data.put(attrs.get(0).getValue(), attrs.get(1).getValue());
            }
        }
        System.out.println(data);
    }
}
