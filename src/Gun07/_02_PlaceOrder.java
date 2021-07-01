package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
    Senaryo :
    1- Siteyi açınız.
    2- Sitede "ipod" kelimesini aratınız
    3- Çıkan sonuçlardan ilkini sepete atınız.
    4- Shopping Chart a tıklatınız.
    5- Checkout yapınız.
    6- Continue butonalarına tıklatıp bilgileri giriniz.
    7- En confirm ile siparişi verdiğinizi doğrulayınız.
       doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
 */
public class _02_PlaceOrder extends GenelWebDriver {

    @Test
    void search() {
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search']"));
        searchBox.sendKeys("ipod");

        WebElement searchClick = driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']"));
        searchClick.click();

        WebElement ipod = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        ipod.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();

        driver.findElement(By.xpath("//a[text()='Checkout']")).click();


        WebElement continue1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        continue1.click();


        WebElement continue2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        continue2.click();

        WebElement continue3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        continue3.click();

        driver.findElement(By.cssSelector("input[type='checkbox']")).click();

        WebElement continue4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        continue4.click();


        driver.findElement(By.id("button-confirm")).click();

        wait.until(ExpectedConditions.urlContains("success"));


        Assert.assertEquals("Your order has been placed!", driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText());


    }


}
