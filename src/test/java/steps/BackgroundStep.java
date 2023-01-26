package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.Dimension;
import pages.LoginPage;
import setups.BrowserSetup;
import utils.ThreadLocalDriver;

public class BackgroundStep {
    LoginPage loginPage = new LoginPage(ThreadLocalDriver.getThreadLocDriver());

    @Given("^user type \"([^\"]*)\" in address bar$")
    public void userTypeInAddressBar(String url) {
        ThreadLocalDriver.getThreadLocDriver().manage().window().setSize(new Dimension(1024, 768));
        ThreadLocalDriver.getThreadLocDriver().navigate().to(url);
    }

    @Then("^Sauce Demo web will displayed$")
    public void sauceDemoWebWillDisplayed() throws Throwable {
        loginPage.seeLogoImg();
    }
}