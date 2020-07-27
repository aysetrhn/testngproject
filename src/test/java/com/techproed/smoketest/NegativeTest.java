package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {
    @Test
    public void invalidPass() throws InterruptedException {

        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        //correct username but incorrect pass
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.logInButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message")));

    }

    @Test(groups = "regression1")
    public void invalidID(){

        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        // Correct pass but inccorrect username
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.logInButton.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message2")));
    }

    @Test(groups = "regression1")
    public void invalidIDAndPass(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        //Both incorrect username password
        fhcLoginPage.username.sendKeys("minagr2");
        fhcLoginPage.password.sendKeys("Man2ager2");
        fhcLoginPage.logInButton.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("Try again please"));

    }
}
