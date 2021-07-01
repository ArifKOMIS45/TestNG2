package Gun08;

import Gun07._03_PlaceOrderElements;
import Utils.ParameterDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_WishListPOM extends ParameterDriver {

    @Test
    @Parameters("itemName")
    void addToWishList(String arananKelime) {
       _03_PlaceOrderElements elements = new _03_PlaceOrderElements(driver);
        elements.searchBox.sendKeys(arananKelime);
        elements.searchClick.click();




    }


}
