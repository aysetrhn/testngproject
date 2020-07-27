package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends TestBase {
    //Create a method: login() and log in : http://www.fhctrip.com/admin/HotelRoomAdmin
    //manager2
    //Man1ager2!

    public void login() {
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    //Tum tablonun olcusunu bulmak(entireTable: tum tablo)
    @Test
    public void entireTable() throws InterruptedException {
        login();

        Thread.sleep(3000);
        WebElement tBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());

        //Tablonun olcusunu bulma ==> Tablodaki toplam hucre(cell) sayisini bul
        List<WebElement> table = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("TABLE BODY SIZE : " + table.size()); //tablo size

        List<WebElement> allHeader = driver.findElements(By.tagName("th"));
        for (WebElement header : allHeader) {
            System.out.println(header.getText());
        }

    }

    //Find the total number of rows and cells in the table body
    @Test
    public void printRows() {
        login();
        System.out.println("Tabloda toplam " + driver.findElements(By.xpath("//tbody//tr")).size() + " tane satir(row) vardir.");
        //satirlari(rows) yazdir
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row : allRows) {
            System.out.println(row.getText());
        }

        //4.satirdaki elementleri yazdir
        List<WebElement> elements4th = driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element : elements4th) {
            System.out.println(element.getText());
        }
    }
    //tablodaki toplam hucre(cell) sayisini bulma
    @Test
    public void printCells(){
        login();
        System.out.println("Tabloda toplam "+driver.findElements(By.xpath("//tbody//td")).size()+" tane cell vardir.");
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        for(WebElement cell : allCells){
            System.out.println(cell.getText());
        }
    }

    @Test
    public void printColumn(){
        login();
        System.out.println("Tabloda toplam "+driver.findElements(By.xpath("//tr[3]//td")).size()+" tane sutun(column) vardir.");
        List<WebElement> column5th = driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement element : column5th){
            System.out.println(element.getText());
        }
    }


    public void printData(int row, int column){
        //   codelari bu metodun icine yaz
        //   //tbody//tr[8]//td[6]
        //dinamik bir path yazalim
        String xpath = "//tbody//tr[" + row + "]//td[" + column + "]";
        //String xpath1 = "//tbody//tr[8]//td[6]";
        //Elementleri xpath'i kullanarak bulalim.
        WebElement data = driver.findElement(By.xpath(xpath));
        //Datalari yazdiralim
        System.out.println(data.getText());
    }
   @Test
    public void printDataTest(){
        login();
        printData(8,6);
        printData(3,4);
        printData(5,2);

   }
}