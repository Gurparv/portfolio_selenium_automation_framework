
package Tests;

import Base.Base;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test
    public void testPositiveLoginFunctionality(){
        LoginPage lp = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        lp.provideUsername("standard_user");
        lp.providePassword("secret_sauce");
        lp.clickLoginBtn();
        InventoryPage ip = new InventoryPage(driver);
        Assert.assertTrue(ip.validateUrl(),"❌ Inventory Page Title NOT matching for right creds");
    }

    @Test
    public void testNegativeLoginFunctionality(){
        LoginPage lp = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        lp.provideUsername("wrong_user");
        lp.providePassword("wrong_pass");
        lp.clickLoginBtn();
        InventoryPage ip = new InventoryPage(driver);
        Assert.assertFalse(ip.validateUrl(),"❌ Inventory Page Title matching for wrong creds.");
    }
}
