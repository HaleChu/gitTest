package pers.god.demo.poi;

import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/11/3
 */
public class ExcelDemo {

    public static void main(String[] args) {
        try {
            dropDownList("D:\\test.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void dropDownList(String filePath)
            throws Exception {
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(1);
        String[] datas = new String[]{"张三", "李四", "王五"};
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                .createExplicitListConstraint(datas);
        CellRangeAddressList addressList = new CellRangeAddressList(2, 2, 2, 2);
        XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
        // 07默认setSuppressDropDownArrow(true);
        // validation.setSuppressDropDownArrow(true);
        // validation.setShowErrorBox(true);
        sheet.addValidationData(validation);
        FileOutputStream stream = new FileOutputStream(filePath);
        workbook.write(stream);
        System.out.println("下拉列表生成成功");
        stream.close();
    }
}
