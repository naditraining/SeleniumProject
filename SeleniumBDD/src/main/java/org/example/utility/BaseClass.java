package org.example.utility;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BaseClass {

    public static ChromeDriver driver = null;
    public static Properties properties = new Properties();
    public static Map<String, String> rowDataToUse;
    public Map<String, String> readTestDataForMyTest(String testCase) throws IOException {
        List<Map<String, String>> testDataList = ExcelReader.readTestData("src/test/resources/testData/IrctcTestData.xlsx","Sheet1");
        for (Map<String, String> rowData : testDataList) {
            System.out.println("Row Data: " + rowData);
            if (rowData.get("testcase").equals(testCase)){
                rowDataToUse = rowData;
                break;
            }
        }
        return rowDataToUse;
    }

    public void launchApp(){
        driver = new ChromeDriver();
        driver.get(properties.getProperty("devurl"));
    }

    public void loadProperties()
    {

        FileInputStream fileInputStream = null;
        try {
            // Load the properties file
            fileInputStream = new FileInputStream("src/main/resources/config/EnvConfig.properties");
            properties.load(fileInputStream);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the FileInputStream
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
