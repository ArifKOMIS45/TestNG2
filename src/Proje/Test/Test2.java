package Proje.Test;

import Proje.Main.Test2Steps;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 extends Test2Steps {

    @Test
    @Parameters("browser")
    void test2() {
        Test2Steps test2 = new Test2Steps();
        test2.getAppealsAndShoes().click();
        test2.getBlueANdGreenSneakers().click();
        test2.getAddToWishList().click();
        test2.getAppealsAndShoes().click();
        test2.getPolka().click();
        test2.getAddToWishList().click();
        test2.getWishListBtn().click();
        Assert.assertEquals(test2.wishListItems.size(), 2);
    }

}
