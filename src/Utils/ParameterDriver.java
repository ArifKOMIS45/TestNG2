package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class ParameterDriver {
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void BaslangicIslemleri(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "C:/selenyum/Driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            System.setProperty("webdriver.gecko.driver", "C:/selenyum/Driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        LoginTest(browser);
    }

    @AfterClass
    public void BitisIslemleri() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }


    void LoginTest(String browser) {
        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("arifkom@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("manisa45");

        WebElement login = driver.findElement(By.cssSelector("input[value='Login']"));
        login.click();

        if (browser.equalsIgnoreCase("chrome")) {
            WebElement gelismis = driver.findElement(By.id("details-button"));
            gelismis.click();

            WebElement link = driver.findElement(By.id("proceed-link"));
            link.click();
        }
    }
}
