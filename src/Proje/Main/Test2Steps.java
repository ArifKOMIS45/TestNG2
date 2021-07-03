package Proje.Main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Test2Steps extends BaseDriver {

    @FindBy(xpath = "//div[@class='block block-category-navigation']//a[contains(.,'Apparel & Shoes')]")
    private WebElement appealsAndShoes;

    public WebElement getWishListBtn() {
        return wishListBtn;
    }

    @FindBy(css = "a[title='Show details for Blue and green Sneaker']")
    private WebElement blueANdGreenSneakers;
    @FindBy(css = ".add-to-wishlist-button")
    private WebElement addToWishList;
    @FindBy(css = "a[href='/50s-rockabilly-polka-dot-top-jr-plus-size']")
    private WebElement polka;
    @FindBy(xpath = "//a[.='wishlist']")
    private WebElement wishListBtn;

    @FindBy(css = ".page.wishlist-page>div")
    public  List<WebElement> wishListItems;



    public Test2Steps() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    public WebElement getPolka() {
        return polka;
    }

    public WebElement getAddToWishList() {
        return addToWishList;
    }

    public WebElement getBlueANdGreenSneakers() {
        return blueANdGreenSneakers;
    }

    public WebElement getAppealsAndShoes() {
        return appealsAndShoes;
    }


}
