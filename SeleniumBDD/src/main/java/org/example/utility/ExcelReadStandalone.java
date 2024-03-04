package org.example.utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadStandalone {

    public void readExcelData() throws IOException {

        String filePath = "src/test/resources/testData/IrctcTestData.xlsx";
        String sheetName = "Sheet1";

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook =  new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int totalActiveRows = sheet.getPhysicalNumberOfRows();
        System.out.println("total number of rows"+totalActiveRows);

        //for loop to iterate each row

        for (int i = 1; i<totalActiveRows;i++){

            XSSFRow row = sheet.getRow(i);

            int activeColumnsInARow = row.getLastCellNum();
            System.out.println("total number of columns"+activeColumnsInARow);

            //for loop to interate all the column values in the row
            for (int j = 0;j<activeColumnsInARow;j++)
            {
                XSSFCell cell = row.getCell(j);
                String cellValue =  cell.getStringCellValue();
                System.out.println("the cell value is "+cellValue);
            }
       }

    }

    public static void main(String[] args) throws IOException {
        ExcelReadStandalone read = new ExcelReadStandalone();
        read.readExcelData();

    }


}
