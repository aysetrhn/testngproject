package com.techproed.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FireExam {
        public static void main(String[] args) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver=new FirefoxDriver();
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("TEST");
        }

}
