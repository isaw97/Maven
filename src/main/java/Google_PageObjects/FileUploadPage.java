package Google_PageObjects;

import Reusable.Abstract_Class;
import Reusable.skip2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends Abstract_Class {
    ExtentTest logger;
    public FileUploadPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }
    @FindBy(xpath = "(//a[@name='upload-files-button'])[1]") WebElement FileUpload;
    public void FileUploadMethod(){
        Reusable_Methods_PageObjects.clickOnElement(driver,FileUpload,logger,"File Upload");
    }

    public void ImgUpload(String path) throws InterruptedException {
        Reusable_Methods_PageObjects.uploadFile(path);
        Thread.sleep(5000);
    }
}