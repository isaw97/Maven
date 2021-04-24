package Day10_040421;

import Day9_040321.skip;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class mlcalc2 {
    public static void main(String[] args) throws IOException, InterruptedException, BiffException, WriteException {
        WebDriver driver = skip.defineTheDriver();
        Workbook readableBook = Workbook.getWorkbook(new File("C:\\Users\\Darin\\Desktop\\mlcalc.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("C:\\Users\\Darin\\Desktop\\mlcalc2.xls"),readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);
        int rowCount = writableSheet.getRows();
        for(int i=1; i<rowCount; i++){
            String pPrice = writableSheet.getCell(0,i).getContents();
            String dPayment = writableSheet.getCell(1,i).getContents();
            String mTerm = writableSheet.getCell(2,i).getContents();
            String iRate = writableSheet.getCell(3,i).getContents();
            String stMonth = writableSheet.getCell(4,i).getContents();
            String stYear = writableSheet.getCell(5,i).getContents();
            driver.navigate().to("https://www.mlcalc.com");
            skip.sendKeysMethod(driver,"//input[@id='ma']",pPrice, "Purchase Price");
            skip.sendKeysMethod(driver,"//input[@id='dp']",dPayment, "Down Payment");
            skip.sendKeysMethod(driver,"//input[@id='mt']",mTerm, "Mortgage Term");
            skip.sendKeysMethod(driver,"//input[@id='ir']",iRate, "Interest Rate");
            skip.sendKeysMethod(driver,"//input[@id='ir']",iRate, "Interest Rate");
            skip.dropdownByText(driver,"//select[@name='sm']",stMonth,"Start Month");
            skip.dropdownByText(driver,"//select[@name='sy']",stYear,"Start Year");
            skip.clickOnElement(driver,"//input[@value='Calculate']","Calculate");
            String monthlyPayment = skip.captureText(driver,"//td[@class='big']",0,"Monthly Payment");
            Label label = new Label(6,i,monthlyPayment);
            writableSheet.addCell(label);
            driver.manage().deleteAllCookies();
        }
        writableWorkbook.write();
        writableWorkbook.close();
        driver.close();
    }
}
