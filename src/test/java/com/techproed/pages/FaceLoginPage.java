package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
    //create driver
    WebDriver driver;
    //Constructor kullanarak driver'i baslat
    public FaceLoginPage(WebDriver driver){
        this.driver=driver;
        //Page objectleri baslatmak icin PageFactory.initElements kullaniyoruz
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement logInButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement error_mesaj;


}
