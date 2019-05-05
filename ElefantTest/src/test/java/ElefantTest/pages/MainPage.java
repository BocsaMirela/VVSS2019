package ElefantTest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

@DefaultUrl("http://www.elefant.ro/")
public class MainPage extends PageObject {

    @FindBy(name = "query")
    private WebElementFacade searchInput;

    @FindBy(id = "searchsubmit")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a")
    private WebElementFacade tabMenuParfum;

    @FindBy(xpath = "//*[@id=\"navbar-collapse-grid\"]/ul/li[2]/a")
    private WebElementFacade tabMenuCarti;

    @FindBy(css = "#navbar-1 > li:nth-child(4) > a")
    private WebElementFacade tabMenuItemApaDeParfum;

    @FindBy(css = "#navbar-10 > li:nth-child(1) > a")
    private WebElementFacade tabMenuItemCartiFictiune;

    @FindBy(css = "body > div.container > header > div:nth-child(1) > div.no-gutter-left-xs.col-xs-4.col-sm-offset-4.col-sm-5.col-md-offset-0.col-md-3.col-md-push-6 > div.header-shopping-cart.header-loaded > div.header-cart-icon")
    private WebElementFacade cartButton;

    public void enterSearchInput(String keyword) {
        element(searchInput).waitUntilVisible();
        searchInput.type(keyword);
    }

    public void searchButtonClick() {
        element(searchButton).waitUntilVisible();
        searchButton.click();
    }

    public void tabMenuParfumClick() {
        element(tabMenuParfum).waitUntilVisible();
        tabMenuParfum.click();
    }

    public void tabMenuCartiClick() {
        element(tabMenuCarti).waitUntilVisible();
        tabMenuCarti.click();
    }

    public void tabMenuItemApaDeParfumClick() {
        element(tabMenuItemApaDeParfum).waitUntilVisible();
        tabMenuItemApaDeParfum.click();
    }

    public void setTabMenuItemCartiFictiuneClick() {
        element(tabMenuItemCartiFictiune).waitUntilVisible();
        tabMenuItemCartiFictiune.click();
    }

    public void cartButtonClick() {
        element(cartButton).waitUntilVisible();
        cartButton.click();
    }

    public String getExpendedTabMenuValue() {
        WebElementFacade webElement = find(By.xpath("//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a"));
        return webElement.getAttribute("aria-expanded");
    }

    public String getExpendedTabMenuColor() {
        WebElementFacade webElement = find(By.xpath("//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a"));
        return webElement.getCssValue("background-color");
    }

    public String getCartNumberValue() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(400,0)");
        WebElementFacade webElement = find(By.id("cart_count"));
        return webElement.getText();
    }

    public String getUsername() {
        WebElementFacade webElement = find(By.id("user_name"));
        return webElement.getText();
    }

    public void clickbetweenTabs() {
        WebElementFacade webElement = find(By.id("navbar-collapse-grid"));
        webElement.click();
    }

    public boolean getExpandableTabMenus() {
        try {
            WebElementFacade webElement= find(By.cssSelector("#navbar-collapse-grid > ul > li:nth-child(1) > div"));
            return webElement.isVisible();
        }catch (Exception e){
            return false;
        }
    }

    public void clickRightTabs(){
        WebElementFacade webElementFacade = find(By.cssSelector("#navbar-collapse-grid > ul > li:nth-child(8) > a > span"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("document.querySelector('#navbar-collapse-grid > ul > li:nth-child(8) > a > span').focus();");    }
}