package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class GenelWebDriver {
    public static WebDriver driver;

    @BeforeClass
    public void baslangicIslemleri() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:/selenyum/Driver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        loginTest();
    }
    void loginTest() {
        driver.findElement(By.id("input-email")).sendKeys("arifkom@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("manisa45");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement advanced= driver.findElement(By.id("details-button"));
        advanced.click();
        WebElement unsafe= driver.findElement(By.id("proceed-link"));
        unsafe.click();
        bekle(2);
    }

    @AfterClass
   public void bitisIslemleri() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    public void bekle(int saniye)  {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
