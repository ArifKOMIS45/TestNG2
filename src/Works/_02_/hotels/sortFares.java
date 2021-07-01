package Works._02_.hotels;

import Works.WorkBaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class sortFares extends WorkBaseDriver {
    @Test
    void sortOfFaresOfHotels() {

        StartWebSite("https://www.hotels.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchBox = driver.findElement(By.className("_1yFrqc"));
        searchBox.click();
        WebElement search = driver.findElement(By.name("q-destination-srs7"));
        search.clear();
        search.sendKeys("Pittsburgh");


        WebElement option = driver.findElement(By.cssSelector("div._3oGbmD>ul>li"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();


        LocalDateTime day = LocalDateTime.now();
        int day1 = day.getDayOfMonth();


        WebElement calendar1 = driver.findElement(By.xpath("(//button[@class='_1yFrqc'])[2]"));
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

        Actions aksiyonlar = new Actions(driver);
        WebElement fiyat = driver.findElement(By.cssSelector("._1GKI32[aria-label='Fiyat']"));
        Action aksiyon = aksiyonlar.moveToElement(fiyat).click(fiyat).build();
        aksiyon.perform();
        WebElement dusukYuksek = driver.findElement(By.cssSelector("[value='PRICE']"));
        wait.until(ExpectedConditions.elementToBeClickable(dusukYuksek));
        Action aksiyon2 = aksiyonlar.moveToElement(dusukYuksek).click(dusukYuksek).build();
        aksiyon2.perform();
        Action aksiyon3 = aksiyonlar.moveToElement(fiyat).release(fiyat).build();
        aksiyon3.perform();

        for (int i = 0; i < 20; i++) {
            bekle(1);
            List<WebElement> oteller = driver.findElements(By.cssSelector("ul[class='_3f26d2']>li"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", oteller.get(oteller.size() - 1));
            wait.until(ExpectedConditions.visibilityOf(oteller.get(oteller.size() - 1)));
            System.out.println(i + "=Otel sayisi= " + oteller.size());
            if (oteller.size() > 30) break;
        }

        List<WebElement> fiyatlar=driver.findElements(By.cssSelector("span[class='_2R4dw5']"));

        for (int i = 0; i < fiyatlar.size() ; i++) {
            System.out.println("fiyatlar  = " + fiyatlar.get(i).getText().replaceAll("[^\\d]",""));
            if (i== fiyatlar.size()-1 ){break;}
            Assert.assertTrue(Double.parseDouble(fiyatlar.get(i).getText().replaceAll("[^\\d]",""))<=
                    Double.parseDouble(fiyatlar.get(i+1).getText().replaceAll("[^\\d]","")));

        }

    }

}
