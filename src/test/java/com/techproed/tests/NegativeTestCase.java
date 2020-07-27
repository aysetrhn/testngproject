package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestCase extends TestBaseFinal {
//parameter
//

    @Test(enabled = false)
    public void invalidPass() throws InterruptedException {
        extentTest=extentReports.createTest("TEST NAME","NEGATIVE TEST");
        extentTest.info("Opening the URL");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        extentTest.info("creating page object");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        //correct username but incorrect pass
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        extentTest.info("clicking");
        fhcLoginPage.logInButton.click();
        Thread.sleep(3000);
        extentTest.info("verifying");
        Assert.assertFalse(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message")));
        extentTest.pass("PASSED");


    }

    //we can use multiple parameter on single test
    //For example tehre are two parameters on this test case
    //This test case will runs two times
    @Test(groups = "regression1",invocationCount = 2)
    public void invalidID(){

        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        // Correct pass but inccorrect username
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.logInButton.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message2")));
    }

    @Test(groups = "regression1")
    public void invalidIDAndPass(){
        Driver.getDriver().get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        //Both incorrect username password
        fhcLoginPage.username.sendKeys("minagr2");
        fhcLoginPage.password.sendKeys("Man2ager2");
        fhcLoginPage.logInButton.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("Try again please"));

    }
}
