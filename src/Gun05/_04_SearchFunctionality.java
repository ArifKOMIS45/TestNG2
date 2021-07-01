package Gun05;
 /*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimeini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */

import Utils.GenelWebDriver;
import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _04_SearchFunctionality extends ParameterDriver {

    @Test
    @Parameters("arananKelime")
    void SearchFunction(String txtSearch)
    {
        WebElement searchArea = driver.findElement(By.name("search"));
        searchArea.sendKeys(txtSearch);

        WebElement searchBtn = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchBtn.click();

        List<WebElement> productList=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement macs:productList)
        {
            Assert.assertTrue(macs.getText().toLowerCase().contains(txtSearch.toLowerCase()));
        }
    }

}
