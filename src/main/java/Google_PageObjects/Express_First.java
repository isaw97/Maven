package Google_PageObjects;

import Reusable.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_First extends Abstract_Class {
    //declare a local logger so you can use it in your page class
    ExtentTest logger;
    public Express_First(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class
    @FindBy(xpath = "//button[@value='M']")
    WebElement Size;
    @FindBy(xpath = "//button[text()='Add to Bag']")
    WebElement addToBag;
    @FindBy(xpath = "//*[text()='View Bag']")
    WebElement viewBag;
    public void Size(){
        Reusable_Methods_PageObjects.clickOnElement(driver,Size,logger,"Google Search");
    }
    public void addToBag(){
        Reusable_Methods_PageObjects.clickOnElement(driver,addToBag,logger,"Google Search");
    }
    public void viewBag(){
        Reusable_Methods_PageObjects.clickOnElement(driver,viewBag,logger,"Google Search");
    }
}
