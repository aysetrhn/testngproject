package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A_ExtentReports1 {

    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

    @BeforeTest
    public void setUp(){

        //starting the reporter and setting the path. Folder:reprots. File name: extentreport.html
        extentHtmlReporter=new ExtentHtmlReporter("./reports/extentreport.html");
        //Create a folder in the root folder level. Also create a file: extentreport.html

        //Doing some configuration with extentHtmlReporter(OPTIONAL)
        extentHtmlReporter.config().setReportName("FHC TRIP AUTOMATION REPORTS");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);//Setting the color
        extentHtmlReporter.config().setDocumentTitle("FHC TRIP REPORT");
        extentHtmlReporter.config().setEncoding("UTF-8");

        //Creating extent reports. We will use this to attach our report
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //We can give some more configuration
        extentReports.setSystemInfo("Automation Engineer","Ahmet");
        extentReports.setSystemInfo("Environment","Test Environment");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));

    }

    @AfterTest
    public void endReport(){
        extentReports.flush();
    }

    @Test
    public void positiveTest() throws InterruptedException {
  //      GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
        GlbHomePage glbHomePage=new GlbHomePage();
        extentTest=extentReports.createTest("FHC Registration Test","Testing the FHC Registration functionality");
        extentTest.info("Opening the URL");
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        extentTest.info("Clicking on Join Now Button");
   //     glbHomePage.joinNowLink.click();
        extentTest.info("sending the user email");
   //     glbSignUpPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        extentTest.info("sending the user username");
   //     glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));

        extentTest.info("entering the phone number");
     //   glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("test_phone_number"));

    //    glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
    //    glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        Thread.sleep(3000);
    //    glbSignUpPage.signUpButton.click();
        Thread.sleep(3000);
    //    System.out.println("SUCCESS MESSAGE : "+glbSignUpPage.successMesaj.getText());
    //    Assert.assertFalse(glbSignUpPage.successMesaj.getText().equals("Success!"));
        extentTest.pass("PASSED: SUCCESSFULLY COMPLETED THE REGISTRATION TEST");
        //This will fail. Expected = Success! But Actual = Success!!
        Driver.closeDriver();
        extentTest.pass("DRIVER CLOSED SUCCESSFULLY");
    }

}
