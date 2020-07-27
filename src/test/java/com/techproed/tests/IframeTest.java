package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    /*
    Create class : IframeTest
    create @BeforeMethod, ve https://the-internet.herokuapp.com/iframe
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("  //");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void iframeTest(){
        //Parent Iframe deki texti yazdir
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //Text box'a yazi yazmaya calisalim
       // WebElement textBox = driver.findElement(By.id("tinymce"); //FAIL
        //EGER TESTINIZ FAIL OLDUYSA NE YAPACAKSINIZ??
        // 1. Webelement dogru mu degil mi bunu kontrol etmelisiniz.
        // 2. Herhangi bir bekleme(wait) problemi var mi yok mu kontrol edin.
        // 3. Ilk ikisinde problem yoksa sayfada iframe var mi yok mu bunu kontrol edin.

        //BU SAYFADA IFRAME VAR. DOLAYISIYLA ILK ONCE IFRAME SWITCH YAPMAMIZ GEREKIR.
        //BIR IFRAME'E SWITCH YAPMANIN 3 YOLU VARDIR: 1.index , 2.id , 3.webelement
        //driver.switchTo().frame(0);            //index kullanarak 1. iframe'e gitmek.
        //driver.switchTo().frame("mce_0_ifr");  //id value kullanarak iframe gitmek.
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")); //Webelement kullanarak iframe'e gitmek
        driver.switchTo().frame(frameElement);
        //Artik iframe icerisindeki elementi bulabiliriz.
        WebElement textBox = driver.findElement(By.id("tinymce"));
        //text box icindeki metni temizle
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya"); //text boxa yaz

        //"Elemental Selenyum" u consolda yazdir
        //Parent frame'e geri gel(switch)
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());



    }
}
