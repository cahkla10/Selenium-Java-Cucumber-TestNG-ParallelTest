package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import setups.BrowserSetup;
import utils.ThreadLocalDriver;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@TC002",
        glue = {""},
        plugin = {"pretty","json:target/report/cucumber.json","html:target/report/index.html"},
        monochrome = true
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters("browserName")
    public void browser(@Optional("firefox") String browserName) {
        BrowserSetup.setWebDriver(browserName);
        System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());
    }

    @AfterTest
    public void after() {
        ThreadLocalDriver.getThreadLocDriver().quit();
        System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
        ThreadLocalDriver.webDriver.remove();
    }
}
