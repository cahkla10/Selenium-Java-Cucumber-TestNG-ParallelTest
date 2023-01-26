package pages;

import utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductsPage {
    private WebDriver webDriver;

    public ProductsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, GlobalVariables.TIMEOUT), this);
    }

    @FindBy(xpath = "//*[@class='title']")
    @CacheLookup
    private List<WebElement> titlePage;

    @FindBy(id = "react-burger-menu-btn")
    @CacheLookup
    private WebElement burgerMenu;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    @CacheLookup
    private WebElement sortDropDown;

    @FindBy(xpath = "//*[@value='az']")
    @CacheLookup
    private WebElement azSort;

    @FindBy(xpath = "//*[@value='za']")
    @CacheLookup
    private WebElement zaSort;

    @FindBy(xpath = "//*[@value='lohi']")
    @CacheLookup
    private WebElement lohiSort;

    @FindBy(xpath = "//*[@value='hilo']")
    @CacheLookup
    private WebElement hiloSort;

    @FindBy(id = "logout_sidebar_link")
    @CacheLookup
    private WebElement logoutMenu;

    public void readTitlePage(String exTitle){
        if(titlePage.size() >= 1){
            assertEquals(exTitle,titlePage.get(0).getText());
        }
    }

    public void clickBurgerMenu(){
        burgerMenu.click();
    }

    public void clickSortDropDown(){
        sortDropDown.click();
    }

    public void selectSort(String sort){
        switch (sort) {
            case "az":
                azSort.click();
                break;
            case "za":
                zaSort.click();
                break;
            case "lohi":
                lohiSort.click();
                break;
            case "hilo":
                hiloSort.click();
                break;
        }
    }

    public void readSort(String desc){
        System.out.println("Sort: " + desc);
    }
}