package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Tools {

    public static void compareToList(List<String> menuExpectedList, List<WebElement> menuActualList)
    {
        //1. Yöntem
        for (int i = 0; i <menuActualList.size() ; i++) {
            Assert.assertEquals(menuExpectedList.get(i),menuActualList.get(i).getText());
        }

//        //2.Yöntem
//        int i=0;
//        for (WebElement listItem: menuActualList) {
//            Assert.assertEquals(menuExpectedList.get(i++),listItem.getText());
//        }
    }

    public static void successMessageValidation(WebDriver driver)
    {
        WebElement msj= driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
        Assert.assertTrue( msj.getText().contains("successfully") );
    }


    public static void selectByRandomIndex(WebElement element){
        Select select = new Select(element);


        select.selectByIndex(RandomNumberGenerator(select.getOptions().size()));
    }
    public static int RandomNumberGenerator(int max){

        return (int)(Math.random()*max)+1;
    }


    public static void listContainsString(List<WebElement> list, String aranaKelime)
    {
        boolean bulundu=false;
        for(WebElement e: list)
        {
            if (e.getText().equalsIgnoreCase(aranaKelime))
            {
                bulundu=true;
                break;
            }
        }

        if (!bulundu)
            Assert.fail();
    }

}
