package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonDropdown extends TestBase {

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com/");
        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownElement);
        String firstOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(firstOption,"All Departments");
        //select 6.option by index
        select.selectByIndex(5);
        String option6 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option6,"Books");

        //tum option lari yazdir
        List<WebElement> allOptions = select.getOptions();
        for(WebElement option : allOptions){
            System.out.println(option.getText());
        }

        //"Electronics" option dropdown da var mi kontrol et. Varsa true , yoksa false yazdir.
        boolean flag = false;
        for (WebElement option : allOptions){
            if (option.getText().equals("Electronics")){
                flag = true;
                break;
            }
        }
        System.out.println(flag);

    }
}
