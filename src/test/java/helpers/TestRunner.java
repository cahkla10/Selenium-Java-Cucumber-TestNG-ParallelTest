package helpers;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import setups.BrowserSetup;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@TC001",
        glue = {""},
        plugin = {"pretty","json:target/cucumber.json","html:target/report/index.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests{
    @BeforeTest
    @Parameters("browserName")
    public void browser(@Optional("firefox") String browserName) {
        System.out.println("Browser Test Runner: " + browserName);
        System.setProperty("browser", browserName);
    }
}