package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Soft_Hard_Assertion {
    //When user goes to http://a.testaddressbook.com/sign_in
    //Locate the elements of email textbox,password textbox, and signin button
    //Enter below username and password then click sign in button
    //Username :  testtechproed@gmail.com
    //Password : Test1234!
    //Then Assert/Verify that the expected user id  testtechproed@gmail.com using different assertions

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void login(){
        WebElement emailBox = driver.findElement(By.id("session_email"));
        WebElement passwordBox = driver.findElement(By.id("session_password"));
        WebElement loginButton =driver.findElement(By.name("commit"));
        emailBox.sendKeys("testtechproed@gmail.com");
        passwordBox.sendKeys("Test1234!");
        loginButton.click();
        driver.manage().window().maximize();
    }

    @Test(dependsOnMethods = "login")
    public void homePage() {
        WebElement wellcomeMessage = driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(wellcomeMessage.getText());
        Assert.assertTrue(wellcomeMessage.isDisplayed()); //HARD ASSERT
        System.out.println("Hard assertion fail olursa bu satir calismayacak");


        //SOFT ASSERT
        //Step 1: create object
        SoftAssert softAssert = new SoftAssert();
        //Step 2: assertion icin objecti kullan
        softAssert.assertTrue(wellcomeMessage.isDisplayed()); //PASS
       // softAssert.assertEquals(3,5); //fail
        // softAssert.assertTrue(!wellcomeMessage.isDisplayed());  //FAIL

        //Verify that the expected user id  testtechproed@gmail.com using different assertions
        WebElement userID = driver.findElement(By.className("navbar-text"));
        String actualID = userID.getText();
        String expectedID = "testtechproed@gmail.com";
        softAssert.assertEquals(actualID,expectedID);
        //Step 3: assertAll()
        softAssert.assertAll(); //BU LINE COK ONEMLI. assertAll() actual(gercek) assertion yapar.
        System.out.println("Bu satir assertAll()'dan sonra geliyor. assertAll() fail olursa calismaz.");

    }

}
