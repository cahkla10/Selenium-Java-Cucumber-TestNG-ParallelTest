package setups;

import utils.ThreadLocalDriver;
import org.openqa.selenium.WebDriver;

public class BrowserSetup {
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
