package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        Thread.sleep(3000);
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String[] arrayResults = searchResult.split(" ");
        System.out.println("My search number is" + arrayResults[1]);

    }
}
