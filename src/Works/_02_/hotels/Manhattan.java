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

public class Manhattan extends WorkBaseDriver {

    @Test
    void booking() {
        StartWebSite("https://www.hotels.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchBox = driver.findElement(By.className("_1yFrqc"));
        searchBox.click();
        WebElement search = driver.findElement(By.name("q-destination-srs7"));
        search.clear();
        search.sendKeys("manhattan");


        WebElement option = driver.findElement(By.cssSelector("div._3oGbmD>ul>li"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();


        LocalDateTime day = LocalDateTime.now();
        int day1 = day.getDayOfMonth();


        WebElement calendar1 = driver.findElement(By.cssSelector(".bLAr9b > div:nth-of-type(1) > ._1yFrqc>div>span"));
        wait.until(ExpectedConditions.elementToBeClickable(calendar1));
        calendar1.click();

        WebElement startDay = driver.findElement(By.xpath("//*[contains(@name,'" +
                day.getMonth().name().charAt(0) + day.getMonth().name().substring(1, 3).toLowerCase() + " " + (day1 + 2) + "')]"));
        startDay.click();

        WebElement startDay2 = driver.findElement(By.xpath("//*[contains(@name,'" +
                day.getMonth().name().charAt(0) + day.getMonth().name().substring(1, 3).toLowerCase() + " " + (day1 + 5) + "')]"));
        startDay2.click();

        WebElement calUygula = driver.findElement(By.cssSelector("button[class='_3pFoIe']"));
        calUygula.click();
        //WebElement bosClick=driver.findElement(By.xpath("//h1[text()='Nereye?']"));bosClick.click();

        WebElement misafirSayisi = driver.findElement(By.xpath("//span[text()='Misafir Sayısı']"));
        wait.until(ExpectedConditions.elementToBeClickable(misafirSayisi));
        misafirSayisi.click();

        WebElement uygula = driver.findElement(By.cssSelector("button[class='_3pFoIe']"));
        uygula.click();

        WebElement araButton = driver.findElement(By.cssSelector("div[class='_1RDbO5']"));
        araButton.click();

        WebElement uzaklik = driver.findElement(By.cssSelector("button[value='DISTANCE_FROM_LANDMARK']"));
        uzaklik.click();

        WebElement uzaklik5km = driver.findElement(By.cssSelector("button[value='DISTANCE_FROM_LANDMARK:1693296']"));
        wait.until(ExpectedConditions.elementToBeClickable(uzaklik5km));
        uzaklik5km.click();


        for (int i = 0; i < 20; i++) {
            bekle(1);
            List<WebElement> oteller = driver.findElements(By.cssSelector("ul[class='_3f26d2']>li"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", oteller.get(oteller.size() - 1));
            wait.until(ExpectedConditions.visibilityOf(oteller.get(oteller.size() - 1)));
            System.out.println(i + "=Otel sayisi= " + oteller.size());
            if (oteller.size() > 60) break;
        }


        List<WebElement> cadde5 = driver.findElements(By.xpath("(//ul[@class='_2sHYiJ _3JLCGC']/li)[1]"));

        for (WebElement mesafe : cadde5) {
            Assert.assertTrue(mesafe.getText().contains("5. Cadde"));
        }
        List<WebElement> cadde5Mesafe = driver.findElements(By.xpath("(//ul[@class='_2sHYiJ _3JLCGC']/li)[2]"));

        for (WebElement uzaklikDogrulama : cadde5Mesafe) {
            String str = uzaklikDogrulama.getText().replaceAll("[^\\d,]", "");
            String str2 = str.replace(",", ".");
            double mesafe = Double.parseDouble(str2);
            Assert.assertTrue(mesafe < 8);

        }


    }


}
