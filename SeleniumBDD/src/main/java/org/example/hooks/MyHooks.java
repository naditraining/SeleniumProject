package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utility.BaseClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MyHooks extends BaseClass {

    /*@Before
    public void setup() {
        System.out.println("hookd before set up");
        driver = new ChromeDriver();
//        driver.get("https://ui.cogmento.com/");
        driver.get("https://google.com/");

    }*/

    @BeforeMethod
    public void setup() {
        System.out.println("hookd before set up");
        driver = new ChromeDriver();
//        driver.get("https://ui.cogmento.com/");
        driver.get("https://google.com/");

    }

   /* @After
    public void teardown() {
        System.out.println("hookd tear down");
        driver.close();
    }*/

    @AfterMethod
    public void teardown1() {
        System.out.println("hookd tear down");
        driver.close();
    }

}

