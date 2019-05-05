package ElefantTest.steps.serenity;

import ElefantTest.pages.MainPage;
import ElefantTest.pages.TabMenuResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class TabMenuSteps extends ScenarioSteps {

    MainPage mainPage;
    TabMenuResultPage tabMenuResultPage;

    @Step
    public void isTheHomePage() {
        mainPage.open();
    }

    @Step
    public void openSearchResultPage(String searchString) {
        String url = "http://www.elefant.ro/list/" + searchString + "?sortsales=desc&filtersex=Femei~~~Unisex";
        tabMenuResultPage.openUrl(url);
    }

    @Step
    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    @Step
    public void clickMenu() {
        mainPage.tabMenuParfumClick();
    }

    @Step
    public void clickTabMenuItem() {
        mainPage.tabMenuItemApaDeParfumClick();
    }

    @StepGroup
    public void clickMenuStepsParfum(String expanded, String color) {
        isTheHomePage();
        clickMenu();
        tabMenuShouldBeExpended(expanded);
        tabMenuShouldBeFocused(color);
    }

    @StepGroup
    public void clickTabMenuItemStepsParfum(String title, String contentKey) {
        mainPage.tabMenuItemApaDeParfumClick();
        openSearchResultPage("cosmetice-si-parfumuri/parfumuri/apa-de-parfum");
        shouldSeeTitle(title);
        shouldSeeTabMenuContent(contentKey);
    }

    @StepGroup
    public void clickMenuStepsCarti(String expanded, String color) {
        isTheHomePage();
        mainPage.tabMenuCartiClick();
        tabMenuShouldBeExpended(expanded);
        tabMenuShouldBeFocused(color);
    }

    @StepGroup
    public void clickTabMenuItemStepsCarti(String title, String contentKey) {
        mainPage.setTabMenuItemCartiFictiuneClick();
        openSearchResultPage("carti/carte/fictiune");
        shouldSeeTitle(title);
        shouldSeeTabMenuContent(contentKey);
    }

    @Step
    public void clickBetweenTabs() {
        isTheHomePage();
//        mainPage.clickbetweenTabs();
        mainPage.clickRightTabs();
    }

    @Step
    public void clickBetweenTabsAssert() {
        assertThat(mainPage.getExpandableTabMenus(), Matchers.is(false));
    }

    @Step
    public void tabMenuShouldBeExpended(String bool) {
        assertThat(mainPage.getExpendedTabMenuValue().toLowerCase(), Matchers.containsString(bool.toLowerCase()));
    }

    @Step
    public void tabMenuShouldBeFocused(String whileColor) {
        assertThat(mainPage.getExpendedTabMenuColor().toLowerCase(), Matchers.containsString(whileColor.toLowerCase()));
    }

    @Step
    public void shouldSeeTitle(String title) {
        assertThat(tabMenuResultPage.getTitle(), Matchers.containsString(title));
    }

    @Step
    public void shouldSeeTabMenuContent(String title) {
        assertThat(tabMenuResultPage.getTabMenuContent(), Matchers.everyItem(Matchers.containsString(title)));
    }

    public String clickFirstElementParfum() {
        return tabMenuResultPage.clickOneElementParfum();
    }

    public String clickFirstElementCarti() {
        return tabMenuResultPage.clickOneElementCarti();
    }

    public void shouldBeClearlyDescriptive() {

    }

    public void shouldLookLikeClickableVersions() {
    }
}