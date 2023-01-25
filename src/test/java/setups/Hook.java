package setups;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook{
    @Before
    public void before() {
        BrowserSetup.setWebDriver();
    }

    @After
    public void after() {
        BrowserSetup.getWebDriver().quit();
    }
}