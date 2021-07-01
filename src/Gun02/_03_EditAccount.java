package Gun02;

 /*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _03_EditAccount extends GenelWebDriver {

    @Test
    void EditAccount()
    {
        editAccount("ismet","temur");
       bekle(2);
        editAccount("ali","veli");
    }

    void editAccount(String ad, String soyad)
    {
        WebElement edit=driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement firstName=driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(ad);

        WebElement lastName= driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys(soyad);

        WebElement conBtn= driver.findElement(By.cssSelector("input[value=Continue]"));
        conBtn.click();

        Tools.successMessageValidation(driver);
    }
}
