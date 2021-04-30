package FedExAI;
import Google_PageObjects.Base_Class;
import Reusable.Abstract_Class;
import Reusable.skip2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FedExAI extends Abstract_Class {
    @Test
    public void FedExAI() throws InterruptedException, IOException {
        driver.navigate().to("https://www.fedex.com/en-us/home.html");

        //   -HomePage-
        Base_Class.homePage().DesignPrintMethod();
        Base_Class.homePage().AllProductsMethod();

        //  -Start Order-
        Base_Class.startOrderPage().StartOrderMethod();

        //  -Document Printing-
        Base_Class.documentPrintingPage().DocumentPrintMethod();

        // Asset that you are on "FedEx Office Print Online" page
        String actualPageTitle = driver.getTitle();
        String expectedTitle = "FedEx Office Print Online";
        Assert.assertEquals(actualPageTitle,expectedTitle);

        //  -Copies & Custom Projects-
        Base_Class.copiesCustomPage().CopiesCustomMethod();


        //  -File Upload -
        Thread.sleep(2000);
        Base_Class.fileUploadPage().FileUploadMethod();
        Base_Class.fileUploadPage().ImgUpload("C:\\Users\\Darin\\Desktop\\api.png");

        // -PrintInfo-
        Thread.sleep(2000);
        Base_Class.printInfoPage().ContinueMethod();
        Base_Class.printInfoPage().quantityMethod("5");
        Base_Class.printInfoPage().AddToCartMethod();

        // -CheckOutPage-
        Thread.sleep(2000);
        Base_Class.checkOutPage().CheckoutMethod();
        Base_Class.checkOutPage().ProceedAsGuestMethod();

        // -PickupInfoPage-
        Thread.sleep(2000);
        Base_Class.pickupInfoPage().MilesMethod("10 Miles");
        Base_Class.pickupInfoPage().ZipCodeMethod("11356");
        Base_Class.pickupInfoPage().ContinueMethod();

        // -InfoPage-
        Thread.sleep(2000);
        Base_Class.infoPage().LocationMethod();
        Base_Class.infoPage().checkoutShowLocationMethod();
        Base_Class.infoPage().FirstNameMethod("John");
        Base_Class.infoPage().LastNameMethod("Doe");
        Base_Class.infoPage().PhoneMethod("3478693014");
        Base_Class.infoPage().EmailMethod("johndoe@gmail.com");
        Base_Class.infoPage().ContactInfoMethod();
        Base_Class.infoPage().CreditCardMethod("MASTERCARD®");
        Base_Class.infoPage().ccNumberMethod("5105484355920049");
        Base_Class.infoPage().csvNumberMethod("593");
        Base_Class.infoPage().MonthMethod("03");
        Base_Class.infoPage().YearMethod("2023");
        Base_Class.infoPage().NameOnCardMethod("John Doe");
        Base_Class.infoPage().ContactInformationMethod();
        Base_Class.infoPage().AddressMethod("11947 27th ave");
        Base_Class.infoPage().CityMethod("Flushing");
        Base_Class.infoPage().StateMethod("NY");
        Base_Class.infoPage().ZipMethod("11354");
        Thread.sleep(2000);
        Base_Class.infoPage().ShowReviewMethod();
        Base_Class.infoPage().TermsConditionsMethod();
        Base_Class.infoPage().SubmitOrderMethod();
        Base_Class.infoPage().ErrorMessageMethod();

    }

}
