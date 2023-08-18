package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableMethods {

    public static void koordinatTiklama(int xDegiskeni, int yDegiskeni, int beklemeSuresi) throws InterruptedException {

        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xDegiskeni, yDegiskeni)).release().perform();
        Thread.sleep(beklemeSuresi);

    }




}
