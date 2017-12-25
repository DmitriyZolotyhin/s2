package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by testuser on 08/11/16.
 */
public class SearchResultsPage extends PageObject {

    private String title = "Search Results";

   // @FindBy(css = "a.go-right")
    @FindBy(css = "#select2-drop > div > input")
   // #select2-drop > div > input

    public List<WebElementFacade> resultsCities;

    @FindBy(xpath = "//small[contains(text(), 'Total Stay')]/following-sibling::span")
    public WebElementFacade totalStay;


   // @FindBy(css = "a.tooltip-1:first-of-type")
    @FindBy(css = "#select2-drop > div > input")

    public List<WebElementFacade> resultsTourTypes;

   // #select2-drop > div > input


    public boolean isDisplayed() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitForTitle(title);

        return getTitle().equals(title);
    }

    public boolean areAllResultsFrom(String city) {
        for (WebElementFacade element : resultsCities) {
            getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
            if (!element.getText().equals(city))
                return false;
        }

        return true;
    }

    public boolean areAllResultsWithType(String type) {
        for (WebElementFacade element : resultsTourTypes) {
            getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
            if (!element.getText().equals(type))
                return false;
        }

        return true;
    }
}
