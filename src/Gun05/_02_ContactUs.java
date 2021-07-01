package Gun05;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUs extends GenelWebDriver {

    @Test
    @Parameters("mesaj")//xml den alacagi parametre buraya yazildi
    void contactUs(String text) {
        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement textArea = driver.findElement(By.id("input-enquiry"));
        textArea.sendKeys(text);

        WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();

        WebElement contactUsText = driver.findElement(By.cssSelector("div[id='content']>h1"));
        Assert.assertEquals("Contact Us", contactUsText.getText());


    }


}
