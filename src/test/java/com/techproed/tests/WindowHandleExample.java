package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {
    //user is on the https://the-internet.herokuapp.com/windows
    @Test
    public void newWindowTest(){
        //user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("PARENT WINDOW HANDLE => "+parentWindowHandle);

        //Then user verifies the text : “Opening a new window”
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);

        //Then user verifies the title of the page is “The Internet”
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        //When user clicks on the Click Here button
        driver.findElement(By.linkText("Click Here")).click();
       Set<String> allWindowHandles = driver.getWindowHandles();


        for(String handle : allWindowHandles){
            if(!handle.equals(parentWindowHandle)){
                driver.switchTo().window(handle);
                System.out.println("CHILD WINDOW HANDLE => "+handle);
              }
        }
        //Then user verifies the new window title is “New Window”
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle, "New Window");
        //Then user verifies the text:  “New Window”
        String actualNewWindowText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualNewWindowText,"New Window");

        //When user goes back to the previous window and then verifies the title : “The Internet”
        //Parent Window'a nasil geri gidecegiz?
        driver.switchTo().window(parentWindowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }
}
