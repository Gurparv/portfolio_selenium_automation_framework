package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    // Fields
    public WebDriver driver;

    @FindBy(id = "user-name")
    WebElement userName ;

    @FindBy(id = "password")
    WebElement passWord ;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void provideUsername(String username){
        System.out.println("Providing Username : " + username);
        userName.sendKeys(username);
    }

    public void providePassword(String password){
        System.out.println("Providing Password : " + password);
        passWord.sendKeys(password);
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
