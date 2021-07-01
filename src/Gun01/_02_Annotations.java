package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {
    /*
     @BeforeClass->//her class tan once calisacaklar
       @BeforeMethod-> //Hermetodddan once yapilacaklari buraya yaziyoruz
          @Test-->
          @Test-->
       @AfterMethod-> //Her metod calistiktan sonra yapilacaklar burayaz yziyoruz
     @AfterClass -> //Her classs tan sonra yapilacaklar buraya yaziliyor
     */
    @BeforeClass
    void BeforeClass() {
        System.out.println("ilk calisan yer :Before Class");
    }

    @AfterClass
    void AfterClass() {
        System.out.println("son calisan yer :After Class ");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Her metoddan once calisacak :Before method");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("Her metoddan sonra calisacak :After method");
    }


    @Test
    void test1() {
        System.out.println("test 1 calisti");
    }

    @Test
    void test2() {
        System.out.println("test 2 calisti");
    }

}
