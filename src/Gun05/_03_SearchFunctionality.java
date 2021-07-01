package Gun05;
/*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimeini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi mac için de yapınız
     */

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _03_SearchFunctionality extends GenelWebDriver {

    @Test
    @Parameters("arananKelime")
    void search(String txtSearch) {
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search']"));
        searchBox.sendKeys(txtSearch);

        WebElement searchClick = driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']"));
        searchClick.click();

        List<WebElement> productList = driver.findElements(By.cssSelector("h4>a"));

        for (WebElement macs : productList) {
            Assert.assertTrue(macs.getText().toLowerCase().contains(txtSearch.toLowerCase()));
        }


    }

}




