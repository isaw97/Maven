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


}