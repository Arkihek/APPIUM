package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class kiwi {

    AndroidDriver<AndroidElement> driver;

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

    @Test
    public void kiwiAppTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
        AndroidElement continueButton = driver.findElementByXPath("//*[@text='Continue as a guest']");
        Assert.assertTrue(continueButton.isDisplayed());

        // misafir olarak devam et e tiklanir
        continueButton.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //540.1700
        TouchAction action = new TouchAction<>(driver);
        Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(540,1700)).release().perform();
            Thread.sleep(1500);
        }


        // Trip type,one way olarak secilir
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
    }
}
