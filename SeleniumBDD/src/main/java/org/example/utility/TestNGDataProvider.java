package org.example.utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class TestNGDataProvider {
    @DataProvider(name = "excelDataProvider")
    public Object[][] provideExcelData() throws IOException {
        String filePath = "path/to/your/testdata.xlsx";
        String sheetName = "Sheet1";

        List<Object[]> testDataList = ExcelReader.readTestData(filePath, sheetName);
        Object[][] testData = new Object[testDataList.size()][1];

        for (int i = 0; i < testDataList.size(); i++) {
            testData[i][0] = testDataList.get(i);
        }

        return testData;
    }
}
