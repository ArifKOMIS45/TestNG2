package Gun01;
/*
   Senaryo ;
     1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
     2- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
     3- Login olup olmadığınızı assert ile kontrol ediniz.
     4- bir utils paketi açınız ve buraya beforeClass ve afterClass metdolarını yazarak
        genel kullanım için GenelWebDriver isimli test klasını tanımlayınız.
 */
import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class _05_Ornek extends GenelWebDriver {


    @Test
    void loginTest() {
        driver.findElement(By.id("input-email")).sendKeys("asd@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123qweasd");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement advanced= driver.findElement(By.id("details-button"));
        advanced.click();
        WebElement unsafe= driver.findElement(By.id("proceed-link"));
        unsafe.click();



    }


}
