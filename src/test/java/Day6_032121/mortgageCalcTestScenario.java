package Day6_032121;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class mortgageCalcTestScenario {

    public static void main(String[] args) throws InterruptedException {



        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        //define the ChromeOptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito(private)
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");

        //define the webDriver
        WebDriver driver = new ChromeDriver(options);


//navigate to mortgage calc home page
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);

//verify the title with your expected
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Mortgage Calculator")){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match." + actualTitle);
        }//end of condition



        //store home value first and enter data
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear the previous data
        homeValue.clear();
        //enter the new home value
        homeValue.sendKeys("350000");


        //store down payment first
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        //clear the previous data
        dPayment.clear();
        //enter the new down payment
        dPayment.sendKeys("220000");


        //store interest rate first
        WebElement InterestRate = driver.findElement(By.xpath("//*[@id='intrstsrate']"));
        //clear the previous data
        InterestRate.clear();
        //enter the new interest rate
        InterestRate.sendKeys("3.4");


        //select April on month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //select the locator using Select command
        Select dropdown = new Select(startMonth);
        //using by visible text command select month April
        dropdown.selectByVisibleText("Apr");


        //if dropdown is not under select tag then you have to use click command twice
        //click on dropdown
        startMonth.click();
        //click on dropdown value by text
        driver.findElement(By.xpath("//*[text()='May']")).click();

        //click on Calculate button
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(3000);


        //capture the monthly payment using findElements with first index
        String mntPayment = driver.findElements(By.xpath("//div[@class='left-cell']")).get(0).getText();
        System.out.println("My monthly payment is " + mntPayment);



    }//end of main method
}//end of java class