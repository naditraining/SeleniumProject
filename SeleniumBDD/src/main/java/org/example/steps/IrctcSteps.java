package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.BasicDetailsPage;
import org.example.utility.BaseClass;
import org.example.utility.ExcelReadSecond;
import org.example.utility.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;


public class IrctcSteps extends BaseClass {

    @Given("As a user launching the irctc portal")
    public void register() {
        loadProperties();
        launchApp();
    }


    @When("I enter personal details")
    public void personalDetails(){


        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sheela");
        driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys("C");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Chinnasamy");
        driver.findElement(By.xpath("//span[@class='ng-tns-c65-9 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")).click();
        driver.findElement(By.xpath("//li[@aria-label='PRIVATE']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Date Of Birth']")).sendKeys("06-02-2006");
        driver.findElement(By.xpath("//a[contains(text(),'6')]")).click();
        driver.findElement(By.xpath("//label[text()='Married']")).click();
        WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='resCountry']"));
        Select sei = new Select(country);
        sei.selectByValue("94");
        driver.findElement(By.xpath("//span[text()='Female']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("cpshe@gmail.com");
        driver.findElement(By.xpath("//input[@formcontrolname='mobile']")).sendKeys("7448515464");
        WebElement Nation = driver.findElement(By.xpath("//select[@formcontrolname='nationality']"));
        Select Nat = new Select(Nation);
        Nat.selectByValue("94");
        driver.findElement(By.xpath("//button[@label='Continue']")).click();
    }

    @When("I read test data for {string}")
    public void readTestDataFor(String testCaseName) throws IOException {
        readTestData(testCaseName);
    }

    @When("I enter address details")
    public void addressDetails(){

        driver.findElement(By.xpath("//input[@id='resAddress1']")).sendKeys("No3, Gandhi Nagar");
        driver.findElement(By.xpath("//input[@id='resAddress2']")).sendKeys("Mookondapalli");
        driver.findElement(By.xpath("//input[@id='resAddress3']")).sendKeys("Hosur");
        driver.findElement(By.xpath("//input[@name='resPinCode']")).sendKeys("635126");
        driver.findElement(By.xpath("//select[@formcontrolname='resCity']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement City = driver.findElement(By.xpath("//select[@formcontrolname='resCity']"));

        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                Select cit = new Select(City);
                return cit.getOptions().size()>1;
            }

        });

        Select cit = new Select(City);
        cit.selectByVisibleText("Krishnagiri");

        //driver.findElement(By.xpath("//input[@id='resState']")).sendKeys("TAMILNADU");
        WebElement Post = driver.findElement(By.xpath("//select[@formcontrolname='resPostOff']"));
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                Select cit = new Select(Post);
                return cit.getOptions().size()>1;
            }
        });
        Select off = new Select(Post);
        off.selectByValue("Mookandapalli B.O");
        driver.findElement(By.xpath("//input[@id='resPhone']")).sendKeys("9987689979");
        driver.findElement(By.xpath("//label[text()='Yes']")).click();
        WebElement button= driver.findElement(By.xpath("//button[@type='submit']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(button);
        actions.perform();
        WebElement checkbox= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='termCondition']")));
        //driver.findElement(By.xpath("//input[@formcontrolname='termCondition']")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkbox);

    }

    @When("registration is complete")
    public void complete(){
        String successMesage = driver.findElement(By.xpath("//div[@results]")).getText();
        String expectedText = "sucessfully registered";
        if(successMesage == expectedText){
            System.out.println("TEST PASSSED");
        }else {

        }
    }

    @When("I enter basic details")
    public void basicDetailswewew(){

        BasicDetailsPage basic = new BasicDetailsPage();
        basic.enterUserName().enterPassword().enterConfirmPassword();
//        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Sheela    ");
//        driver.findElement(By.xpath("//input[@id='usrPwd']")).sendKeys("Rain@12345");
//        driver.findElement(By.xpath("//input[@name='cnfUsrPwd']")).sendKeys("Rain@12345");
//        driver.findElement(By.xpath("//div[@class='ng-tns-c65-7 ui-dropdown ui-widget ui-state-default ui-corner-all']")).click();
//        driver.findElement(By.xpath("//li[@aria-label='English']")).click();
//        driver.findElement(By.xpath("//div[@class='ng-tns-c65-8 ui-dropdown ui-widget ui-state-default ui-corner-all']")).click();
//        driver.findElement(By.xpath("//li[@aria-label='What is your pet name?']")).click();
//        driver.findElement(By.xpath("//input[@placeholder='Security Answer']")).sendKeys("Suvi");
//        driver.findElement(By.xpath("//button[@label='Continue']")).click();

    }


    @When("I enter basic details for {string}")
    public void i_enter_basic_details_for(String username, String password, int value) {
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='usrPwd']")).sendKeys("Rain@12345");
        driver.findElement(By.xpath("//input[@name='cnfUsrPwd']")).sendKeys("Rain@12345");
        driver.findElement(By.xpath("//div[@class='ng-tns-c65-7 ui-dropdown ui-widget ui-state-default ui-corner-all']")).click();
        driver.findElement(By.xpath("//li[@aria-label='English']")).click();
        driver.findElement(By.xpath("//div[@class='ng-tns-c65-8 ui-dropdown ui-widget ui-state-default ui-corner-all']")).click();
        driver.findElement(By.xpath("//li[@aria-label='What is your pet name?']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Security Answer']")).sendKeys("Suvi");
        driver.findElement(By.xpath("//button[@label='Continue']")).click();

    }
}

