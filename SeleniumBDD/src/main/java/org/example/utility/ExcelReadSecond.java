package org.example.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReadSecond {

    public static List<Map<String, String>> readTestData(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> testDataList = new ArrayList<>();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);
        int totalRows = sheet.getPhysicalNumberOfRows();

        for (int rowIndex = 1; rowIndex < totalRows; rowIndex++) {
            Row currentRow = sheet.getRow(rowIndex);

            Map<String, String> rowData = new HashMap<>();

            for (int cellIndex = 0; cellIndex < headerRow.getLastCellNum(); cellIndex++) {
                Cell currentCell = currentRow.getCell(cellIndex);

                String columnHeader = headerRow.getCell(cellIndex).getStringCellValue();
                String cellValue = getCellValueAsString(currentCell);

                rowData.put(columnHeader, cellValue);
            }

            testDataList.add(rowData);
        }

        fis.close();
        workbook.close();

        return testDataList;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return "";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        try {
            String filePath = "path/to/your/testdata.xlsx";
            String sheetName = "Sheet1";

            List<Map<String, String>> testDataList = readTestData(filePath, sheetName);

            for (Map<String, String> rowData : testDataList) {
                System.out.println("Row Data: " + rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
