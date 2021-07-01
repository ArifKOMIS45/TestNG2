package Gun03;
/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
     */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AdressFunctionality extends GenelWebDriver {
    By firstname = By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By adress = By.id("input-address-1");

    @Test
    void addAdress() {
        WebElement adressBook = driver.findElement(By.xpath("//li/a[text()='Address Book']"));
        adressBook.click();
        WebElement newAdress = driver.findElement(By.xpath("//div/a[text()='New Address']"));

        newAdress.click();

        WebElement firstName = driver.findElement(firstname);
        firstName.sendKeys("Arif");

        WebElement lastName = driver.findElement(lastname);
        lastName.sendKeys("Komis");

        WebElement company = driver.findElement(By.id("input-company"));
        company.sendKeys("Time");


        WebElement adress1 = driver.findElement(adress);
        adress1.sendKeys("Bahcelievler 13 sokak no:3");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Istanbul");

        WebElement postcode = driver.findElement(By.id("input-postcode"));
        postcode.sendKeys("45700");


        WebElement country = driver.findElement(By.id("input-country"));
        Tools.selectByRandomIndex(country);


        //regionlar yuklendimi?....dolana kadar bekle
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement
                (By.cssSelector("select[id='input-zone']>option"))));//bayat eleman kaybolana kadar bekle

        //regionlar yuklendikten sonra sec
        WebElement zone = driver.findElement(By.id("input-zone"));
        Tools.selectByRandomIndex(zone);


        WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();
        Tools.successMessageValidation(driver);

    }

    @Test(dependsOnMethods = {"addAdress"})
    void editAdress() {
        WebElement adressBook = driver.findElement(By.xpath("//li/a[text()='Address Book']"));
        adressBook.click();

        List<WebElement> editAll = driver.findElements(By.xpath("//a[text()='Edit']"));
        WebElement edit = editAll.get(editAll.size() - 1);
        edit.click();

        WebElement editfirstname = driver.findElement(firstname);
        editfirstname.clear();
        editfirstname.sendKeys("Ali Emin");
        WebElement editlastname = driver.findElement(lastname);
        editlastname.clear();
        editlastname.sendKeys("Kayapali");
        WebElement editadress = driver.findElement(adress);
        editadress.clear();
        editadress.sendKeys("Kayadibi 34 sokak emrah mahalllesi");

        WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();
    }

    @Test(dependsOnMethods = {"editAdress"})
    void deleteAdress() {
        WebElement adressBook = driver.findElement(By.xpath("//li/a[text()='Address Book']"));
        adressBook.click();

        List<WebElement> deleteAll = driver.findElements(By.xpath("//a[text()='Delete']"));
        WebElement delete = deleteAll.get(deleteAll.size() - 1);
        delete.click();

       Tools.successMessageValidation(driver);

    }


}
