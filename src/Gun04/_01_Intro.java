package Gun04;

import org.testng.annotations.*;

public class _01_Intro {
   /*
          @BeforeSuite
            @BeforeTest
              @BeforeGroups
                 @BeforeClass
                    @BeforeMethod
                        @Test
                        @Test
                    @AfterMethod
                 @AfterClass
              @AfterGroups
            @AfterTest
          @AfterSuite
    */

    @BeforeSuite
    void bSuite() {
        System.out.println("Before suit");
    }

    @BeforeTest
    void bTest() {
        System.out.println("Before test");
    }

    @BeforeGroups
    void bGroup() {
        System.out.println("Before group");
    }

    @BeforeClass
    void bClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    void bmethod() {
        System.out.println("Before method");
    }

    @Test
    void test1() {
        System.out.println("Intro 1---> test 1");
    }


    @Test
    void test2() {
        System.out.println("Intro 1---> test 2");
    }

    @AfterMethod
    void amethod() {
        System.out.println("After method");
    }


    @AfterClass
    void aClass() {
        System.out.println("After class");
    }


    @AfterGroups
    void aGroup() {
        System.out.println("After group");
    }


    @AfterTest
    void aTest() {
        System.out.println("After test");
    }

    @AfterSuite
    void aSuite() {
        System.out.println("After suit");
    }


}
