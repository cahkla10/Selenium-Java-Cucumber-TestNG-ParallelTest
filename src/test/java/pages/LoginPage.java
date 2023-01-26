package pages;

import utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, GlobalVariables.TIMEOUT), this);
    }

    @FindBy(xpath = "//*[@class='login_logo']")
    @CacheLookup
    private List<WebElement> logoImg;

    @FindBy(id = "user-name")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(id = "login-button")
    @CacheLookup
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@class='bot_column']")
    @CacheLookup
    private List<WebElement> botImg;

    @FindBy(xpath = "//*[@data-test='error']")
    @CacheLookup
    private List<WebElement> errorMessage;

    public void seeLogoImg(){
        if(logoImg.size() > 0){
            System.out.println("Sauce Lab Logo displayed!");
        }
    }

    public void seeBotImg(){
        if(botImg.size() > 0){
            System.out.println("Sauce Lab Bot Image displayed!");
        }
    }

    public void clearUsernameField(){
        usernameField.clear();
    }

    public void inputUsernameField(String username){
        usernameField.sendKeys(username);
    }

    public void clearPasswordField(){
        passwordField.clear();
    }

    public void inputPasswordField(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void verifyWarningMessage(String message){
        if(errorMessage.size() > 0){
            System.out.println("Expected: " + message);
            assertEquals(message,errorMessage.get(0).getText());
        }
    }
}