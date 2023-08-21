package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    public static void koordinatTiklama(int xDegiskeni, int yDegiskeni, int beklemeSuresi) throws InterruptedException {

        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xDegiskeni, yDegiskeni)).release().perform();
        Thread.sleep(beklemeSuresi);

    }

    public static void screenScrool(int xPress, int yPress, int wait, int xMove , int yMove){
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xPress,yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(xMove,yMove))
                .release().perform();
    }

    public static void screenScroolDown(int wait){
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471,1371))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471,187))
                .release().perform();
    }

    public static void screenScroolUp(int wait){
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471,187))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471,1371))
                .release().perform();
    }

    public static void screenScroolLeft(int wait){
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(50,900))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(1000,900))
                .release().perform();
    }

    public static void screenScroolRight(int wait){
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(1000,900))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(50,900))
                .release().perform();
    }

    public static void scrollWithUiScrollable(String elementText) { // Sadece androidDriver ile yapabiliyorum.
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }








}
