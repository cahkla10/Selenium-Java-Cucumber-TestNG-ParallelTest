package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.Dimension;
import pages.LoginPage;
import setups.BrowserSetup;

public class BackgroundStep {
    LoginPage loginPage = new LoginPage(BrowserSetup.getWebDriver());

    @Given("^user type \"([^\"]*)\" in address bar$")
    public void userTypeInAddressBar(String url) {
        BrowserSetup.getWebDriver().manage().window().setSize(new Dimension(1024, 768));
        BrowserSetup.getWebDriver().navigate().to(url);
    }

    @Then("^Sauce Demo web will displayed$")
    public void sauceDemoWebWillDisplayed() throws Throwable {
        loginPage.seeLogoImg();
    }
}