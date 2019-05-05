package ElefantTest.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class TabMenuResultPage extends PageObject {

    public List<String> getTabMenuContent() {
        List<WebElementFacade> definitionList = this.findAll(By.cssSelector("div[class='col-sm-12 elf-title']"));
        return definitionList.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public String getTitle() {
        WebElementFacade definitionList = find(By.tagName("h1"));
        return definitionList.getText();
    }

    public String clickOneElementParfum() {
        WebElementFacade definitionList = find(By.xpath("//*[@id=\"101101996\"]/div/div[2]/div/div[2]/a"));
        definitionList.click();
        return getDriver().getCurrentUrl();
    }

    public String clickOneElementCarti() {
        WebElementFacade definitionList = find(By.xpath("//*[@id=\"100338067\"]/div/div[2]/div/div[2]/a"));
        definitionList.click();
        return getDriver().getCurrentUrl();
    }
}