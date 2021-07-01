package Gun06;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun sayisi ile indirimli urun sayisi ayni mi dogrulayiniz
*/

public class _06_Task_3 extends GenelWebDriver {

    @Test
      void specialsValidation1()
    {
        WebElement special = driver.findElement(By.linkText("Specials"));
        special.click();


        List<WebElement> oldPricelist1=driver.findElements(By.className("price-old"));//fiyatlar eski
        List<WebElement> productList=driver.findElements(By.className("product-thumb"));//urun isimleri
        Assert.assertEquals(oldPricelist1.size(),productList.size());


        //eski fiyat yeni fiyat karsilastirmasi
        List<WebElement> newPriceList=driver.findElements(By.className("price-new"));

        for (int i = 0; i <newPriceList.size() ; i++) {
            Assert.assertTrue(reverse(newPriceList.get(i))<reverse(oldPricelist1.get(i)));
        }


    }
    public double reverse(WebElement element){
        String result=element.getText();
        result=result.replaceAll("[^\\d]","");
        return Double.parseDouble(result);
    }

}

