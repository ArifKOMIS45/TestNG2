package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertion {
    //JUnit-->bu daha onca proje testlerimizde kullandigimiz java nin kendi kutuphane testi
    //         paralele ve grup calismalarinda yetersiz.

    //testNG-->bu yeni nesil test->Test New Generation->Yani testlerimizi kontrol edip
    //         istedigimiz gibi calistirabilecegimiz Selenium Kullanma Tool u

    @Test
    void equalsOrnek() {
        String s1 = "Merhaba";
        String s2 = "iyi aksamlar";

        Assert.assertNotEquals(s1, s2, "Yapilan islemin sonucu");
    }

    @Test
    void trueOrnek() {
        int s1 = 55;
        int s2 = 55;
        Assert.assertTrue(s1 == s2);// iki veriyi karsilastiriyor
        //Actual: olusan
        //expected: beklenen
    }

    @Test
    void nullOrnek() {
       String s1 = null;

        Assert.assertNull(s1);
    }

}
