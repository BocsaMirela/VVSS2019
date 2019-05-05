package ElefantTest.features.search.functionTourTests;

import ElefantTest.steps.serenity.AddToCartSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartFunctionTourTests {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public AddToCartSteps addToCartSteps;

    @Test
    public void addItemToCartVALID() {
        addToCartSteps.addToCartButtonSteps("cosmetice-si-parfumuri/parfumuri/apa-de-parfum/apa-de-parfum-christian-dior-j-adore-iii-ml-pentru-femei-incolor-40321-355.html");
        addToCartSteps.openCartPage();
        addToCartSteps.cartNumberValueShouldBe("1");
        addToCartSteps.pageElementShouldContainElement("christian-dior-j-adore","CHRISTIAN DIOR","Apa de parfum Christian Dior", "lei");

    }

    @Test
    public void clickTwiceButAppearOnce() throws InterruptedException {
        addToCartSteps.clickTwice("cosmetice-si-parfumuri/parfumuri/apa-de-parfum/apa-de-parfum-christian-dior-j-adore-iii-ml-pentru-femei-incolor-40321-355.html");
        addToCartSteps.openCartPage();
        addToCartSteps.cartNumberValueShouldBe("1");
        addToCartSteps.pageElementShouldContainElement("christian-dior-j-adore","CHRISTIAN DIOR","Apa de parfum Christian Dior", "lei");

    }

} 