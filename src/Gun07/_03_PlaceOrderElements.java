package Gun07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
// bunun için aşağıdaki consructor eklendi ve için PageFatory ile
// driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
// Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
// anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
// aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
// gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.

public class _03_PlaceOrderElements {

    public _03_PlaceOrderElements(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "input[name='search']")
    public WebElement searchBox;

    @FindBy(css = "button[type='button'][class='btn btn-default btn-lg']")
    public WebElement searchClick;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement ipod;


    @FindBy(xpath = "//a[text()='shopping cart']")
    public WebElement shoppingChart;


    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkOut;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;

    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

    @FindBy(css = "input[type='checkbox']")
    public WebElement agree;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy (id = "button-confirm")
    public WebElement confirm;


}
