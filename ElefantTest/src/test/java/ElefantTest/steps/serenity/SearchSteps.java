package ElefantTest.steps.serenity;

import ElefantTest.pages.MainPage;
import ElefantTest.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSteps extends ScenarioSteps {

    MainPage mainPage;
    SearchResultPage searchResultPage;

    @Step
    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    @Step
    public String openSearchResultPage(String searchString) {
        String url = "http://www.elefant.ro/search?query=" + searchString;
        searchResultPage.openUrl(url);
        return url;
    }

    @Step
    public void openSearchResultPageFromUrl(String url) {
        searchResultPage.openUrl(url);
    }

    @Step
    public void enters(String keyword) {
        mainPage.enterSearchInput(keyword);
    }

    @Step
    public String clickFirstElement() {
         return searchResultPage.clickOneElement();
    }

    @Step
    public void startsSearch() {
        mainPage.searchButtonClick();
    }

    @Step
    public void shouldSeeTitle(String title) {
        assertThat(searchResultPage.getTitle().toLowerCase(), Matchers.containsString(title.toLowerCase()));
    }

    @Step
    public void shouldSeeSearchContent(String t1,String s2, String s3) {
        assertThat(searchResultPage.getSearchContentTitle(),
                Matchers.either(Matchers.everyItem(Matchers.containsString(t1.toLowerCase())))
                .or(Matchers.everyItem(Matchers.containsString(s2.toLowerCase()))).
                        or(Matchers.everyItem(Matchers.containsString(s3.toLowerCase()))));
    }

    @Step
    public void shouldSeeNoSearchContent(String title, String subtitle) {
        assertThat(searchResultPage.getTitle().toLowerCase(), Matchers.containsString(title.toLowerCase()));
        assertThat(searchResultPage.getSearchNoContentMessage().toLowerCase(), Matchers.containsString(subtitle.toLowerCase()));
    }

    @Step
    public void shouldBeMainPage(String title, String subtitle) {
        assertThat(searchResultPage.getAddTitle().toLowerCase(), Matchers.not(Matchers.isEmptyString()));
        assertThat(searchResultPage.getAddSubtitle().toLowerCase(), Matchers.not(Matchers.isEmptyString()));
    }

    @Step
    public void isTheHomePage() {
        mainPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        startsSearch();
        openSearchResultPage(term);
    }
    @Step
    public String looksForUrl(String term) {
        enters(term);
        startsSearch();
        return openSearchResultPage(term);
    }

    public String clickAnotherElement() {
        return searchResultPage.clickAnotherElement();
    }
}