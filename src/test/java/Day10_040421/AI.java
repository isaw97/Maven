package Day10_040421;

import Day9_040321.skip;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class AI {
    public static void main(String[] args) throws IOException, InterruptedException, BiffException, WriteException {
        //define driver
        WebDriver driver = skip.defineTheDriver();
        //locate readable excel
        Workbook readableBook = Workbook.getWorkbook(new File("C:\\Users\\Darin\\Desktop\\express.xls"));
        //create writable excel
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("C:\\Users\\Darin\\Desktop\\express2.xls"),readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);
        //get row count
        int rowCount = writableSheet.getRows();
        Actions actions = new Actions(driver);
        for(int i=1; i<rowCount; i++) {
            //read excel file content
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String emailAddress = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String streetAddress = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String ccNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvvCode = writableSheet.getCell(13, i).getContents();
            //visit express website
            driver.navigate().to("https://www.express.com/");
            Thread.sleep(3000);
            //define and exit pop-up
            WebElement button = driver.findElement(By.xpath("//*[@id='closeModal']"));
            actions.moveToElement(button).click().perform();
            //locate "Men" tab
            skip.hover(driver, "//a[text()='Men']", "Men");
            Thread.sleep(3000);
            //define and click "Polos"
            WebElement polos = driver.findElement(By.xpath("//*[text()='Polos']"));
            actions.moveToElement(polos).click().perform();
            Thread.sleep(2000);
            //select the first result
            WebElement polo = driver.findElement(By.xpath("//*[text()='Solid Performance Polo']"));
            actions.moveToElement(polo).click().perform();
            Thread.sleep(1500);
            //select size
            skip.clickOnElement(driver, "//button[@value='" + size + "']","click on size");
            Thread.sleep(500);
            //add to bag
            skip.clickOnElement(driver,"//button[text()='Add to Bag']","add to bag");
            Thread.sleep(1000);
            //view bag
            skip.clickOnElement(driver,"//a[text()='View Bag']","view bag");
            Thread.sleep(2000);
            //select quantity
            skip.dropdownByText(driver,"//select[@name='7ce2c709-5b48-42e1-843b-9c9d95c99178-quantity']",quantity,"quantity");
            //continue to checkout as guest
            skip.clickOnElement(driver,"//button[@id='continue-to-checkout']","checkout");
            skip.clickOnElement(driver,"//button[text()='Checkout as Guest']","checkout as guest");
            Thread.sleep(1000);
            //enter personal info
            skip.sendKeysMethod(driver,"//input[@name='firstname']",firstName, "first name");
            skip.sendKeysMethod(driver,"//input[@name='lastname']",lastName,"last name");
            skip.sendKeysMethod(driver,"//input[@name='email']",emailAddress, "email address");
            skip.sendKeysMethod(driver,"//input[@name='confirmEmail']",emailAddress, "confirm email");
            skip.sendKeysMethod(driver,"//input[@name='phone']",phoneNumber, "phone number");
            //continue
            skip.clickOnElement(driver,"//button[@type='submit']","continue");
            Thread.sleep(1000);
            //enter billing address info
            skip.sendKeysMethod(driver,"//input[@name='shipping.line1']",streetAddress, "address");
            skip.sendKeysMethod(driver,"//input[@name='shipping.postalCode']",zipCode, "zip code");
            skip.sendKeysMethod(driver,"//input[@name='shipping.city']",city, "city");
            skip.dropdownByText(driver,"//select[@name='shipping.state']",state,"state");
            //continue
            skip.clickOnElement(driver,"//button[@type='submit']","continue");
            Thread.sleep(3000);
            skip.clickOnElement(driver,"//span[text()='Continue']", "continue");
            Thread.sleep(1000);
            //enter payment info
            skip.sendKeysMethod(driver,"//input[@name='creditcardNumber']",ccNumber, "credit card number");
            skip.sendKeysMethod(driver,"//input[@name='shipping.postalCode']",zipCode, "zip code");
            skip.dropdownByText(driver,"//select[@name='expMonth']",expMonth,"expiration month");
            skip.dropdownByText(driver,"//select[@name='expYear']",expYear,"expiration year");
            skip.sendKeysMethod(driver,"//input[@name='cvv']",cvvCode,  "CVV code");
            //place order
            skip.clickOnElement(driver,"//button[text()='Place Order']","place order");
            Thread.sleep(1000);
            //capture error message
            String error = skip.captureText(driver,"//div[@class='_13uVj jwBXt']",0, "error message");
            //write message into writable excel cell
            Label label = new Label(6,i,error);
            writableSheet.addCell(label);
        }
        //fully write and close writable excel
        writableWorkbook.write();
        writableWorkbook.close();
        //close chrome browser
        driver.close();
    }
}
