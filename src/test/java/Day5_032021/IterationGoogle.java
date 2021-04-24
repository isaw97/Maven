package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IterationGoogle {
    public static void main(String[] args) throws InterruptedException {
        String[] cities = new String[3];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "New York City";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        for(int i = 0; i < cities.length; i++){
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        Thread.sleep(3000);
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String[] arrayResults = searchResult.split(" ");
        System.out.println("The city" + cities[i] + "search number is" + arrayResults[1]);
    }
    }
}
