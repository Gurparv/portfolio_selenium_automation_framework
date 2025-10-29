package Base;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Base {

    public WebDriver driver;
    private String[] browsers ;
    public HashMap<String, String> myData = new HashMap<>();

    @BeforeSuite
    public void setUp() throws IOException, ParseException {
        System.out.println("Running Setup !");
        readConfigFile();
        readData();
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

    public void readData() throws IOException, ParseException {
        System.out.println("📃 Reading TestData ... ");
        JSONParser jp = new JSONParser();
        String userDirectory = System.getProperty("user.dir");
        String pathToTestData = "\\src\\test\\java\\resources\\";
        String completeTestDataPath = userDirectory + pathToTestData + "TestData.json";
        FileReader fr = new FileReader(completeTestDataPath);
        Object obj = jp.parse(fr);
        JSONObject jObj = (JSONObject) obj;
        Set<String> keys = jObj.keySet();
        for(String key: keys)
            myData.put(key, (String)jObj.get(key));
        System.out.println("My Test Data values.. 👇");
        System.out.println(myData);
    }

}
