package Google_PageObjects;

import Reusable.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Quantity extends Abstract_Class {
    //declare a local logger so you can use it in your page class
    ExtentTest logger;
    public Express_Quantity(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class
    @FindBy(xpath = "//select[@id='qdd-0-quantity']")
    WebElement quantity;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkout;
    @FindBy(xpath = "//button[text()='Checkout as Guest']")
    WebElement guest;
    public void quantity(){
        Reusable_Methods_PageObjects.dropdownByText(driver,quantity,"2",logger,"quantity");
    }
    public void checkout(){
        Reusable_Methods_PageObjects.clickOnElement(driver,checkout,logger,"checkout");
    }
    public void guest(){
        Reusable_Methods_PageObjects.clickOnElement(driver,guest,logger,"checkout");
    }
}
