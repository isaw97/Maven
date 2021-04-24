package Google_PageObjects;

import Reusable.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Checkout extends Abstract_Class {
    //declare a local logger so you can use it in your page class
    ExtentTest logger;
    public Express_Checkout(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    WebElement email;
    @FindBy(xpath = "//input[@name='confirmEmail']")
    WebElement emailConfirm;
    @FindBy(xpath = "//input[@name='phone']")
    WebElement phone;
    @FindBy(xpath = "//input[@name='shipping.line1']")
    WebElement address;
    @FindBy(xpath = "//input[@name='shipping.postalCode']")
    WebElement zip;
    @FindBy(xpath = "//input[@name='shipping.city']")
    WebElement city;
    @FindBy(xpath = "//input[@name='shipping.state']")
    WebElement state;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkout;
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement Continue;
    @FindBy(xpath = "//input[@name='creditCardNumber']")
    WebElement card;
    @FindBy(xpath = "//select[@name='expMonth']")
    WebElement expMonth;
    @FindBy(xpath = "//select[@name='expYear']")
    WebElement expYear;
    @FindBy(xpath = "//input[@name='cvv']")
    WebElement cvv;
    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement placeOrder;
    @FindBy(xpath = "//div[@id='rvn-note-NaN']")
    WebElement error;
    public void firstName(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,firstName,userValue,logger,"first name");
    }public void lastName(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,lastName,userValue,logger,"last name");
    }public void email(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,email,userValue,logger,"email");
    }public void emailConfirm(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,emailConfirm,userValue,logger,"email");
    }public void phone(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,phone,userValue,logger,"phone");
    }public void Continue(){
        Reusable_Methods_PageObjects.clickOnElement(driver,Continue,logger,"continue");
    }public void address(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,address,userValue,logger,"address");
    }public void zip(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,zip,userValue,logger,"zip");
    }public void city(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,city,userValue,logger,"city");
    }public void state(){
        Reusable_Methods_PageObjects.dropdownByText(driver,state,"NY",logger,"state");
    }public void card(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,card,userValue,logger,"card");
    }public void expMonth(){
        Reusable_Methods_PageObjects.dropdownByText(driver,expMonth,"Mar",logger,"expiration month");
    }public void expYear(){
        Reusable_Methods_PageObjects.dropdownByText(driver,expYear,"2022",logger,"expiration year");
    }public void cvv(String userValue){
        Reusable_Methods_PageObjects.sendKeysMethod(driver,cvv,userValue,logger,"expiration month");
    }public void error(){
        Reusable_Methods_PageObjects.captureText(driver,error,0,logger,"error message");
    }
}
