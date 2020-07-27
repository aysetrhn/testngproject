package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Selenium windows aplikasyonlarini test edemez
    //Bir dosyanin var olup olmadigini dogrulamak icin Java consept kullaniriz

    @Test
    public void isExist(){
        String currentFolder = System.getProperty("user.dir"); //mevcut dosyanin yolunu(path) verir.
        System.out.println("CURRENT FOLDER : "+currentFolder);

        String userFolder = System.getProperty("user.home"); // kullanici dosyanin yolunu(path) verir.
        System.out.println("USER FOLDER : "+userFolder);
//                          /Users/PC/
        String pathOfFile = userFolder + "/Downloads/logo.jpg";
        //String pathOfFile = "/Users/PC/Downloads/logo.jpg";

        //Artik file gidis yolu var. Java kullanarak dosya var mi kontrol edebilirim.
        boolean isFileExist = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isFileExist);//Eger dosya varsa(file exist) true,yoksa fail.
    }

    @Test
    public void downloadTest() throws InterruptedException {
        //linke gidiyoruz
        driver.get("https://the-internet.herokuapp.com/download");
        //Indirmek istegigimiz elementi buluyoruz
        WebElement file = driver.findElement(By.linkText("4657035f33839aa8cc8a053d78b0e4ed.jpg"));
        //click file
        file.click();

        //Dosyanin yuklenmesi icin biraz beklemeye(wait) ihtiyac var
        Thread.sleep(3000);
        //User folder(kullanici klasoru)
        String userFolder = System.getProperty("user.home");
        //Indirilen dosyaya gidis yolunu(path) buluyoruz.
        String pathOfFile = userFolder+"/Downloads/4657035f33839aa8cc8a053d78b0e4ed.jpg";
        //String pathOfFile ="/Users/PC/Downloads/underwater.jpg";  //Bu da olabilir
        //Dosya var mi kontrol ediyoruz(verify if file exists)
        boolean isDownloaded = Files.exists(Paths.get(pathOfFile));
        //
        Assert.assertTrue(isDownloaded); //dosya varsa pass, yoksa fail
    }
}
