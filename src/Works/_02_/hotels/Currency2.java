package Works._02_.hotels;

import Utils.Tools;
import Works.WorkBaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Currency2 extends WorkBaseDriver {

    @Test
    void currencyChange() {
        StartWebSite("https://www.hotels.com");
        WebElement currency = driver.findElement(By.xpath("(//button[@class='_3gE-EQ _2lnvSN'])[2]"));
        currency.click();

            String moneyfirst=currency.getText();
            System.out.println("moneyfirst = " + moneyfirst);

            List<WebElement>moneylist=driver.findElements(By.cssSelector("ul[class='_1QGgUR']>li"));
            List<WebElement>moneylistgettext=driver.findElements(By.cssSelector("ul[class='_1QGgUR']>li>a>span"));
            int random= Tools.RandomNumberGenerator(moneylist.size());
            String moneysecond=moneylistgettext.get(random-1).getText();


            System.out.println("moneysecond = " + moneysecond);
            moneylist.get(random-1).click();

            driver.navigate().refresh();

            Assert.assertFalse(moneyfirst.equalsIgnoreCase(moneysecond));


            WebElement moneycheck2 = driver.findElement(By.xpath("(//button[@class='_3gE-EQ _2lnvSN'])[2]"));
            String sonMoney=moneycheck2.getText().substring(0,3);
            System.out.println("sonMoney = " + sonMoney);


            Assert.assertEquals(sonMoney,moneysecond);

        }
    }


