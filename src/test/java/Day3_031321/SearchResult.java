package Day3_031321;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class SearchResult {
    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Darin\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("www.google.com");
    }
}
