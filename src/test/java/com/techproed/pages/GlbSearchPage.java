package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbSearchPage {
    //driver ===>>> Driver.getDriver()
    public GlbSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".btn-warning")
    public WebElement searchButton;

    @FindBy(xpath = "//h4")
    public List<WebElement> productList;
}
