package Works._02_.hotels;

import Works.WorkBaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AirPort extends WorkBaseDriver {

    @Test
    void airPortBooking() {
        StartWebSite("https://www.enterprise.com/en/home.html");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cancel = driver.findElement(By.cssSelector(".modal-cancel"));
        cancel.click();
        WebElement miamiSearch = driver.findElement(By.cssSelector("#pickupLocationTextBox"));
        miamiSearch.sendKeys("Miami International Airport");

        WebElement MiaminternationalAirport = driver.findElement(By.cssSelector("#locations-list > div:nth-of-type(2)"));
        MiaminternationalAirport.click();

        WebElement arriveDateTable= driver.findElement(By.id("pickupCalendarFocusable"));
       wait.until(ExpectedConditions.elementToBeClickable(arriveDateTable));
        arriveDateTable.click();

        String pattern = "MM/dd/yyyy";
        LocalDate today = LocalDate.now().plusDays(5);
        String formattedDate = today.format(DateTimeFormatter.ofPattern(pattern));

        driver.findElement(By.cssSelector("button[data-test-id='"+formattedDate+"']")).click();

        WebElement leaveDateTable= driver.findElement(By.id("dropoffCalendarFocusable"));leaveDateTable.click();
        LocalDate today2 = LocalDate.now().plusDays(10);
        formattedDate = today2.format(DateTimeFormatter.ofPattern(pattern));
        driver.findElement(By.cssSelector("button[data-test-id='"+formattedDate+"']")).click();

WebElement vehicles=driver.findElement(By.cssSelector("[name='vehicle-filters-trigger']"));
vehicles.click();

WebElement fullSize=driver.findElement(By.xpath("//span[.='Full Size Car']"));
fullSize.click();

WebElement applyBtn=driver.findElement(By.xpath("//button[@class='btn modal-button']"));
applyBtn.click();

WebElement checkAvaile=driver.findElement(By.id("continueButton"));
checkAvaile.click();
WebElement sevenPeople=driver.findElement(By.cssSelector("[data-dtm-tracking='car_filters|7|unchecked'] > .form-checkbox__control"));
sevenPeople.click();

WebElement allCar=driver.findElement(By.cssSelector(".unavailable-vehicles__button"));allCar.click();

List<WebElement> cars=driver.findElements(By.cssSelector("div[class='vehicle-item__main-content']>section>ul>li:nth-child(2)"));

        for (WebElement car :cars ) {
            System.out.println(car.getText());
            Assert.assertTrue( Integer.parseInt(car.getText().replaceAll("[^\\d]",""))>=7);
        }


    }


}
