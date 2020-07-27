package com.techproed.tests;

import com.techproed.pages.DataTablesExcel;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelAutomation {

    DataTablesExcel dtExcel = new DataTablesExcel();
    ExcelUtil excelUtil;
    List<Map<String,String>> testData;
    int count = 0;

    @BeforeMethod
    public void getTestData(){
        //ExcelUtil classini kullnarak file'in ve sheet'in path'ini veriyoruz
        excelUtil = new ExcelUtil(".\\src\\test\\resources\\exceldata.xlsx","Sheet1");
        //ExcelUtil classindan getDataList() metodunu excel sheet'ten data alabilmek icin cagiriyoruz.
        testData = excelUtil.getDataList();

    }
    @Test
    public void  ExcelDataAutomation() throws InterruptedException {
        for (Map<String,String >  data : testData){
            Driver.getDriver().get("https://editor.datatables.net/");
            dtExcel.newButton.click();
            dtExcel.firstName.sendKeys(data.get("First name"));
            dtExcel.lastName.sendKeys(data.get("Last name"));
            dtExcel.position.sendKeys(data.get("position"));
            dtExcel.office.sendKeys(data.get("office"));
            dtExcel.extension.sendKeys(data.get("extension"));
            //dtExcel.startDate.sendKeys(appData.get("startdate"));
            dtExcel.startDate.click();
            dtExcel.day.click();
            dtExcel.salary.sendKeys(data.get("salary"));
            dtExcel.createButton.click();
            dtExcel.searchBox.sendKeys(data.get("First name"));
            Thread.sleep(3000);
            Assert.assertTrue(dtExcel.nameField.getText().contains(data.get("First name")));

        }

    }
}
