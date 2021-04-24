package Day9_040321;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = skip.defineTheDriver();

//navigate to google
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2300);
//enter something on search field
        skip.sendKeysMethod(driver,"//*[@name='q']","Cars", "Search Field");
//click on google search
        skip.clickOnElement(driver,"//*[@name='btnK']","Google Search");
        driver.close();
    }
}
