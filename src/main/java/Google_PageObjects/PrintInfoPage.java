package Google_PageObjects;

import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintInfoPage extends Abstract_Class {
    ExtentTest logger;
    public PrintInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }
    @FindBy(xpath = "//a[text()='CONTINUE WITH EXISTING']") WebElement ContinueEXISTING;
    @FindBy(xpath = "//input[@class='quantity-field']") WebElement quantity;
    @FindBy(xpath = "//button[text()='Add to cart']") WebElement AddToCart;

    public void ContinueMethod(){
        skip2.clickOnElement(driver,ContinueEXISTING,logger,"Continue EXISTING");
    }

    public void quantityMethod(String quantityNum) throws InterruptedException {
        Thread.sleep(3000);
        Reusable_Methods_PageObjects.sendKeysMethod(driver,quantity,quantityNum,logger,"quantity");
    }
    public void AddToCartMethod() throws InterruptedException {
        Thread.sleep(3000);
        Reusable_Methods_PageObjects.clickOnElement(driver,AddToCart,logger,"AddToCart");
    }
}