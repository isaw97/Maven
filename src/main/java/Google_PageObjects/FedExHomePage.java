package Google_PageObjects;

import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FedExHomePage extends Abstract_Class {
    ExtentTest logger;
    public FedExHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }
    @FindBy(xpath = "//a[contains(@aria-label,'Open Design')]") WebElement DesignPrint;

    @FindBy(xpath = "//a[contains(@aria-label,'All Products')]") WebElement AllProducts;

    public void DesignPrintMethod(){Reusable_Methods_PageObjects.clickOnElement(driver,DesignPrint,logger,"Design & Print");
    }

    public void AllProductsMethod(){
        Reusable_Methods_PageObjects.clickOnElement(driver,AllProducts,logger,"AllProducts");
    }
}