package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {


    //Eger test sirasi verilmezse alfabetik siraya gore calisir
    @Test (priority = 1)//--->annotation ...oncelik sirasi verildi
    void webSitesiniAc()
    {
        System.out.println("Driver tanimlandi ve web sitesi acildi");
    }

    @Test(priority = 2)
    void loginTest()
    {
        System.out.println("Login test islemleri yapildi.");
    }

    @Test(priority = 3)
    void  driveriKapat()
    {
        System.out.println("driver kapatildi ve cikildi.");
    }


}
