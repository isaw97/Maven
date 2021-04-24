package Day11_041021;

import Day9_040321.skip;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class google {
    WebDriver driver = null;
    @BeforeSuite
    public void setupDriver() throws IOException, InterruptedException {
        driver = skip.defineTheDriver();
    }
    @Test(priority = 1)
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        //enter a keyword
        skip.sendKeysMethod(driver,"//*[@name='q']","cars","Google Search Field");
        //submit on google search button
        skip.submitElement(driver,"//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2500);
    }
    @Test(priority = 2)
    public void captureSearchNumber(){
        String result = skip.captureText(driver,"//*[@id='result-stats']",0, "Google Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    }
    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}
