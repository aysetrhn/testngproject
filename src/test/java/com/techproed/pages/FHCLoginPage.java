package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHCLoginPage {
    //This is based on testbase
    WebDriver driver;
    public FHCLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //page objects
    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement logInButton;

    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement error_message;


}
