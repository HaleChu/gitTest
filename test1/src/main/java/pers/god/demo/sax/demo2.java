package pers.god.demo.sax;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author chuhao
 * @Date 2024/4/9
 * @Version 1.0.0
 */
public class demo2 {

    public static void main(String[] args) throws DocumentException {
        List<Map<String, String>> dataList = new ArrayList<>();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("D:\\import\\new\\table\\A05.xml"));
        Element rootElement = document.getRootElement();
        Iterator<Element> it = rootElement.elementIterator();
        while (it.hasNext()) {
            Element next = it.next();
            Iterator<Element> cit = next.elementIterator();
            while (cit.hasNext()) {
                Element citNext = cit.next();
                List<Attribute> cAttrs = citNext.attributes();
                Map<String, String> data = new HashMap<>();
                for (Attribute cAttr : cAttrs) {
                    data.put(cAttr.getName(), cAttr.getValue());
                    dataList.add(data);
                }
            }
        }
        List<A05From> a05FromList = dataList.stream().map(map -> BeanUtil.mapToBean(map, A05From.class, false, new CopyOptions().setIgnoreCase(true))).collect(Collectors.toList());
        System.out.println(a05FromList.size());
    }
}
