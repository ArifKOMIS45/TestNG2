package Gun01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _04_Enable {
    public static WebDriver driver;

    @BeforeClass
    void baslangicIslemleri() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:/selenyum/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

    }

    @AfterClass
    void bitisIslemleri() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }


    @Test(priority = 1)
    void test1() {
        System.out.println("Current Url= "+driver.getCurrentUrl());
    }

    @Test(priority = 3)
    void test2() {
        System.out.println("Page title= "+driver.getTitle());
    }

    @Test(enabled = false)
     void test3() {
        System.out.println("Page ID= "+driver.getWindowHandle());
    }
}
