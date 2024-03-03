package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.example.utility.ExcelReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@CucumberOptions(
        features = "src/test/resources/features", // Specify the path to your feature files
        glue = {"org.example.steps","org.example.hooks"}, // Specify the package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"},
        monochrome = true,
        strict = true,
        dryRun = false,
//        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@exceltest"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("befroe method");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("after method");
    }

}
