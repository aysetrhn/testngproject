package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {
    @Test
    public void positiveLogInTest(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.logInButton.click();
    }

}
