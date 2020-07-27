package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverTest {

    @Test
    public void invalidPass() throws InterruptedException {
        //driver ===>>> Driver.
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        //correct username, incorrect pass
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.logInButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message")));
    }
}
