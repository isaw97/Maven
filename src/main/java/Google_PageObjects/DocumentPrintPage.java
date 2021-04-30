package Google_PageObjects;

import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPrintPage extends Abstract_Class {
    ExtentTest logger;
    public DocumentPrintPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }
    @FindBy(xpath = "//a[@title='Document Printing']") WebElement DocumentPrinting;

    public void DocumentPrintMethod(){
        Reusable_Methods_PageObjects.clickOnElement(driver,DocumentPrinting,logger,"Document Printing");
    }
}