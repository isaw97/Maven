package Google_PageObjects;

import Reusable.Abstract_Class;

public class Base_Class extends Abstract_Class {


    //this page class is a static reference for the page object classes
    //so I can use it on my test class
    public static Express_Home expressHomePage(){
        Express_Home expressHomePage = new Express_Home(driver);
        return  expressHomePage;
    }//end of googleHomePage method
    public static Express_Sweaters expressSweaters(){
        Express_Sweaters expressSweaters = new Express_Sweaters(driver);
        return  expressSweaters;
    }
    public static Express_First expressFirst(){
        Express_First expressFirst = new Express_First(driver);
        return  expressFirst;
    }
    public static Express_Quantity expressQuantity(){
        Express_Quantity expressQuantity = new Express_Quantity(driver);
        return  expressQuantity;
    }

    public static Express_Checkout expressCheck(){
        Express_Checkout expressCheck = new Express_Checkout(driver);
        return  expressCheck;
    }
    public static FedExHomePage homePage(){
        FedExHomePage homePage = new FedExHomePage(driver);
        return homePage;
    }
    //Home Page
    public static DocumentPrintPage documentPrintingPage(){
        DocumentPrintPage documentPrintingPage = new DocumentPrintPage(driver);
        return documentPrintingPage;
    }
    //Home Page
    public static OrderPage startOrderPage(){
        OrderPage startOrderPage = new OrderPage(driver);
        return startOrderPage;
    }
    //Home Page
    public static CopyPage copiesCustomPage(){
        CopyPage copiesCustomPage = new CopyPage(driver);
        return copiesCustomPage;
    }
    //Home Page
    public static FileUploadPage fileUploadPage(){
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        return fileUploadPage;
    }
    //Home Page
    public static PrintInfoPage printInfoPage(){
        PrintInfoPage printInfoPage = new PrintInfoPage(driver);
        return printInfoPage;
    }
    //Home Page
    public static CheckOutPage checkOutPage(){
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        return checkOutPage;
    }
    //Home Page
    public static PickupPage pickupInfoPage(){
        PickupPage pickupInfoPage = new PickupPage(driver);
        return pickupInfoPage;
    }
    //Home Page
    public static InfoPage infoPage(){
        InfoPage infoPage = new InfoPage(driver);
        return infoPage;
    }


}