package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase {
    @Test
    public void roomCreateTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        WebElement userNameBox = driver.findElement(By.id("UserName"));
        WebElement passwordBox = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        userNameBox.sendKeys("manager2");
        passwordBox.sendKeys("Man1ager2!");
        loginButton.click();

        WebElement addHotelRoomButton = driver.findElement(By.className("hidden-480"));
        addHotelRoomButton.click();

        //"Create Hotel Room" yazisi gorunuyor mu dogrula(verify)
        WebElement createHotelRoomText = driver.findElement(By.className("caption"));
        Assert.assertTrue(createHotelRoomText.isDisplayed());

        //Id Hotel
        WebElement idHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(idHotel);
        select.selectByIndex(1); //select 1.dropdown option
       // select.selectByVisibleText("Hilton Hotel");
        //Code
        driver.findElement(By.id("Code")).sendKeys("Royal");
        //Name
        driver.findElement(By.id("Name")).sendKeys("111");
        //Descriptions
        driver.findElement(By.xpath("//div[@id='cke_1_contents']//textarea")).sendKeys("Bu oda sadece royal aileler icin");
        //Price
        WebElement source = driver.findElement(By.xpath("//li[@data-id='700']"));
        WebElement target = driver.findElement(By.name("Price"));
        //Actions classi kullanarak drag and drop yapabiliriz
        //Drag and drop iki parametre alir. 1.si source(kaynak) , 2.si target(hedef)
        Thread.sleep(3000); //senkronizayon sorunu oldugunda, wait kullanmamiz gerekir.
        actions.dragAndDrop(source,target).perform();
        //room type
        WebElement roomType = driver.findElement(By.id("IDGroupRoomType"));
        Select option = new Select(roomType);
        option.selectByIndex(6);
        //max adult count
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        //max child count
        driver.findElement(By.id("MaxChildCount")).sendKeys("2");
        //click save buton
        driver.findElement(By.id("btnSubmit")).click();

        //Text'in "HotelRoom was inserted successfully" le ayni oldugunu dogrulayin(verify)
        //Thread.sleep(5000); //Sorunu cozmek icin iyi bir yontem degil.
        //Implicitly wait ise calismiyor. TestBase de 10 saniyelik vardi.
        //Bu yuzden burada explicitly wait deneyecegiz.
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);

        //click Ok button
        WebElement okButton = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        okButton.click();

        //Click Hotel Rooms
        WebElement hotelRoomsLink = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
        Thread.sleep(3000);
        actions.doubleClick(hotelRoomsLink).perform();

        //Veriyfy "LIST OF HOTELROOMS" is displayed
        WebElement listOfHotel = driver.findElement(By.xpath("(//*[.='List Of Hotelrooms'])[2]"));
        Assert.assertTrue(listOfHotel.isDisplayed());

        //Verify
//        String myHotelName = driver.findElement(By.xpath("//tr[10]//td[2]")).getText();
//        Assert.assertTrue(myHotelName.equals("Hilton Hotel-1"));


    }

}
