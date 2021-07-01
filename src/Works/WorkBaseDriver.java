package Works;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class WorkBaseDriver {
    public static WebDriver driver;


    public static void StartWebSite(String Address) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:/selenyum/Driver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(Address);

    }
    public static int RandomNumberGenerator(int max){

        return (int)(Math.random()*max)+1;}

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @AfterClass
    public void bitisIslemleri() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}