package ElefantTest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

@DefaultUrl("http://www.elefant.ro/autentificare")
public class LoginPage extends PageObject {

    @FindBy(id = "login_username")
    private WebElementFacade email;

    @FindBy(id = "login_password")
    private WebElementFacade password;

    @FindBy(id = "login_classic")
    private WebElementFacade loginButton;

    public void enterEmailInput(String keyword) {
        element(email).waitUntilVisible();
        email.type(keyword);
    }

    public void enterPAsswordInput(String keyword) {
        element(password).waitUntilVisible();
        password.type(keyword);
    }

    public void loginButtonClick() {
//        element(loginButton).waitUntilVisible();
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,400)");
        loginButton.click();
    }

    public String getPasswordBorderColor() {
        WebElementFacade webElement = find(By.id("login_password"));
        return webElement.getCssValue("border-color");
    }

    public String getEmailBorderColor() {
        WebElementFacade webElement = find(By.id("login_username"));
        return webElement.getCssValue("border-color");
    }

    public String getInvalidAccountMessage() {
        WebElementFacade webElement = find(By.cssSelector("div[class='col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 errors']"));
        return webElement.getText();
    }

    public String getInvalidPasswordMessage() {
        WebElementFacade webElement = find(By.id("login_password-error"));
        return webElement.getText();
    }

    public String getInvalidEmailMessage() {
        WebElementFacade webElement = find(By.id("login_username-error"));
        return webElement.getText();
    }
}