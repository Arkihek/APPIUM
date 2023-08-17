package day2;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class arabamCom {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL"); // Cihaza verdigimiz isim
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); // cihazimizin android surumu
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // cihazimizin platform ismi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ihsan\\IdeaProjects\\APPIUM_T116\\Apps\\arabam.com_4.8.0_Apkpure.apk"); // Bu yuklemek icin

        capabilities.setCapability("appPackage", "com.dogan.arabam");
        // Hangi uygulama uzerinde calismak istiyorsak, Apk info`dan uygulama bilgisine ulasabiliriz
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        // kullanacak oldugumuz uygulamayi belirledikten sonra, o uygulamada hangi sayfadan baslamak istiyorsak
        // onun degerini activities kisminda bularak appActivity degiskeninin karsisina parametre olarak gireriz

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void arabamTest() throws InterruptedException {
        //  driver.activateApp("com.dogan.arabam");
        // Uygulamanin yuklendigi test edilir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // Uygulamanin acildigi dogrulanir
        AndroidElement headerKontrol = driver.findElementById("com.dogan.arabam:id/tvShowroomInfo");
        Assert.assertTrue(headerKontrol.isDisplayed());

        // Arabam kac para bolumune tiklayalim
        driver.findElementById("com.dogan.arabam:id/tvPricePrediction").click();

        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();

        // Wolkswagen markasini secelim
        TouchAction action = new TouchAction<>(driver);
        // 535 - 1726
        // 535 - 240
        action.press(PointOption.point(535, 1726))            // telefondaki ilk tiklama islemini yaptigimiz yer
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // press ve moveTo adimindaki mesafenin zaman araligi
                .moveTo(PointOption.point(535, 240))          // telefondaki kaydirma islemini gerceklestirecegimiz yer
                .release()                                                   // ekrandan parmagimizi kaldirma
                .perform();                                                  // action`in gorevleri yerine getir emrini verdigimiz kisim

        // Egerki wait actiondaki sure milisaniye olarak arttirilirsa ekranin assagiya kayma hizimiz yavaslar ve daha az mesafe kat ederiz
        // Egerki wait actiondaki sure milisaniye olarak azaltilirsa ekranin assagiya kayma hizimiz artar ve daha fazla mesafe kat ederiz
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // 2018 yil secimini yapalim
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='2018']").click();

        // Passat model secimi yapalim
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='Passat']").click();

        // Sedan govde tipini secelim
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='Sedan']").click();

        // Benzin yakit tipini secelim
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='Benzin']").click();

        // Yari otamatik vites tipini secelim
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='Yarı Otomatik']").click();

        // Versiyon secimi yapalim
        Thread.sleep(1500);
        action.press(PointOption.point(456, 670))
                .release()
                .perform();

        // aracin km bilgilerini olarak girelim
        AndroidElement kmBox = driver.findElementById("com.dogan.arabam:id/et_km");
        if (!driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("150000");
        } else {
            kmBox.sendKeys("100000");
        }
        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();

        // aracin rengini secelim
        Thread.sleep(1500);
        driver.findElementByXPath("(//*[@class='android.widget.LinearLayout'])[22]").click();

        // opsiyel donanim (varsa) seecelim
        driver.findElementById("com.dogan.arabam:id/btnNext").click();

        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        Thread.sleep(1500);
        action.press(PointOption.point(538, 795)).release().perform();
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='Değişmiş']").click();
        Thread.sleep(1500);
        driver.findElementById("com.dogan.arabam:id/btn_next").click();
        Thread.sleep(500);
        driver.findElementById("com.dogan.arabam:id/rbHasNoTramerEntry").click();
        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        AndroidElement ortalamaFiyatSonucuLocate = driver.findElementById("com.dogan.arabam:id/tvAveragePrice");
        String ortalamaSonSonuc = ortalamaFiyatSonucuLocate.getText();
        System.out.println(ortalamaSonSonuc); // 1.169.500 TL
        ortalamaSonSonuc = ortalamaSonSonuc.replaceAll("\\D", "");
        System.out.println(ortalamaSonSonuc); // 1169500

        int actualPrice = Integer.parseInt(ortalamaSonSonuc);
        int expectedPrice = 500000;

        Assert.assertTrue(actualPrice > expectedPrice);

        // uygulamayi kapatalim
        driver.closeApp();

    }
}
