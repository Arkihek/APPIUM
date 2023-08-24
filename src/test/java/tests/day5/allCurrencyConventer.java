package tests.day5;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyConventerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class allCurrencyConventer {

    AndroidDriver<AndroidElement> driver = Driver.getDriver();
    AppiumDriver<MobileElement> appiumDriver; // Appium Driver da findElementByAndroidUIAutomator degeri Appium driver da olmadigi icin,
    // Android cihazlarda element bulmak icin DRIVER olarak AndroidDriver`i kullaniyoruz.
    AllCurrencyConventerPage allCurrencyConventerPage = new AllCurrencyConventerPage();

    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // uygulamanin acildigi dogrulanir
        String actualText = allCurrencyConventerPage.uptadeButton.getText();
        String expectedText = "CURRENCY\n" +
                "UPDATE";
        // Assert.assertEquals(actualText,expectedText);

        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklama(430,330,1000);
        ReusableMethods.scrollWithUiScrollable("PLN");

        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklama(430,480,1000);
        ReusableMethods.scrollWithUiScrollable("TRY");
        ReusableMethods.scrollWithUiScrollable("1");
        ReusableMethods.scrollWithUiScrollable("0");
        ReusableMethods.scrollWithUiScrollable("0");
        ReusableMethods.scrollWithUiScrollable("0");

        // cevrilen tutar screenShot olarak kaydedilir
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("CeviriSonuc.jpg")); // Dinamik olmadan ekran kaydi almak istersek

        ReusableMethods.getScreenshot("ZlotyToTry");

        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String result = allCurrencyConventerPage.result.getText();
        System.out.println(result);
        driver.sendSMS("5550555",result);

        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir

    }
}
