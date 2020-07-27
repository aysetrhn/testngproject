package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClassExample extends TestBase {

    @Test
    public void contextClickMethod(){
        //user  https://the-internet.herokuapp.com/context_menu sayfasina gitsin.
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //1.Webelementi belirle
        WebElement dikdortgen = driver.findElement(By.id("hot-spot"));
        //2.Create Actions object
       // Actions actions = new Actions(); ==>TestBase

        //3.artik actions object var ve fare ve klavye islemlerini yapabilirim(perform).
        actions.contextClick(dikdortgen).perform();
        //Alert mesajinin "You selected a context menu" oldugunu dogrula
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(actualText,expectedText);
        //accept alert (click OK)
        driver.switchTo().alert().accept();

        //HOMEWORK : right click Element Selenium
    }
    @Test
    public void hoverOver(){
        //User amazon web sayfasina gitsin https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //User "Your Account" linkine tiklar.
        WebElement signInBox = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        actions.moveToElement(signInBox).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();
    }

    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        //searchBox.sendKeys("iphone");
        //input(giris) => iphone , output => IPHONE
        //BUYUK HARF ICIN
        //1.METHOD=> searchBox.sendKeys(Keys.SHIFT + "iphone");
        //2.METHOD=> ACTIONS CLASS
        //Keys.SHIFT kullanarak klavyede shift tusuna basiyoruz.
//            actions.
//                    moveToElement(searchBox).
//                    click().
//                    keyDown(Keys.SHIFT).
//                    sendKeys("iphone").
//                    perform();
        actions. //action objectini kullaniyoruz
                keyDown(searchBox, Keys.SHIFT).  //klavyede shifte basiyoruz
                sendKeys("iphone").              //yaziyoruz
                keyUp(searchBox,Keys.SHIFT).     //klavyede shift tusunu serbest birakiyoruz
                perform();     //eylemi gerceklestiriyoruz.

        actions.doubleClick(searchBox).perform(); //searchbox ta double click yapiyoruz

    }


    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //Sayfada asagi gitme (Scroll down)
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //Bir sayfada birden fazla page_down ve page_up kullanabiliriz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //ARROW_DOWN da sayfada asagi inmeyi saglar ama daha az miktarda
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        //sendKeys(Keys.PAGE_UP) kullanarak sayfada yukari cikilir
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        //sendKeys(Keys.ARROW_UP) kullanarak ta sayfada yukari cikilir ama daha az...
        actions.sendKeys(Keys.ARROW_UP).perform();
    }




}
