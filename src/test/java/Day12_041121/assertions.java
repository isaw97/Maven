package Day12_041121;

import Day9_040321.skip;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class assertions {
    @Test
        public void assertions () throws IOException, InterruptedException {

            WebDriver driver = skip.defineTheDriver();

            driver.navigate().to("https://www.google.com");

            //using hard assert verify the google title
            //Assert.assertEquals("google",driver.getTitle());

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals("google", driver.getTitle());

            //enter something on google search
            skip.sendKeysMethod(driver, "//*[@name='q']", "Cars", "Search");

            //assertAll should be the last step on your test
            softAssert.assertAll();
        }
}
