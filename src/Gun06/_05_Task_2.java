package Gun06;

import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
 * sonrasında fakrlı tarayıcılar ile çalıştırınız.
 * sonrasında paralel çalıştırınız.
 */

public class _05_Task_2 extends ParameterDriver {

    @Test(dataProvider = "getData")
      void SearchFunction(String txtSearch)
    {
        WebElement searchArea = driver.findElement(By.name("search"));
        searchArea.clear();
        searchArea.sendKeys(txtSearch);

        WebElement searchBtn = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchBtn.click();

        List<WebElement> productList=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement p:productList)
        {
            Assert.assertTrue(p.getText().toLowerCase().contains(txtSearch.toLowerCase()));
        }
    }
    @DataProvider
    public Object[] getData() {

        Object[] data = {"Mac","ipod","samsung"};
        return data;
    }

}

