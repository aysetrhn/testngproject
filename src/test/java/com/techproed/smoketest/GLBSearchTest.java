package com.techproed.smoketest;

import com.techproed.pages.GlbSearchPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GLBSearchTest {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        GlbSearchPage glbSearchPage = new GlbSearchPage();

        glbSearchPage.searchButton.click();
        boolean hasCamera = false;
        for (WebElement w : glbSearchPage.productList){
            System.out.println(w.getText());
            if (w.getText().contains("Camera")){
                hasCamera = true;
                break;
            }
        }

        System.out.println("BIRINCI SAYFADA TOPLAM "+glbSearchPage.productList.size()+" TANE ELEMENT VARDIR.");
        //camera var mi dogrulayalim(Assert)
        Assert.assertTrue(hasCamera);

    }

}
