package setups;

import helpers.ThreadLocalDriver;
import org.openqa.selenium.WebDriver;

public class BrowserSetup {
    public static WebDriver getWebDriver(){
        return ThreadLocalDriver.getThreadLocDriver();
    }

    public static void setWebDriver(String browser) {
        Capabilities capabilities = new Capabilities();
        switch (browser){
            case "chrome":
                ThreadLocalDriver.setThreadLocDriver(capabilities.ChromeDriver());
                break;
            case "edge":
                ThreadLocalDriver.setThreadLocDriver(capabilities.EdgeDriver());
                break;
            case "firefox":
                ThreadLocalDriver.setThreadLocDriver(capabilities.FirefoxDriver());
                break;
        }
    }
}