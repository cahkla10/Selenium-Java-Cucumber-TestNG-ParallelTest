package helpers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import setups.BrowserSetup;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@TC001 or @TC002",
        glue = {""},
        plugin = {"pretty","json:target/report/cucumber.json","html:target/report/index.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests{
    @BeforeTest
    @Parameters("browserName")
    public void browser(@Optional("firefox") String browserName) {
        BrowserSetup.setWebDriver(browserName);
    }

    @AfterTest
    public void after() {
        BrowserSetup.getWebDriver().quit();
    }
}