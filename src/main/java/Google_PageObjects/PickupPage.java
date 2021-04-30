package Google_PageObjects;

import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickupPage extends Abstract_Class {
    ExtentTest logger;
    public PickupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }
    @FindBy(xpath = "//select[@id='radiusSelect']") WebElement Miles;
    @FindBy(xpath = "//input[@id='loc_seacrh_text']") WebElement ZipCode;
    @FindBy(xpath = "//a[@id='saveNContBtn']") WebElement Continue;

    public void MilesMethod(String miles) throws InterruptedException {
        Thread.sleep(3000);
        Reusable_Methods_PageObjects.dropdownByText(driver,Miles,miles,logger,"Miles");
    }

    public void ZipCodeMethod(String zip) throws InterruptedException {
        Thread.sleep(3000);
        Reusable_Methods_PageObjects.sendKeysMethod(driver,ZipCode,zip,logger,"ZipCode");
    }

    public void ContinueMethod() throws InterruptedException {
        Thread.sleep(3000);
        Reusable_Methods_PageObjects.clickOnElement(driver,Continue,logger,"Continue");
    }
}