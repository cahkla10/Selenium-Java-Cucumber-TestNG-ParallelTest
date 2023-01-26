package setups;

import utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Capabilities {
    public WebDriver webDriver;

    public WebDriver ChromeDriver(){
        System.setProperty("webdriver.chrome.driver", GlobalVariables.USERDIR + "/src/test/resources/webdriver/chromedriver.exe");
        ChromeOptions chOptions = new ChromeOptions();
        chOptions.addArguments("--headless");
        webDriver = new ChromeDriver();
        return webDriver;
    }

    public WebDriver EdgeDriver(){
        System.setProperty("webdriver.edge.driver", GlobalVariables.USERDIR + "/src/test/resources/webdriver/msedgedriver.exe");
        EdgeOptions edOptions = new EdgeOptions();
        edOptions.addArguments("--headless");
        webDriver = new EdgeDriver();
        return webDriver;
    }

    public WebDriver FirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", GlobalVariables.USERDIR + "/src/test/resources/webdriver/geckodriver.exe");
        FirefoxOptions frOptions = new FirefoxOptions();
        frOptions.addArguments("--headless");
        webDriver = new FirefoxDriver();
        return webDriver;
    }
}