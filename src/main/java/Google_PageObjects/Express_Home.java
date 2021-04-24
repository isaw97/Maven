package Google_PageObjects;

import Reusable.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Home extends Abstract_Class {
    ExtentTest logger;
    public Express_Home(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@id='closeModal']")
    WebElement closeAd;
    @FindBy(xpath = "//a[text()='Men']")
    WebElement Men;
    @FindBy(xpath = "//a[text()='Sweatshirts & Hoodies']")
    WebElement Sweaters;

    public void closeAd(){
        Reusable_Methods_PageObjects.clickOnElement(driver,closeAd,logger,"close Ad");
    }

    public void Men(){
        Reusable_Methods_PageObjects.mouseHover(driver,Men,logger,"Men");
    }//end of hover

    public void Sweaters(){
        Reusable_Methods_PageObjects.clickOnElement(driver,Sweaters,logger,"Sweatshirts");
    }
}

