package Reusable;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class skip2 {
    public static WebDriver defineTheDriver() throws InterruptedException, IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1000);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver defineTheDriverByHeadless() throws InterruptedException, IOException {
        //kill all chrome instances that are opened
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1000);
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito(private)
        options.addArguments("incognito");
        //set it to headless
        options.addArguments("headless");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of navigate method with headless

    //method to click on any webelement by explicit wait
    public static void mouseHover(WebDriver driver, String xpathLocator, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //mouse action command
        Actions actions = new Actions(driver);
        //use try catch to locate an element and click on it
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully hover to " + elementName);
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to hover to an element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover to an element " + elementName + " " + e);
        }
    }//end of mouseHover

    //method to click on any webelement by explicit wait
    public static void clickOnElement(WebDriver driver,String xpathLocator, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of click method

    //method to click on any webelement by explicit wait
    public static void closePopupIfExist(WebDriver driver,String xpathLocator, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            System.out.println("Popup " + elementName + " is not present. Move on to the next step");
        }
    }//end of closePopupIfExist

    //method to submit on any webelement by explicit wait
    public static void submitOnElement(WebDriver driver,String xpathLocator, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
            logger.log(LogStatus.PASS,"Successfully submit on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit method

    //method to type on any webelement by explicit wait
    public static void sendKeysMethod(WebDriver driver,String xpathLocator, String userValue,ExtentTest logger,String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully entered a value on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to enter value on element " + elementName + " " + e);
            System.out.println("Unable to enter value on element " + elementName + " " + e);
        }
    }//end of sendkeys method


    public static void dropdownByText(WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
    }//end of dropdown by text

    public static String captureText(WebDriver driver,String xpath,int index,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
        return result;
    }
    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src//main//HtmlReport//Screenshots//";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method
}
