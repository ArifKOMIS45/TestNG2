package Gun07;

import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/* POM (Page Object Model) avantajları
   1- Bütün sayfalada isimleri aynı olan elemanlar için 1 tanımlama yeterli oluyor.
      Böylece tanımlanan elemanlar tekrar kullanılabilir yani Reusable oluyor.
   2- Kodun içerisinden HTML kodları ayrıldığından kod okunabilirliği artıyor.
   3- Developer locatorlarda bir değişiklik yaptığı zaman, asıl kodla hiç bir şekilde
      uğraşmak zorunda kalmıyoruz, sadece gidip locator ı değiştiriyoruz.
    */

public class _04_PlaceOrderPOM extends ParameterDriver {

    @Test
    @Parameters("browser")
    void ProceedToCheckout() {
        _03_PlaceOrderElements elements = new _03_PlaceOrderElements(driver);

        elements.searchBox.sendKeys("ipod");
        elements.searchClick.click();
        elements.ipod.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

       elements.shoppingChart.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.checkOut)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();


        wait.until(ExpectedConditions.elementToBeClickable( elements.agree)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals("Your order has been placed!", driver.findElement(By.xpath("//*[@id='content']/h1")).getText());


    }


}
