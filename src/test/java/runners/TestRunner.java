package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import setups.BrowserSetup;
import utils.ThreadLocalDriver;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@TC001",
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
        ThreadLocalDriver.getThreadLocDriver().quit();
    }

    //mvn clean test -DsuiteXmlFile=browserList.xml
}