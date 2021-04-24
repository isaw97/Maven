package Day12_041121;

import Reusable.Abstract_Class;
import Reusable.skip2;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class AI extends Abstract_Class {
    @Test
    public void AI() throws InterruptedException, IOException, BiffException, WriteException {
        //define the driver
        WebDriver driver = skip2.defineTheDriver();
        //locate the readable file
        Workbook readableBook = Workbook.getWorkbook(new File("C:\\Users\\Darin\\Desktop\\express.xls"));
        //create the writable workbook
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("C:\\Users\\Darin\\Desktop\\express2.xls"),readableBook);
        //read from the writable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);
        //get row count
        int rowCount = writableSheet.getRows();
        //initiate the loop
        for (int i = 1; i < rowCount; i++) {
            String Size = writableSheet.getCell(0,i).getContents();
            String Quantity = writableSheet.getCell(1,i).getContents();
            String firstName = writableSheet.getCell(2,i).getContents();
            String lastName = writableSheet.getCell(3,i).getContents();
            String email = writableSheet.getCell(4,i).getContents();
            String phone = writableSheet.getCell(5,i).getContents();
            String streetAddress = writableSheet.getCell(6,i).getContents();
            String zipcode = writableSheet.getCell(7,i).getContents();
            String city = writableSheet.getCell(8,i).getContents();
            String state = writableSheet.getCell(9,i).getContents();
            String ccNumber = writableSheet.getCell(10,i).getContents();
            String expMonth = writableSheet.getCell(11,i).getContents();
            String expYear = writableSheet.getCell(12,i).getContents();
            String cvvCode = writableSheet.getCell(13,i).getContents();

            //navigate to site
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.express.com");
            Thread.sleep(1000);
            //close the fucking ad that keeps coming up
            skip2.clickOnElement(driver, "//*[@id='closeModal']", "Close Ad");
            Thread.sleep(1000);
            //hover over Men tab
            skip2.mouseHover(driver, "//a[text()='Men']",logger, "Men Tab");
            Thread.sleep(1000);
            //Click on Sweatshirts and Hoodies
            skip2.clickOnElement(driver, "//a[text()='Sweatshirts & Hoodies']", "Sweatshirts");
            Thread.sleep(1000);
            //click on the first sweater you see
            skip2.clickOnElement(driver, "//*[@class='_2EWqA']", "First Item");
            Thread.sleep(1500);
            //click on a size
            skip2.clickOnElement(driver, "//button[@value='" + Size + "']","Click on Size");
            Thread.sleep(1000);
            //click on Add to Bag
            skip2.clickOnElement(driver, "//button[text()='Add to Bag']", "Add to Bag");
            Thread.sleep(2000);
            //click on view bag
            skip2.clickOnElement(driver,"//*[text()='View Bag']","View Bag");
            Thread.sleep(1000);
            //change the quantity
            skip2.dropdownByText(driver,"//*[@id='qdd-0-quantity']", Quantity , "Quantity of Item");
            Thread.sleep(1000);
            //click on checkout
            skip2.clickOnElement(driver,"//button[text()='Checkout']","Checkout");
            Thread.sleep(1000);
            //checkout as guest
            skip2.clickOnElement(driver,"//button[text()='Checkout as Guest']","Checking out as Guest");
            Thread.sleep(1000);
            //enter first name
            skip2.sendKeysMethod(driver,"//input[@name='firstname']", firstName,logger, "First Name");
            //enter last name
            skip2.sendKeysMethod(driver,"//input[@name='lastname']", lastName,logger, "Last Name");
            //enter email
            skip2.sendKeysMethod(driver,"//input[@name='email']", email,logger, "Email");
            //confirm email
            skip2.sendKeysMethod(driver,"//input[@name='confirmEmail']", email,logger, "Email");
            //enter phone number
            skip2.sendKeysMethod(driver,"//input[@name='phone']", phone,logger, "Phone Number");
            Thread.sleep(1500);
            //click on continue
            skip2.clickOnElement(driver,"//span[text()='Continue']","Continue Button");
            Thread.sleep(1500);
            //enter a street address
            skip2.sendKeysMethod(driver,"//input[@name='shipping.line1']", streetAddress,logger, "Street Address");
            //enter a valid zipcode
            skip2.sendKeysMethod(driver,"//input[@name='shipping.postalCode']",zipcode,logger, "ZipCode");
            //enter a city (NYC Boroughs)
            skip2.sendKeysMethod(driver,"//input[@name='shipping.city']",city,logger, "City Name");
            //select a state
            skip2.dropdownByText(driver,"//select[@name='shipping.state']",state,"State");
            Thread.sleep(1000);
            //click on continue
            skip2.clickOnElement(driver,"//span[text()='Continue']","Continue Button");
            Thread.sleep(3000);
            //Click on Continue again
            skip2.clickOnElement(driver,"//span[text()='Continue']", "Continue Button");
            Thread.sleep(3000);
            //enter a fake credit card number
            skip2.sendKeysMethod(driver,"//input[@id='creditCardNumberInput']",ccNumber,logger,"Credit Card Number");
            //select an expiration date
            skip2.dropdownByText(driver,"//select[@name='expMonth']", expMonth, "Expiration Month");
            Thread.sleep(1500);
            //select an expiration year
            skip2.dropdownByText(driver,"//select[@name='expYear']", expYear, "Expiration Year");
            Thread.sleep(1500);
            //enter cvv
            skip2.sendKeysMethod(driver,"//input[@name='cvv']", cvvCode,logger, "CVV");
            //click on place order
            skip2.clickOnElement(driver,"//span[text()='Place Order']", "Place an Order");
            //capture error code and write it on Excel
            String errorMessage = skip2.captureText(driver,"//div[@class='_13uVj jwBXt']",0,logger, "Error Message");
            Label error = new jxl.write.Label(14,i,errorMessage);
            writableSheet.addCell(error);
        }//end of loop

        //write it in the workbook
        writableWorkbook.write();
        writableWorkbook.close();
        //close chrome browser
        driver.close();
    }//end of main
}//end of java
