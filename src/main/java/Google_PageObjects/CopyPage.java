package Google_PageObjects;

import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CopyPage extends Abstract_Class {
    ExtentTest logger;
    public CopyPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }
    @FindBy(xpath = "//img[@alt='Copies & Custom Projects']") WebElement CopiesCustom;

    public void CopiesCustomMethod(){
        Reusable_Methods_PageObjects.clickOnElement(driver,CopiesCustom,logger,"Copies & Custom");
    }

}