package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class LoginPage extends PageObject {
    private String title = "Login";

    @FindBy(css = "input[name='username']")
    public WebElementFacade usernameField;

    @FindBy(css = "input[name='password']")
    public WebElementFacade passwordField;

    @FindBy(css = "#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > button")
    public WebElementFacade loginButton;


    //#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > button

   // #loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > button
    // 1 // button[class*='loginbtn']


    @FindBy(css = "div[class='alert alert-danger']")
    public WebElementFacade errorMessage;

    public boolean isDisplayed() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitForTitle(title);

        return getTitle().equals(title);
    }

    public String getErrorMessage() {
        return withTimeoutOf(60, TimeUnit.SECONDS).waitFor(errorMessage).getText();
    }
}
