package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //Abstract class nedir?
    //Abstract class'i framework'de nerede kullandiniz? => TestBase class da abstract kullandim.
    //Framework'umde TestBase class var ve bu abstarct bir classtir.
    //Bunun amaci bu classda object create etmeyecek olmam fakat sadece cu classda bulunan methodlari kullanacak olmamdir.

    //TestBase classini driver set up(kurulum) gTestBase ibi tekrar eden eylemler icin kullaniriz.
    //create driver, maximize window..
    //TestBase classinda bekleme(wait) de bulunabilir.
    //Tarayiciyi kapatmak icin tearDown() metodu da TestBase de kullanilabilir
    protected WebDriver driver;
    protected Actions actions;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Implicitly wait global bir waittir.
        //TestBase de kullandigimizda tekrar test classlarinda kullanmaya gerek yoktur.

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
