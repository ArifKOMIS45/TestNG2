package Proje.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    public static WebDriver driver;
    //WebDriverWait wait=new WebDriverWait(driver,10);



    @BeforeClass
    @Parameters({"browser","email","Password"})
    public void BaslangicIslemleri(String browser,String email,String password) {
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
        driver.get("http://demowebshop.tricentis.com/");
        LoginTest(browser,email,password);
    }
    public static WebDriver getDriver() {
        return driver;
    }
    @AfterClass
    public void BitisIslemleri() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    @Parameters({"email","Password"})
    void LoginTest(String browser,String email,String Password) {
        WebElement logIn = driver.findElement(By.cssSelector(".ico-login"));
        logIn.click();
        WebElement inputEmail = driver.findElement(By.id("Email"));
        inputEmail.sendKeys(email);

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(Password);

        WebElement login = driver.findElement(By.cssSelector(".login-button"));
        login.click();


    }

    public void Scroll() {

        JavascriptExecutor jse = (JavascriptExecutor) driver; // (driver is your browser webdriver object)
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");

    }


}
