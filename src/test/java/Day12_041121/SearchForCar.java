package Day12_041121;

import Day9_040321.skip;
import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SearchForCar extends Abstract_Class {
    @Test
    public void SearchForACar() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2500);
        //search for a car
        //skip2.sendKeysMethod(driver,"//*[@name='q']","cars",logger,"Search Field");
        //submit on google search button
        //skip2.submitOnElement(driver,"//*[@name='btnK']",logger,"Google Search");
        Thread.sleep(3000);
    }//end of test 1

    @Test(dependsOnMethods = "SearchForACar")
    public void getSearchNumber(){
        //String result = skip2.captureText(driver,"//*[@id='result-stats']",0,logger,"Google Search Result");
        //String[] arrayResult = result.split(" ");
        //logger.log(LogStatus.INFO,"My search number is " + arrayResult[1]);
    }
}
