package day2;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
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

        capabilities.setCapability("appPackage","com.dogan.arabam");
        // Hangi uygulama uzerinde calismak istiyorsak, Apk info`dan uygulama bilgisine ulasabiliriz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // kullanacak oldugumuz uygulamayi belirledikten sonra, o uygulamada hangi sayfadan baslamak istiyorsak
        // onun degerini activities kisminda bularak appActivity degiskeninin karsisina parametre olarak gireriz


        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void arabamTest() {
        //  driver.activateApp("com.dogan.arabam");

        // Arabam kac para bolumune tiklayalim
        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        // Wolkswagen markasini secelim
        // yil secimi yapalim
        // model secimi yapalim
        // govde tipini secelim
        // yakit tipini secelim
        // vites tipini secelim
        // Versiyon secimi yapalim
        // aracin km bilgilerini girelim
        // aracin rengini secelim
        // opsiyel donanim (varsa) seecelim
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        // uygulamayi kapatalim

    }
}
