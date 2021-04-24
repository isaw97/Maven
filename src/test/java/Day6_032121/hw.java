package Day6_032121;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class hw {

    public static void main(String[] args) throws InterruptedException {

        String[] amount = new String[3];
        amount[0] = "350000";
        amount[1] = "250000";
        amount[2] = "500000";
        String[] down = new String[3];
        down[0] = "10";
        down[1] = "20";
        down[2] = "30";
        String[] term = new String[3];
        term[0] = "15";
        term[1] = "20";
        term[2] = "25";
        String[] rate = new String[3];
        rate[0] = "3.5";
        rate[1] = "5";
        rate[2] = "6.5";
        String[] Mon = new String[3];
        Mon[0] = "Apr";
        Mon[1] = "May";
        Mon[2] = "Jul";
        String[] Year = new String[3];
        Year[0] = "2022";
        Year[1] = "2023";
        Year[2] = "2024";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.mlcalc.com");
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Auto Loan Calculator")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. The actual title is " + actualTitle);
        }
        for(int i = 0; i < amount.length; i++) {
            driver.navigate().to("https://www.mlcalc.com");
            WebElement amountValue = driver.findElement(By.xpath("//*[@name='ma']"));
            amountValue.clear();
            amountValue.sendKeys(amount[i]);
            driver.findElement(By.xpath("//*[@value='Calculate']")).submit();
            Thread.sleep(3000);
            String searchResult = driver.findElement(By.xpath("//*[@id='summary']")).getText();
            String[] arrayResults = searchResult.split(" ");
            System.out.println("The monthly payment for an amount of " + amount[i] + " is " + arrayResults[0]);
            WebElement downValue = driver.findElement(By.xpath("//*[@name='dp']"));
            WebElement termValue = driver.findElement(By.xpath("//*[@name='mt']"));
            WebElement rateValue = driver.findElement(By.xpath("//*[@name='ir']"));
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
            downValue.clear();
            downValue.sendKeys(down[i]);
            termValue.clear();
            termValue.sendKeys(term[i]);
            rateValue.clear();
            rateValue.sendKeys(rate[i]);
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText(Mon[i]);
            startMonth.click();
            startMonth.click();
            Select dropyear = new Select(startYear);
            dropyear.selectByVisibleText(Year[i]);
            startYear.click();
            startYear.click();
            driver.findElement(By.xpath("//*[@value='Calculate']")).submit();
            Thread.sleep(3000);
            String YearResult = driver.findElement(By.xpath("//*[@id='summary']")).getText();
            System.out.println("The monthly payment if you start in " + Year[i] + " is " + arrayResults[0]);
        }
        driver.quit();
    }
}