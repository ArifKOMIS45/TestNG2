package Proje.Main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test1Steps extends BaseDriver{

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    public WebElement contactUs;
    @FindBy(id = "Enquiry")
    private WebElement enquiry;
    @FindBy(name = "send-email")
    private WebElement submit;
    @FindBy(css = ".result")
    private WebElement messageAlert;

    public Test1Steps() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    public WebElement getMessageAlert() {
        return messageAlert;
    }

    public WebElement getContactUs() { return contactUs; }

    public WebElement getEnquiry() {
        return enquiry;
    }

    public WebElement getSubmit() {
        return submit;
    }





}
