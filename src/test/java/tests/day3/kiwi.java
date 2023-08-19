package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class kiwi {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    TouchAction action = new TouchAction<>(driver);

    /*
    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL"); // Cihaza verdigimiz isim
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); // cihazimizin android surumu
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // cihazimizin platform ismi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.skypicker.main");
        capabilities.setCapability("appActivity", "com.kiwi.android.feature.splash.impl.ui.SplashActivity");

        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);
        // Eger ki bir uygulmada uygulamanin onbellegini her testten sonra sifirlamak istiyorsak NoRESET FALSE olmalidir !!!!
        // Eger ki bir uygulmada uygulamanin onbellegini sifirlamadan gectigimiz adimlarin kaydedilerek 0`dan uygulamanin baslamasini istemiyorsak NoRESET TRUE olmalidir !!!!

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
     */

    KiwiPage kiwiPage = new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPage.continueQuestButton.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPage.continueQuestButton.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        Thread.sleep(1000);
        kiwiPage.ilkSayfaGecisleri();

        // Trip type,one way olarak secilir
        kiwiPage.returnButton.click();
        kiwiPage.oneWayButton.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklama(455,775,1000);
        ReusableMethods.koordinatTiklama(1017,140,1000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("istanbul");
        }else {
            kiwiPage.textBox.sendKeys("Ankara");
        }
        Thread.sleep(2000);
        ReusableMethods.koordinatTiklama(300,295,1000);
        ReusableMethods.koordinatTiklama(800,970,1000);

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.koordinatTiklama(360,910,1000);
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Ordu");
        }else {
            kiwiPage.textBox.sendKeys("Samsun");
        }
        Thread.sleep(2000);
        ReusableMethods.koordinatTiklama(300,295,1000);
        ReusableMethods.koordinatTiklama(800,970,1000);

        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.koordinatTiklama(360,1050,1000);
        Thread.sleep(1000);
        ReusableMethods.screenScroolDown(1000);
        ReusableMethods.koordinatTiklama(680,820,1000); // Ayin 21`ine tikladik
        ReusableMethods.koordinatTiklama(700,1700,1000); // Set date tikladik

        // search butonuna tiklanir
        Thread.sleep(1000);
        kiwiPage.searchButton.click();

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        Thread.sleep(500);
        ReusableMethods.koordinatTiklama(257,257,1000); // Filtreye tiklariz
        ReusableMethods.koordinatTiklama(502,578,1000); // Cheapest secenegini tiklariz
        ReusableMethods.koordinatTiklama(523,257,1000); // Stops tiklariz
        ReusableMethods.koordinatTiklama(514,1450,1000); // Nonstop tiklariz

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String sonFiyat = kiwiPage.fiyatSonucu.getText();
        driver.sendSMS("5555555555","Kiwi.com uygulamasindan gelen son fiyat : "+sonFiyat);
    }
}
