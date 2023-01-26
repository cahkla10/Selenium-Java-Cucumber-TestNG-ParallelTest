package utils;

import org.openqa.selenium.WebDriver;

public class ThreadLocalDriver {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void setThreadLocDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static WebDriver getThreadLocDriver() {
        return webDriver.get();
    }
}
