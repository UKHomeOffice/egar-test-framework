package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.CommonUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarPeoplePage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarStartPage;

import java.util.List;

public class GarPeoplePageSteps
{
    WebUtils webUtils;
    GarPeoplePage garPeoplePage;
    CommonUtils commonUtils;


    public GarPeoplePageSteps(GarPeoplePage garPeoplePage, WebUtils webUtils, CommonUtils commonUtils)
    {
        this.garPeoplePage = garPeoplePage;
        this.webUtils = webUtils;
        this.commonUtils = commonUtils;
    }


    @And("^user should see '(\\d+)' radio buttons$")
    public void user_should_see_radio_buttons(int count) throws Throwable
    {
        Assert.assertTrue(garPeoplePage.number_of_radio_button(count));
    }

    @When("^I choose to \"([^\"]*)\"$")
    public void i_choose_to(String button_on_people_page)
    {
        garPeoplePage.click_button_on_people_page(button_on_people_page);
    }


    @Then("^I should see validation error message \"([^\"]*)\"$")
    public void i_should_see_validation_error_message(String error_message)
    {
        commonUtils.visible_text_on_the_page(error_message);
    }

    @Then("^user enters below details$")
    public void user_enters_below_details(List<String> fieldNames)
    {
       garPeoplePage.enter_text_in_relavent_fields(fieldNames);
    }

    @Then("^I should be able to see \"([^\"]*)\" added in \"([^\"]*)\"$")
    public void i_should_be_able_to_see_added_in(String type_of_person, String category)
    {
        garPeoplePage.check_if_person_is_added_or_not(category, type_of_person);
    }

}
