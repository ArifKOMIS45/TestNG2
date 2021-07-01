package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_itarator {

    @Test(dataProvider = "getData")
    void UsernameTest(String username) {
        System.out.println("username = " + username);
    }

    @DataProvider
    public Iterator<Object> getData() {
        List<Object> data = new ArrayList<>();
        data.add("ayse");
        data.add("esra");
        data.add("mehmet");
        data.add("ersin");

        return data.iterator();
    }

    /*********************************/

    @Test(dataProvider = "getData2")
    void UsernameTest2(String username,String password) {
        System.out.println(username+" "+password);
    }

    @DataProvider
    public Iterator<Object[]> getData2() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"ayse", "123"});
        data.add(new Object[]{"esra", "abc"});
        data.add(new Object[]{"mehmet", "123abcc"});
        data.add(new Object[]{"ersin", "kjlls7756"});

        return data.iterator();
    }


}
