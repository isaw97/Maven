package Google_PageObjects;

import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends Abstract_Class {
    ExtentTest logger;
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }
    @FindBy(xpath = "//a[contains(@aria-label,'Start Order')]") WebElement StartOrder;

    public void StartOrderMethod(){
        Reusable_Methods_PageObjects.clickOnElement(driver,StartOrder,logger,"StartOrder");
    }
}