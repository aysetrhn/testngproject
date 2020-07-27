package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableTest extends TestBase {
    //Kullanici https://the-internet.herokuapp.com/dynamic_controls adresine gitsin
    //Ve Enable butonuna tiklasin
    //Textbox'in enable oldugunu dogrulasin(verify)..[Icine yazi yazilabiliyor mu?]
    //Text'in "It's enabled!" oldugunu dogrulayin

    @Test
    public void IsEnabled(){

        //Kullanici https://the-internet.herokuapp.com/dynamic_controls adresine gitsin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Ve Enable butonuna tiklasin
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();

        //enabled message icin bekliyoruz cunku yuklenmesi zaman aliyor.
        //explicit wait enable message icin 10 saniye bekleyecek. Eger 10 saniyeden daha once yuklenirse bir sonraki satira gecer.
        //Eger element 10 saniyede yuklenemezse bu satir fail olur
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement enabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //Textbox'in enable oldugunu dogrulasin(verify)
        Assert.assertEquals(enabledMessage.getText(),"It's enabled!");

        //Text'in "It's enabled!" oldugunu dogrulayin
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        //isDisplayed => bir element gorunuyor mu(displayed)
        //isSelected => radio button veya checkbox
        //isEnabled => bir öğenin etkin olup olmadığını kontrol etmek için

        //textbox'in durumunu kontrol etme.
        boolean isEnable = textBox.isEnabled();
        Assert.assertTrue(isEnable);
    }

}
