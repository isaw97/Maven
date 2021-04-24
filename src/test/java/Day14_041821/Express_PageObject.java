package Day14_041821;

import Google_PageObjects.Base_Class;
import Reusable.Abstract_Class;
import org.jsoup.Connection;
import org.testng.annotations.Test;

public class Express_PageObject extends Abstract_Class {


    @Test
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("http://www.express.com");
        Thread.sleep(500);
        Base_Class.expressHomePage().closeAd();
        Base_Class.expressHomePage().Men();
        Base_Class.expressHomePage().Sweaters();
        Thread.sleep(500);

        Base_Class.expressSweaters().firstSweater();
        Thread.sleep(500);

        Base_Class.expressFirst().Size();
        Base_Class.expressFirst().addToBag();
        Base_Class.expressFirst().viewBag();
        Thread.sleep(500);

        Base_Class.expressQuantity().quantity();
        Base_Class.expressQuantity().checkout();
        Base_Class.expressQuantity().guest();
        Thread.sleep(500);

        Base_Class.expressCheck().firstName("John");
        Base_Class.expressCheck().lastName("Smith");
        Base_Class.expressCheck().email("johnsmith@gmail.com");
        Base_Class.expressCheck().emailConfirm("johnsmith@gmail.com");
        Base_Class.expressCheck().phone("9174538159");
        Base_Class.expressCheck().Continue();
        Thread.sleep(500);
        Base_Class.expressCheck().firstName("John");
        Base_Class.expressCheck().lastName("Smith");
        Base_Class.expressCheck().address("11947 27th ave");
        Base_Class.expressCheck().zip("11354");
        Base_Class.expressCheck().city("Flushing");
        Base_Class.expressCheck().state();
        Thread.sleep(500);
        Base_Class.expressCheck().Continue();
        Base_Class.expressCheck().Continue();
        Base_Class.expressCheck().card("4935005938293880");
        Base_Class.expressCheck().expMonth();
        Base_Class.expressCheck().expYear();
        Base_Class.expressCheck().cvv("405");
        Thread.sleep(500);
        Base_Class.expressCheck().error();

    }

}
