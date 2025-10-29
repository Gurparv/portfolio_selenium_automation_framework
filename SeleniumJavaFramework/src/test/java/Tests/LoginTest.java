
package Tests;

import Base.Base;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test
    public void testPositiveLoginFunctionality(){
        ExtentTest test = exReport.instantiateExtentReport();
        LoginPage lp = new LoginPage(driver,test);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        lp.provideUsername(myData.get("valid_username"));
        lp.providePassword(myData.get("valid_password"));
        lp.clickLoginBtn();
        InventoryPage ip = new InventoryPage(driver);
        Assert.assertTrue(ip.validateUrl(),"❌ Inventory Page Title NOT matching for right creds");
        test.log(Status.PASS, "Assertion Passed. ✅");
    }

    @Test
    public void testNegativeLoginFunctionality(){
        ExtentTest test = exReport.instantiateExtentReport();
        LoginPage lp = new LoginPage(driver, test);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        lp.provideUsername(myData.get("invalid_username"));
        lp.providePassword(myData.get("invalid_password"));
        lp.clickLoginBtn();
        InventoryPage ip = new InventoryPage(driver);
        Assert.assertFalse(ip.validateUrl(),"❌ Inventory Page Title matching for wrong creds.");
        test.log(Status.PASS, "Assertion Passed. ✅");
    }
}
