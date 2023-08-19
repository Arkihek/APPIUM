package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement continueQuestButton;
    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;
    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;
    @FindBy(className = "android.widget.EditText")
    public WebElement textBox;
    @FindBy(xpath = "//*[@text='Search']")
    public WebElement searchButton;
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement fiyatSonucu;


    public void ilkSayfaGecisleri() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklama(540,1700,1000);
        }
    }


}
