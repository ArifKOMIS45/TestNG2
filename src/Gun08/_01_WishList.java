package Gun08;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız.
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

   2.Test;
   1- WishList i boşaltınız.
 */
public class _01_WishList extends GenelWebDriver {
    @Test
        //  @Parameters("itemName")
    void search() {//String arananKelime
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search']"));
        searchBox.sendKeys("ipod");

        WebElement searchClick = driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']"));
        searchClick.click();


        List<WebElement> searchresults= driver.findElements(By.cssSelector("div.caption>h4>a"));
        int random = Tools.RandomNumberGenerator(searchresults.size());
        String wishitemName=searchresults.get(random).getText();


        List<WebElement> wishbtnList = driver.findElements(By.cssSelector("button[data-original-title='Add to Wish List']"));
       wishbtnList.get(random).click();


        WebElement wishList = driver.findElement(By.id("wishlist-total"));
        wishList.click();

        List<WebElement> tableNames = driver.findElements(By.cssSelector("table[class='table table-bordered table-hover']>tbody>tr>td:nth-child(2)"));

        Tools.listContainsString(tableNames,wishitemName);

    }
}