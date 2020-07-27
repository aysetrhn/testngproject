package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandlingAlerts {
    /*
    Create 3 methods
        1. acceptAlert
        2. dismissAlert
        3. sendKeysAlert
    Create @BeforeMethod
    go to https://the-internet.herokuapp.com/javascript_alerts
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void acceptAlert(){
        //Click 1.button, click OK, verify result message
        //Create 1.element , click 1.button
        WebElement clickButton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickButton1.click();
                                                            //switch to alert
        System.out.println("Alert uzerindeki text : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept(); //accept alert(click OK)
        //Verify result message
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMessage.isDisplayed());

    }

    @Test
    public void dismissAlert(){
        //Click 2.button, click cancel, verify result message

        //Create 2.element , click 2.button
        WebElement clickButton2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickButton2.click();
        //switch alert, click cancel(dismiss alert)
        driver.switchTo().alert().dismiss();
        //Verify result
        String actualResultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultMessage = "You clicked: Cancel";
        Assert.assertEquals(actualResultMessage,expectedResultMessage);

    }

    @Test
    public void sendKeysAlert(){
        //Click 3.button, send your name, verify result
        //Create 3.element,click 3.button
        WebElement clickButton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickButton3.click();
        //switch alert, send name
        driver.switchTo().alert().sendKeys("AYSE");
        //accept alert.(click OK)
        driver.switchTo().alert().accept();
        //Verify result
        String actualResultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultMessage = "You entered: AYSE";
        Assert.assertEquals(actualResultMessage,expectedResultMessage);

    }
}
