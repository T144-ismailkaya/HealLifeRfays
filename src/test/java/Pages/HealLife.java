package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HealLife {

    public HealLife(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//*[text()='Home'])[1]")
    public WebElement Home;

    @FindBy (xpath = "(//*[text()='Appointment'])[1]")
    public WebElement Appointment;

    @FindBy (xpath = "(//*[text()='About Us '])[1]")
    public WebElement AboutUs;

    @FindBy (xpath = "(//*[text()='Gallery'])[1]")
    public WebElement Gallery;

    @FindBy (xpath = "(//*[text()='Contact Us'])[1]")
    public WebElement ContactUs;

    @FindBy (xpath = "//*[text()='Login']")
    public WebElement Login;

    @FindBy (xpath = "//*[text()=' Dashboard']")
    public WebElement Dashboard;

    @FindBy (id = "email")
    public WebElement email;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (className = "btn")
    public WebElement signInButton;

    @FindBy (xpath = "//*[@target='_blank']")
    public List<WebElement> socialMediaLinks;

}
