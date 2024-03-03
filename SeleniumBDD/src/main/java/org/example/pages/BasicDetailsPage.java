package org.example.pages;

import org.example.utility.BaseClass;
import org.openqa.selenium.By;

public class BasicDetailsPage extends BaseClass {

    public BasicDetailsPage enterUserName(){
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(rowDataToUse.get("Firstname"));
        return this;
    }
    public BasicDetailsPage enterPassword(){
        driver.findElement(By.xpath("//input[@id='usrPwd']")).sendKeys(rowDataToUse.get("lastname"));
        return this;
    }
    public BasicDetailsPage enterConfirmPassword(){
        driver.findElement(By.xpath("//input[@name='cnfUsrPwd']")).sendKeys(rowDataToUse.get("postcode"));
        return this;
    }

    public BasicDetailsPage choosePrefLanguage(){
        driver.findElement(By.name("sfsfd")).sendKeys("");
        return this;
    }

}
