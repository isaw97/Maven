package Day8_032821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AI {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11101");
        zipCode.add("10001");
        zipCode.add("11365");
        ArrayList<String> locationType = new ArrayList<>();
        locationType.add("Collection Boxes");
        locationType.add("Post Office");
        locationType.add("Self-Service Kiosks");
        ArrayList<String> locationMile = new ArrayList<>();
        locationMile.add("10 Miles");
        locationMile.add("20 Miles");
        locationMile.add("25 Miles");
        try{
            driver.navigate().to("https://www.usps.com");
        } catch (Exception e) {
            System.out.println("Unable to navigate to USPS website. " + e);
        }
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Welcome | USPS")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. The actual title is " + actualTitle);
        }
        for(int i = 0; i < locationMile.size(); i++) {
            Actions actions = new Actions(driver);
            try{
                driver.navigate().to("https://www.usps.com");
            } catch (Exception e) {
                System.out.println("Unable to navigate to USPS website. " + e);
            }
            try{
                WebElement Send = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
                actions.moveToElement(Send).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover over Send. " + e);
            }
            try{
                WebElement findLocations = driver.findElement(By.xpath("//*[@href='https://tools.usps.com/find-location.htm']"));
                actions.moveToElement(findLocations).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click on Find USPS Locations. " + e);
            }
            Thread.sleep(1000);
            try {
                WebElement zip = driver.findElement(By.xpath("//*[@id='city-state-input']"));
                zip.click();
                zip.clear();
                zip.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("Cannot enter zip code. " + e);
            }
            try {
                WebElement Type = driver.findElement(By.xpath("//*[@class='btn btn-default dropdown-toggle dropdown dropdownTypes dropdown-items-wrapper form-control po-location-dropdown post-offices']"));
                actions.moveToElement(Type).click().perform();
                driver.findElement(By.xpath("//*[text() = '" + locationType.get(i) + "']")).click();
                actions.moveToElement(Type).click().perform();
            } catch (Exception e) {
                System.out.println("Cannot choose location type. " + e);
            }
            try {
                WebElement Mile = driver.findElement(By.xpath("//*[@id='within-select']"));
                actions.moveToElement(Mile).click().perform();
                driver.findElement(By.xpath("//*[text() = '" + locationMile.get(i) + "']")).click();
                actions.moveToElement(Mile).click().perform();
            } catch (Exception e) {
                System.out.println("Cannot choose location distance. " + e);
            }
            Thread.sleep(3000);
            try {
                driver.findElement(By.xpath("//*[@id='searchLocations']")).click();
            } catch (Exception e) {
                System.out.println("Cannot click search. " + e);
            }
            Thread.sleep(3000);
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
                System.out.println("Cannot click results " + e);
            }
            System.out.println("-------LOCATION-------");
            try {
                String address = driver.findElement(By.xpath("//div[@class=' address-wrapper']")).getText();
                System.out.println(address);
            } catch (Exception e) {
                System.out.println("Cannot locate address. " + e);
            }
            try {
                String time = driver.findElement(By.xpath("//*[@class='hours-flex-section']")).getText();
                System.out.println(time);
            } catch (Exception e) {
                System.out.println("Cannot locate store hours. " + e);
            }
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
