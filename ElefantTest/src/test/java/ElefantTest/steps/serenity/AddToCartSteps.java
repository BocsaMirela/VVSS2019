package ElefantTest.steps.serenity;

import ElefantTest.pages.CartPage;
import ElefantTest.pages.ElementPage;
import ElefantTest.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartSteps extends ScenarioSteps {

    MainPage mainPage;
    CartPage cartPage;
    ElementPage elementPage;

    @Step
    public void isTheHomePage() {
        mainPage.open();
    }

    @Step
    public void openCartPage() {
        cartPage.open();
    }

    @Step
    public void openElementPage(String searchString) {
        String url = "http://www.elefant.ro/" + searchString;
        elementPage.openUrl(url);
    }

    @Step
    public void openElementPageFromUrl(String url) {
        elementPage.openUrl(url);
    }

    @Step
    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    @Step
    public void clickCartButton() {
        mainPage.cartButtonClick();
    }

    @Step
    public void addToCartButtonClick() {
        elementPage.addToCartButtonClick();
    }

    @StepGroup
    public void clickCartButtonSteps() {
        isTheHomePage();
        clickCartButton();
        openCartPage();
    }

    @StepGroup
    public void addToCartButtonSteps(String searchQuery) {
        openElementPage(searchQuery);
        addToCartButtonClick();
    }

    @Step
    public void cartNumberValueShouldBe(String value) {
        assertThat(mainPage.getCartNumberValue().toLowerCase(), Matchers.containsString(value.toLowerCase()));
    }

    @Step
    public void shouldBeMainPage(String title, String subtitle) {
        assertThat(cartPage.getAddTitle().toLowerCase(), Matchers.not(Matchers.isEmptyString()));
        assertThat(cartPage.getAddSubtitle().toLowerCase(), Matchers.not(Matchers.isEmptyString()));
    }

    public void pageElementShouldContainElement(String logo, String brand, String description, String money) {
        assertThat(elementPage.getElementImageURL().toLowerCase(), Matchers.containsString(logo.toLowerCase()));
        assertThat(elementPage.getElementBrand().toLowerCase(), Matchers.containsString(brand.toLowerCase()));
        assertThat(elementPage.getElementTitle().toLowerCase(), Matchers.containsString(description.toLowerCase()));
        assertThat(elementPage.getElementMoneyType().toLowerCase(), Matchers.containsString(money.toLowerCase()));
    }

    public void clickTwice(String searchQuery) {
        openElementPage(searchQuery);
        elementPage.addToCartButtonClickTwice();
    }

    public void shouldDisplayModalWindow() {

    }
}