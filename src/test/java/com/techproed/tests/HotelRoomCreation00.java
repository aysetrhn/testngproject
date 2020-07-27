package com.techproed.tests;

import com.sun.org.apache.bcel.internal.generic.DREM;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation00 extends TestBase {
    @Test
    public void roomCreateTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        WebElement userNameBox = driver.findElement(By.id("UserName"));
        WebElement passwordBox = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        userNameBox.sendKeys("manager2");
        passwordBox.sendKeys("Man1ager2!");
        loginButton.click();

        WebElement addHotellRoomButton = driver.findElement(By.className("hidden-480"));
        addHotellRoomButton.click();

        WebElement createHotelRoomText = driver.findElement(By.className("caption"));
        Assert.assertTrue(createHotelRoomText.isDisplayed());

        WebElement idHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(idHotel);
        select.selectByIndex(1);

        driver.findElement(By.id("Code")).sendKeys("KING");
        driver.findElement(By.id("Name")).sendKeys("112");
        driver.findElement(By.id("Location")).sendKeys("ABC");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Deniz manzarali");
        //Price
        WebElement kaynak = driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement hedef = driver.findElement(By.name("Price"));

        actions.dragAndDrop(kaynak,hedef).perform();

        WebElement roomType = driver.findElement(By.id("IDGroupRoomType"));
        Select option = new Select(roomType);
        option.selectByIndex(2);

        //max adult count
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        //max child count
        driver.findElement(By.id("MaxChildCount")).sendKeys("2");
        //click save buton
        driver.findElement(By.id("btnSubmit")).click();

        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);

        WebElement okButton = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        okButton.click();

        //Click Hotel Rooms
        WebElement hotelRoomsLink = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
        Thread.sleep(3000);
        actions.doubleClick(hotelRoomsLink).perform();

        //Veriyfy "LIST OF HOTELROOMS" is displayed
        WebElement listOfHotel = driver.findElement(By.xpath("//span[.='List Of Hotelrooms']"));
        Assert.assertTrue(listOfHotel.isDisplayed());







    }
}

