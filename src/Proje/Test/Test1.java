package Proje.Test;

import Proje.Main.Test1Steps;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 extends Test1Steps {
    @Test
    @Parameters("browser")

    void test1() {
        Test1Steps test1 = new Test1Steps();
        Scroll();
       test1.contactUs.click();
       test1.getEnquiry().sendKeys("Nasil gidiyor");
       test1.getSubmit().click();
        Assert.assertTrue(test1.getMessageAlert().getText().contains("successfully"));

    }
}
