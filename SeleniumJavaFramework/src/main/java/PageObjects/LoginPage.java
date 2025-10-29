package PageObjects;

import ExtentReporting.MyExtentReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MyExtentReport{


    // Fields
    public WebDriver driver;

    @FindBy(id = "user-name")
    WebElement userName ;

    @FindBy(id = "password")
    WebElement passWord ;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.test = test;
    }

    // Methods
    public void provideUsername(String username){
        //System.out.println("Providing Username : " + username);
        test.log(Status.INFO,"Proving Username : " + username);
        userName.sendKeys(username);
    }

    public void providePassword(String password){
        // System.out.println("Providing Password : " + password);
        test.log(Status.INFO,"Providing Password : " + password);
        passWord.sendKeys(password);
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
