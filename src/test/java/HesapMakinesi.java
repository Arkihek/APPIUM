import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMakinesi {
    AndroidDriver<AndroidElement> driver; // Android isletim sistemine sahip olan cihazlarda daha dogru sonucu vererek veya yaptigimiz islemlere dogru komutlarin verilmesini saglar
    // ve sadece android cihazlarda kullanilir
    // Android olmayan cihazlarda kesin calismaz anlamina gelmez, ama yanlislik olma olasiligi artar.


    AppiumDriver<MobileElement> driverMobile; // Hem android hem ios isletim sistemine sahip olan cihazlar icin kullanilir
    // Android driver icin ayri bir driver oldugundan dolayi, Appium driver Ios ve turevleri icin kullanilmaktadir.

    @Test
    public void hesapMakinesi() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL"); // Cihaza verdigimiz isim
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); // cihazimizin android surumu
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // cihazimizin platform ismi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // UiAutomator2 android 7 ve ustu icin kullanilir
        // UiAutomator android 6 ve altinda kalan surumlerde kullanilir.

        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ihsan\\IdeaProjects\\APPIUM_T116\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

         /*
        capabilities.setCapability("deviceName","Pixel 2");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","UiAutomator2");
        */




    }
}
