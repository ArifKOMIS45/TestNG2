package Works.Mentor;
/*
    www.amazon.com websitesine gidin.
    Today's deal'a tıkla.
    200 Dolar or Above a tıkla

    3. sıradaki ürüne tıkla
    20 Pint-2019 DOE (Previous 30 Pint) butonuna tıkla
    sağ üstte 169 dolar yazdığını test et.
    See similar Items buttonuna tıkla

    4. sıradakine tıkla.
    Sağ üstte $249.99 yazdığını test et
    Soldaki All butonuna tıklatıp katagorileri aç
    Electronics katagorisine tıkla
    Headphones'a tıkla.
  1. ürüne tıkla

    sağ üstteki fiyatın $23.99 olduğunu test et.

     */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_Mentoring {
    public static WebDriver driver;

    @Test
    void test1() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:/selenyum/Driver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        WebElement todaysDeal = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
        todaysDeal.click();
        WebElement Above = driver.findElement(By.xpath("//a[text()='$200 & Above']"));
        Above.click();
        driver.findElement(By.xpath("(//a[@id='dealTitle'])[3]")).click();
        driver.findElement(By.xpath("//p[text()='20 Pint -2019 DOE (Previous 30 Pint )']")).click();

        Assert.assertEquals("$169.00", driver.findElement(By.xpath("//span[text()='$169.00']")).getText());

    }
}
