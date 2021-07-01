package Gun07;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {


    @Test
    void HardAssert(){
        String s1="merhaba";
        System.out.println(" Assertten once");
        Assert.assertEquals(s1,"Merhaba 123");
        System.out.println(" Assertten sonra");
    }

    @Test
    void SoftAssert(){
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals("www.facebook.com/homepage",strHomePage);
        System.out.println("assert 1");

        softAssert.assertEquals("www.facebook.com/profile",strCartPage);//fail
        System.out.println("assert 2");

        softAssert.assertEquals("www.facebook.com/settings",strEditAccount);//tekrar fail
        System.out.println("assert 3");

        softAssert.assertAll();//butun assertleri islmee koyuyor ve kiriyor
        System.out.println("aktiflik sonrasi");//bu gorunmuyor

    }









}
