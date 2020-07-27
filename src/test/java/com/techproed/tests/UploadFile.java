package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends TestBase {
    @Test
    public void uploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");
        //When we upload a file, do manual testing to understand the steps
        //finding the choosefile button
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));

        //find the path of the file you want to upload, with the name
        String filePath = "C:\\Users\\PC\\Pictures\\logo.jpg";

        //We need to sent the file path to the choose file button
        chooseFileButton.sendKeys(filePath);

        //We need to click the upload button
        driver.findElement(By.id("file-submit")).click();

        //We are doing assertion to verify the upload is successful
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");

    }
}

