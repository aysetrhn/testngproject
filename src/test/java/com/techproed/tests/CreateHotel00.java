package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateHotel00 extends TestBase {

    @Test
    public void createHotel(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("http://www.fhctrip.com/admin/HotelAdmin/Create");
        WebElement userNameBox = driver.findElement(By.id("UserName"));
        WebElement passwordBox = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        userNameBox.sendKeys("manager2");
        passwordBox.sendKeys("Man1ager2!");
        loginButton.click();

        driver.findElement(By.id("Code")).sendKeys("RESORT");
        driver.findElement(By.id("Name")).sendKeys("OLIMPOS HOTEL");
        driver.findElement(By.id("Address")).sendKeys("RODOS");
        driver.findElement(By.id("Phone")).sendKeys("34234598898");
        driver.findElement(By.id("Email")).sendKeys("olimposhotel@hotmail.com");
        WebElement IDGroup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(IDGroup);
        select.selectByIndex(1);
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));
        saveButton.click();

        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"Hotel was inserted successfully"));
        Assert.assertTrue(isTrue);

        //click Ok button
        WebElement okButton = driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        okButton.click();



    }
}

