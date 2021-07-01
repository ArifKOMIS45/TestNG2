package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_cokBoyutlu {

    @Test(dataProvider = "getData")
    void UsernameTest(String username,int password) {

        System.out.println(username+" "+password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = {{"ayse","123"},{ "esra","abc"},{ "mehmet","34555a"}};
        return data;
    }






}
