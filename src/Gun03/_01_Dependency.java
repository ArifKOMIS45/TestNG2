package Gun03;
/*
      interviewlarda sorulan bir konu imis, test ederken nasil önceligin olmalidir seklinde.. depency,priority vs
      dependsOnMethods ve priority ile sağlarım, aksi hale alfabetik sıra ile çalışır.
      dependsOnMethods : bununla kendinden önce hangi metod çalışması gerekiyor ise onu belirtirim.
      priority : bununla çalışma sırasını belirtirim.

      *** Metoddan run yapıldığında bağımlılık seviyesi 1 ise bağımlı olduğu metoduna çağırarak çalışır.
          fakat 2 adımlım bir bağımlılık var ise yani 2 metoda bağımlı ise geriye doğru , direk run yapılamaz.
     */

import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar()
    {
        System.out.println("Car StartCar");
        //Assert.fail();
    }
 //depency olan testler tek olarak calisir eger tek method bagimli ise ama birden fazla bagimli ise calismaz
    @Test(dependsOnMethods = {"startCar"})//bunun calismasi icin startCar calismali
    void driveCar()
    {
        System.out.println("Car driveCar");
    }

    @Test(dependsOnMethods = {"startCar","driveCar"},alwaysRun = true)//bu kendisinden oncekilerin calismasa bile calisiyor
    void parkCar()
    {
        System.out.println("Car parkCar");
    }

    @Test(dependsOnMethods = {"driveCar"})//burda dependency iki method oldugundan tek calismada hata veriri
        void stopCar() {
        System.out.println("Car stopCar");
    }





}
