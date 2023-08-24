package tests.apkSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class apkSetUp {
    AndroidDriver<AndroidElement> driver;
    @Test
    public void apkSetup() throws MalformedURLException {

        final String deviceName = "Redmi Note 10";
        final String platformVersion = "12.0";
        final String platformName = "Android";
        final String automationName = "UiAutomator2";
        final String apkUrl = "C:\\Users\\ihsan\\IdeaProjects\\APPIUM_T116\\Apps\\all-currency-converter-3-9-0 (1).apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); // Cihaza verdigimiz isim
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion); // cihazimizin android surumu
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName); // cihazimizin platform ismi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);

        capabilities.setCapability(MobileCapabilityType.APP, apkUrl);

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
