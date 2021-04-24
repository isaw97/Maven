package Google_PageObjects;

import Reusable.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Sweaters extends Abstract_Class {
    //declare a local logger so you can use it in your page class
    ExtentTest logger;
    public Express_Sweaters(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class
    @FindBy(xpath = "//*[@class='_2EWqA']")
    WebElement firstSweater;
    public void firstSweater(){
        Reusable_Methods_PageObjects.clickOnElement(driver,firstSweater,logger,"Sweater");
    }
}
