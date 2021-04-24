package Day8_032821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;

public class ttt {
    public static void main(String[] args) throws InterruptedException, IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        ArrayList<String> findLocationByZip = new ArrayList<String>();
        findLocationByZip.add("11218");
        findLocationByZip.add("11219");
        findLocationByZip.add("11220");

        //location type
        ArrayList<String> locationType = new ArrayList<String>();
        locationType.add("Collection Boxes");
        locationType.add("Contract Postal Unit");
        locationType.add("Self-Service Kiosks");

        // Location mile
        ArrayList<String> locationMile = new ArrayList<String>();
        locationMile.add("25 Miles");
        locationMile.add("50 Miles");
        locationMile.add("100 Miles");

        //Locators
        String URL = "https://www.usps.com/";
        String expectedTitle = "Welcome | USPS";
        String sendID = "mail-ship-width";
        String LocationsXPath = "//a[text()='Find USPS Locations']";
        String zipCodeXPath = "//input[@id='city-state-input']";
        String locationTypeXPath = "//button[@id='post-offices-select']";
        String withinMileXPath = "//button[@id='within-select']";
        String searchButton = "//a[@id='searchLocations']";
        String resultBox = "//div[@id='resultBox']";
        String addressXPath = "//div[@class=' address-wrapper']";
        String HourTitle = "//h3[text()='Hours']";
        String TimeXpath = "//div[@class='hours-flex-section']";
        String warning = "Not able to find the element look at here: -> ";


        for (int i = 0; i < locationMile.size(); i++) {

            //1. Navigate to USPS.com
            try {
                driver.navigate().to(URL);
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //2. Verify the title equals Welcome | USPS
            try {
                String actualTitle = driver.getTitle();
                if (actualTitle.equals(expectedTitle)) {
                    System.out.println("Match the title: " + expectedTitle);
                } else {
                    System.out.println("Does not match the title");
                }
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //3. Hover to 'Send' tb using mouse actions
            Actions mouseAction = new Actions(driver);
            try {
                WebElement send = driver.findElement(By.id(sendID));
                mouseAction.moveToElement(send).perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //4. Click on 'Find USPS Locations'
            try {
                WebElement Locations = driver.findElement(By.xpath(LocationsXPath));
                mouseAction.moveToElement(Locations).click().perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //5.On Find a location dropdown enter desire zip code from arrayList
            try {
                WebElement zipCode = driver.findElement(By.xpath(zipCodeXPath));
                zipCode.click();
                zipCode.sendKeys(findLocationByZip.get(i));
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //6. Choose a location type from a dropdown based on arrayList
            try {
                WebElement LocationType = driver.findElement(By.xpath(locationTypeXPath));
                LocationType.click();
                WebElement LocationsTypes = driver.findElement(By.xpath("//a[text()='" + locationType.get(i) + "']"));
                mouseAction.moveToElement(LocationsTypes).click().perform();
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println(warning + e);
            }


            //7. Choose a desired mile from the dropdown
            try {
                WebElement WithinMiles = driver.findElement(By.xpath(withinMileXPath));
                WithinMiles.click();
                WebElement MilesTypes = driver.findElement(By.xpath("//a[text()='" + locationMile.get(i) + "']"));
                mouseAction.moveToElement(MilesTypes).click().perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //8. Click on search button
            try {
                driver.findElement(By.xpath(searchButton)).click();
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //9.Iteration
            Thread.sleep(4000);
            try {
                ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//div[@role='button']")));
                if (i==0) {
                    links.get(0).click();
                } else if (i==1){
                    links.get(1).click();
                }else  if(i==2){
                    links.get(2).click();
                }
            } catch (Exception e) {
                System.out.println(warning + e);

            }

            //10. Capture the address and print out the address
            try {
                Thread.sleep(2000);
                String address = driver.findElement(By.xpath(addressXPath)).getText();
                System.out.println(address);
            } catch (Exception e) {
                System.out.println(warning + e);
            }

            //11. Capture hour and times
            try {
                Thread.sleep(2000);
                String hour = driver.findElement(By.xpath(HourTitle)).getText();
                System.out.println(hour);
                Thread.sleep(2000);
                String time = driver.findElement(By.xpath(TimeXpath)).getText();
                System.out.println(time);
            } catch (Exception e) {
                System.out.println(warning + e);
            }
            System.out.println("-----------------------------------");

        }
        Thread.sleep(3000);
        driver.close();
    }
}
