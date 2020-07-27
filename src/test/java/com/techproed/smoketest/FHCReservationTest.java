package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage1;
import com.techproed.pages.FHCReservationPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeMap;

public class FHCReservationTest {
    FHCReservationPage fhcReservationPage = new FHCReservationPage();
    FHCLoginPage1 fhcLoginPage1 = new FHCLoginPage1();
    @Test
    public void RegistrationTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("fhc_registration_url"));
        fhcLoginPage1.login("manager2","Man1ager2!");

        Select idUserselect = new Select(fhcReservationPage.idUserSelectUser);
        idUserselect.selectByIndex(1);

        Select idUserSelect2 = new Select(fhcReservationPage.idUserSelectRoom);
        idUserSelect2.selectByIndex(2);

        fhcReservationPage.price.sendKeys("500");

        fhcReservationPage.dateStart.sendKeys("07/10/2020");

        fhcReservationPage.dateEnd.sendKeys("07/20/2020");
        fhcReservationPage.adultAmount.sendKeys("2");
        fhcReservationPage.childrenAmount.sendKeys("3");
        fhcReservationPage.nameSurname.sendKeys("Maria a.");
        fhcReservationPage.phone.sendKeys("(777)777-7777");
        fhcReservationPage.email.sendKeys("test@fakeemail.com");
        fhcReservationPage.notes.sendKeys("Deniz manzarasi");
        fhcReservationPage.isApproved.click();
        fhcReservationPage.isPaid.click();
        fhcReservationPage.saveButton.click();

        Thread.sleep(3000);

        String message = fhcReservationPage.success_message.getText();
        Assert.assertTrue(message.equals("RoomReservation was inserted successfully"));



    }
}
