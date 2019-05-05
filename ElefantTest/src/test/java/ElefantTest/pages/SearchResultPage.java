package ElefantTest.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends PageObject {

    public List<String> getSearchContentTitle() {
        List<WebElementFacade> definitionList = this.findAll(By.cssSelector("div[class='col-sm-12 elf-title']"));
        return definitionList.stream()
                .map(element -> element.getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public List<String> getSearchContentBrand() {
        List<WebElementFacade> definitionList = this.findAll(By.cssSelector("div[class='col-sm-12 elf-brand']"));
        return definitionList.stream()
                .map(element -> element.getText().toLowerCase())
                .collect(Collectors.toList());
    }
    public String getTitle() {
        WebElementFacade definitionList = find(By.tagName("h1"));
        return definitionList.getText();
    }

    public String getAddTitle() {
        WebElementFacade definitionList = find(By.className("title"));
        return definitionList.getText();
    }

    public String getAddSubtitle() {
        WebElementFacade definitionList = find(By.className("subtitle"));
        return definitionList.getText();
    }

    public String getSearchNoContentMessage() {
        WebElementFacade definitionList = find(By.tagName("h2"));
        return definitionList.getText();
    }

    public String clickOneElement() {
        WebElementFacade definitionList = find(By.xpath("//*[@id=\"101877475\"]/div/div[1]/div/a/img"));
        definitionList.click();
        return getDriver().getCurrentUrl();
    }

    public String clickAnotherElement() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,200)");
        WebElementFacade definitionList = find(By.xpath("//*[@id=\"100690700\"]/div/div[2]/div/div[2]/a"));
        definitionList.click();
        return getDriver().getCurrentUrl();
    }
}