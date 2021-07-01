package Works._02_.hotels;

import Works.WorkBaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Currency extends WorkBaseDriver {

    @Test
    void currencyChange() {
        StartWebSite("https://www.hotels.com");
        WebElement currency = driver.findElement(By.xpath("(//button[@class='_3gE-EQ _2lnvSN'])[2]"));
        currency.click();

        List<WebElement> paralar = driver.findElements(By.cssSelector("ul[class='_1QGgUR']>li"));
        int a = paralar.size();
        WebElement secilen = paralar.get(RandomNumberGenerator(a));
        secilen.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);



        WebElement secilenkontrol = driver.findElement(By.xpath("//header/div[1]/nav[1]/div[1]/ul[1]/li[2]/button[1]/span[2]"));
        wait.until(ExpectedConditions.stalenessOf(secilenkontrol));
        bekle(6);
        Assert.assertEquals(secilen.getText(), secilenkontrol.getText());
    }
}
