package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

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






}
