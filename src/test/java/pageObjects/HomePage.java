package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://phptravels.net")
public class HomePage extends PageObject {

    @FindBy(linkText= "MY ACCOUNT")
//<a href="javascript:void(0);" data-toggle="dropdown" class="dropdown-toggle go-text-right" aria-expanded="true"><span class="ink animate" style="height: 135px; width: 135px; top: -40.5px; left: -12.8594px;"></span><i class="icon_set_1_icon-70 go-right"></i> My Account <b class="lightcaret mt-2 go-left"></b></a>

    public WebElementFacade myAccountButton;

    @FindBy( linkText= "Login")
    public WebElementFacade loginButton;
//*[@id="li_myaccount"]/ul/li[1]/a
//*[@id="loginfrm"]/div[1]/div[5]/button

    @FindBy(css = "div.active input.searchInput")
    public List<WebElementFacade> searchInputs;

    @FindBy(css = "div.active div.days > span")
    public List<WebElementFacade> dates;

    @FindBy(css = "div.active div.chkin")
    public WebElementFacade startDate;

    @FindBy(css = "div.active div.chkout")
    public WebElementFacade endDate;

    @FindBy(css = "div.active input#adults ~ div.inc:not(.minusplus)")
    public WebElementFacade adultsPlusButton;

    @FindBy(css = "div.active input#child ~ div.inc:not(.minusplus)")
    public WebElementFacade childPlusButton;

    @FindBy(css = "div.active button.btn-primary")
    public WebElementFacade searchButton;



    ////*[@id="citiesInput"]
    //@FindBy(css = "div.active ul.dropdown-menu li")   //*[@id="citiesInput"]  //*[@id="citiesInput"]   #citiesInput     .selected > div:nth-child(1)   .selected
//#EXPEDIA > form > div.col-md-12.col-xs-12.go-text-right.form-group > div > div.easy-autocomplete               #eac-container-citiesInput
//<span class="select2-chosen">Search by Listing or City Name</span>      //*[@id="citiesInput"] #s2id_autogen8

   //<div class="select2-container hotelsearch locationlisttours" id="s2id_autogen8" style="width: 100%;"><a href="javascript:void(0)" onclick="return false;" class="select2-choice select2-default" tabindex="-1">   <span class="select2-chosen">Search by Listing or City Name</span><abbr class="select2-search-choice-close"></abbr>   <span class="select2-arrow"><b></b></span></a><input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen9"></div>
//#s2id_autogen8 > a        <a href="javascript:void(0)" onclick="return false;" class="select2-choice select2-default" tabindex="-1">   <span class="select2-chosen">Search by Listing or City Name</span><abbr class="select2-search-choice-close"></abbr>   <span class="select2-arrow"><b></b></span></a>
    //#select2-drop > div > input    #select2-drop > div > input

    @FindBy(className= "#select2-input")
    public List<WebElementFacade> cityNamesList;

    //@FindBy(css = "span.hotel")

    @FindBy(css="#body-section > div.wow.fadeIn.searchbg.animated > div.RTL_Bar.searcharea > div > ul > li:nth-child(1) > a > span")
    public WebElementFacade hotelsTab;

    @FindBy(css = "span.flight")
    public WebElementFacade flightsTab;


    //#body-section > div.wow.fadeIn.searchbg.animated > div.RTL_Bar.searcharea > div > ul > li:nth-child(3) > a > span
    //@FindBy(css = "span.suitcase")
    @FindBy(css = "#body-section > div.wow.fadeIn.searchbg.animated > div.RTL_Bar.searcharea > div > ul > li:nth-child(3) > a > span")
    public WebElementFacade toursTab;


  //  #body-section > div.wow.fadeIn.searchbg.animated > div.RTL_Bar.searcharea > div > ul > li:nth-child(4) > a > span

   // @FindBy(css = "span.car")

    @FindBy(css = "#body-section > div.wow.fadeIn.searchbg.animated > div.RTL_Bar.searcharea > div > ul > li:nth-child(4) > a > span")
    public WebElementFacade carsTab;

    @FindBy(css = "div.dropdown-menu[style*='display: block;'] td.day:not(.disabled)")
    public List<WebElementFacade> days;

    @FindBy(css = "div.active input#adults")
    public WebElementFacade currentAdults;


    //#child
    //@FindBy(css = "div.active input#child")

    @FindBy(css = "#child")
    public WebElementFacade currentChildren;



    //#select2-drop > div > input
   // @FindBy(css = "select#tourtype")
    @FindBy(css = "#select2-drop > div > input")
    public WebElementFacade tourTypes;


    //#CARS > form > div:nth-child(2) > div:nth-child(2) > select
    //@FindBy(css = "div.active select.selectx")

    @FindBy(css = "#CARS > form > div:nth-child(2) > div:nth-child(2) > select")
    public List<WebElementFacade> times;

    //#s2id_carlocations > a > span.select2-chosen        body > div:nth-child(25) > ul
   // @FindBy(css = "a.select2-choice")             body > div.select2-drop.select2-display-none.select2-with-searchbox.select2-drop-active > ul
    @FindBy(css = "body > div.select2-drop.select2-display-none.select2-with-searchbox.select2-drop-active > ul")
    public List<WebElementFacade> carLocations;

    //@FindBy(css = "span.select2-chosen")  #s2id_carlocations2 > a > span.select2-chosen      body > div:nth-child(26) > ul
    @FindBy(css = "#select2-drop > div > input")
    //#citiesInput   #citiesInput //*[@id="citiesInput"]         #select2-drop > div > input                                                          //*[@id="citiesInput"]  #s2id_autogen8 > a > span.select2-chosen  #citiesInput
    public WebElementFacade selectedLocation;

    public void insertIntoSearchField(int searchId, String value) {
        searchInputs.get(searchId).sendKeys(value);
    }

    public void selectFromTheCityNamesList(int index) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(cityNamesList);
        cityNamesList.get(index).click();
    }

    public void selectDate(int calendarIndex, Calendar date) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(dates);
        dates.get(calendarIndex).click();
        clickOnDay(date);
    }

    public void selectStartDate(Calendar date) {
        startDate.click();
        clickOnDay(date);
    }

    public void selectEndDate(Calendar date) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(endDate).click();
        clickOnDay(date);
    }

    public void clickOnDay(Calendar date) {
        String day = Integer.toString(date.get(Calendar.DAY_OF_MONTH));

        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(days);

        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getText().equals(day)) {
                days.get(i).click();
                break;
            }
        }
    }

    public void selectAdults(int number) {
        while (Integer.valueOf(currentAdults.getValue()) < number)
            adultsPlusButton.click();
    }

    public void selectChildren(int number) {
        while (Integer.valueOf(currentChildren.getValue()) < number)
            childPlusButton.click();
    }

    public void selectTourType(String type) {
        Select tourTypesDropdown = new Select(tourTypes);
        tourTypesDropdown.selectByVisibleText(type);
    }

    public void selectTime(int dropdownId, String time) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(times);
        Select timeDropdown = new Select(times.get(dropdownId));
        timeDropdown.selectByVisibleText(time);
    }

    public void insertIntoLocation(int fieldId, String city) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(carLocations);
        carLocations.get(fieldId).click();
        carLocations.get(fieldId).sendKeys(city);
        carLocations.get(fieldId).sendKeys(Keys.ENTER);
    }

    public boolean isSelectedLocationEqual(String city) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitForText(selectedLocation, city);

        return selectedLocation.getText().equals(city);
    }
}
