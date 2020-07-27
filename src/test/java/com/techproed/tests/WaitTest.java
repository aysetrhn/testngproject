package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {
    @Test
    public void implicitWait(){
        //TestBase class'inda implicitly wait olusturmustuk. Driveri ne zaman kullanirsak otomatik olarak implictly waiti kullanir.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();
        WebElement goneMessage = driver.findElement(By.id("message"));
        String expectedMessage = "It's gone!";
        Assert.assertEquals(goneMessage.getText(),expectedMessage);
    }

    @Test
    public void explicitWait(){
        //Create WebDriverWait object. Iki tane parametre alir(1.driver, 2.second)
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();
        WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String expectedMessage = "It's gone!";
        Assert.assertEquals(goneMessage.getText(),expectedMessage);

    }
}
