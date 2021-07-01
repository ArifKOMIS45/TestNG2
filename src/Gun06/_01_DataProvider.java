package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

/**
 * Aşağıdaki ikli ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
 * data sayısı kadar test çalıştırılı, dataların olduğu yere DataProvider annottion ı konur.
 * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
 */

    @Test(dataProvider = "getData")
    void UsernameTest(String username) {
        System.out.println("username = " + username);
    }

    @DataProvider//bu metada dataprovider gorevi verildi
    public Object[] getData() {
        //int[] dizi={1,2,3,4,5}
        Object[] data = {"ayse", "esra", "mehmet", "ersin", "hilal"};
        return data;
    }
    //****************************************************/
    @Test(dataProvider = "userlar")
    void UsernameTest2(String username) {
        System.out.println("username = " + username);
    }
    @DataProvider(name = "userlar")
    public Object[] getData2() {//dataprovider olarak kullanilacak metodun tipi Object olmak zorundadir.
        //int[] dizi={1,2,3,4,5}
        Object[] data = {"ayse2", "esra2", "mehmet2", "ersin2", "hilal2"};
        return data;
    }





}
