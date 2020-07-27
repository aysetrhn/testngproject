package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A_ExtentReports2 extends TestBaseFinal {

    @Test
    public void negativeTest(){
        extentTest=extentReports.createTest("FHC Registration Test","Testing the FHC Registration functionality");
        extentTest.info("Opening the URL");


        Driver.getDriver().get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(Driver.getDriver());
        extentTest.info("sending the gecersiz email");
        fhcLoginPage.username.sendKeys("manager");
        extentTest.info("sending the gecersiz pass");
        fhcLoginPage.username.sendKeys("manager");
        extentTest.info("click login");
        //fhcLoginPage.loginButton.click();
        extentTest.info("do assertion");
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
        Assert.assertTrue(tryAgain.isDisplayed());
        extentTest.pass("PASSED: SUCCESSFULLY COMPLETED THE REGISTRATION TEST");
        //This will fail. Expected = Success! But Actual = Success!!
        Driver.closeDriver();
        extentTest.pass("DRIVER CLOSED SUCCESSFULLY");
    }

}
