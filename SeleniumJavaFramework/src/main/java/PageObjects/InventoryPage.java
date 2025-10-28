package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    public WebDriver driver;

    public InventoryPage(WebDriver driver){
       this.driver = driver;
    }

    public boolean validateUrl(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }
}
