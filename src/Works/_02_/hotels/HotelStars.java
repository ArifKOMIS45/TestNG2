package Works._02_.hotels;

import Works.WorkBaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class HotelStars extends WorkBaseDriver {
    @Test
    void hotelsWithStars() {

        StartWebSite("https://www.hotels.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchBox = driver.findElement(By.className("_1yFrqc"));
        searchBox.click();
        WebElement search = driver.findElement(By.name("q-destination-srs7"));
        search.clear();
        search.sendKeys("Atlanta");


        WebElement option = driver.findElement(By.cssSelector("div._3oGbmD>ul>li"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();


        LocalDateTime day = LocalDateTime.now();
        int day1 = day.getDayOfMonth();


        WebElement calendar1 = driver.findElement(By.xpath("(//button[@class='_1yFrqc'])[2]"));
//        wait.until(ExpectedConditions.elementToBeClickable(calendar1));
        calendar1.click();

        WebElement startDay = driver.findElement(By.xpath("//*[contains(@name,'" +
                day.getMonth().name().charAt(0) + day.getMonth().name().substring(1, 3).toLowerCase() + " " + (day1 + 2) + "')]"));
        startDay.click();

        WebElement startDay2 = driver.findElement(By.xpath("//*[contains(@name,'" +
                day.getMonth().name().charAt(0) + day.getMonth().name().substring(1, 3).toLowerCase() + " " + (day1 + 5) + "')]"));
        startDay2.click();

        WebElement calUygula = driver.findElement(By.cssSelector("button[class='_3pFoIe']"));
        calUygula.click();

        WebElement misafirSayisi = driver.findElement(By.xpath("//span[text()='Misafir Sayısı']"));
        wait.until(ExpectedConditions.elementToBeClickable(misafirSayisi));
        misafirSayisi.click();

        WebElement uygula = driver.findElement(By.cssSelector("button[class='_3pFoIe']"));
        uygula.click();

        WebElement araButton = driver.findElement(By.cssSelector("div[class='_1RDbO5']"));
        araButton.click();

        driver.findElement(By.cssSelector("[for='f-star-rating-4']")).click();
        driver.findElement(By.cssSelector("[for='f-star-rating-5']")).click();


        for (int i = 0; i < 20; i++) {
            bekle(1);
            List<WebElement> oteller = driver.findElements(By.cssSelector("ul[class='_3f26d2']>li"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", oteller.get(oteller.size() - 1));
            wait.until(ExpectedConditions.visibilityOf(oteller.get(oteller.size() - 1)));
            System.out.println(i + "=Otel sayisi= " + oteller.size());
            if (oteller.size() > 50) break; }


        List<WebElement> hotels = driver.findElements(By.cssSelector("div[class='_3R8C5Q']>span[class='_2dOcxA _1rJjyi']"));

        for (WebElement hotel : hotels) {
            Assert.assertTrue(Double.parseDouble(hotel.getText().replaceAll("[^\\d]", ""))>3,"Oteller istenilen yildizda");

        }

    }

}
