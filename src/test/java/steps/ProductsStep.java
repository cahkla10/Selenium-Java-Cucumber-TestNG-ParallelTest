package steps;

import io.cucumber.java.en.*;
import pages.ProductsPage;
import setups.BrowserSetup;
import utils.ThreadLocalDriver;

public class ProductsStep {
    ProductsPage productsPage = new ProductsPage(ThreadLocalDriver.getThreadLocDriver());

    @When("^user click sort drop down$")
    public void user_click_sort_drop_down(){
        productsPage.clickSortDropDown();
    }

    @When("^user select sort \"([^\"]*)\"$")
    public void user_select_sort(String sort){
        productsPage.selectSort(sort);
    }

    @Then("^product will be sorted \"([^\"]*)\"$")
    public void product_will_be_sorted(String desc){
        productsPage.readSort(desc);
    }
}