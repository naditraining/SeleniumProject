package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utility.BaseClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MyHooks extends BaseClass {

    @Before
    public void setup() {
        System.out.println("hooks before set up");
    }


    @After
    public void teardown() {
        System.out.println("hooks tear down");
        driver.close();
    }

}

