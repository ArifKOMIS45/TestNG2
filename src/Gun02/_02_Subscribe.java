package Gun02;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
  3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız
 */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _02_Subscribe extends GenelWebDriver {
By link=By.linkText("Newsletter");
By yes=By.cssSelector("input[value='1']");
By cnt=By.cssSelector("input[value=Continue]");
By no=By.cssSelector("input[value='0']");

    @Test (priority = 1)
    void subscribeFunctionYes()
    {
        WebElement newsletter =  driver.findElement(link);
        newsletter.click();

        WebElement yesRadioButton=driver.findElement(yes);
        yesRadioButton.click();

        WebElement conBtn= driver.findElement(cnt);
        conBtn.click();

//        WebElement msj= driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
//        Assert.assertTrue( msj.getText().contains("successfully") );
        Tools.successMessageValidation(driver);
    }

    @Test (priority = 2)
    void subscribeFunctionNo()
    {
        WebElement newsletter =  driver.findElement(link);
        newsletter.click();

        WebElement noRadioButton=driver.findElement(no);
        noRadioButton.click();

        WebElement conBtn= driver.findElement(cnt);
        conBtn.click();

//        WebElement msj= driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
//        Assert.assertTrue( msj.getText().contains("successfully") );
        Tools.successMessageValidation(driver);//yukardaki torumdaki kod yerine kullanildi
    }

    @Test (priority = 2)
    void subscribeFunctionForBoth()
    {
        WebElement newsletter =  driver.findElement(link);
        newsletter.click();

        WebElement yesRadioButton=driver.findElement(yes);
        WebElement noRadioButton=driver.findElement(no);

        if (yesRadioButton.isSelected())
            noRadioButton.click();
        else
            yesRadioButton.click();

        WebElement conBtn= driver.findElement(cnt);
        conBtn.click();

        Tools.successMessageValidation(driver);
    }
}
