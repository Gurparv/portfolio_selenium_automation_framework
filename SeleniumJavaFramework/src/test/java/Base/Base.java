package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    private String[] browsers ;

    @BeforeSuite
    public void setUp() throws IOException {
        System.out.println("Running Setup !");
        readConfigFile();
        instantiateBrowser();
    }

    public void readConfigFile() throws IOException {
        System.out.println("Reading config file.");
        Properties prop = new Properties();
        String userDirectory = System.getProperty("user.dir");
        String pathToConfig = "\\src\\test\\java\\resources\\";
        String completeConfigPath = userDirectory + pathToConfig + "config.properties";
        FileInputStream in  = new FileInputStream(completeConfigPath);
        prop.load(in);
        this.browsers = prop.getProperty("browser").split(",");
        in.close();
    }

    public void instantiateBrowser(){
        System.out.println("Instantiating Browsers !!");
        for (String browser: browsers){
            switch (browser.toLowerCase()){
                case "chrome":
                    driver =  new ChromeDriver();
                    System.out.println("✅ Chrome Starting...");
                    break;
                case "firefox":
                    driver =  new FirefoxDriver();
                    System.out.println("✅ FireFox Starting...");
                    break;
                case "safari":
                    driver = new SafariDriver();
                    System.out.println("✅ Safari Starting...");
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    System.out.println("✅ Edge Starting...");
                case "internetexplorer":
                    driver = new InternetExplorerDriver();
                    System.out.println("✅ IE Starting...");
                default:
                    System.out.println("🤔 Either empty or Not a valid browser name.");
            }
        }
    }

}
