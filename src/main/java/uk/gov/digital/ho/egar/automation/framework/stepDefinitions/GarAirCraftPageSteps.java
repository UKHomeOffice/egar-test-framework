package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarAirCraftPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarStartPage;

public class GarAirCraftPageSteps
{
    WebUtils webUtils;
    GarAirCraftPage garAirCraftPage;
    GarStartPage garStartPage;

    public GarAirCraftPageSteps(GarStartPage garStartPage,GarAirCraftPage garAirCraftPage, WebUtils webUtils)
    {
        this.webUtils = webUtils;
        this.garAirCraftPage = garAirCraftPage;
        this.garStartPage = garStartPage;
    }

    @When("^I see \"([^\"]*)\" field then I enter \"([^\"]*)\" in \"([^\"]*)\"$")
    public void i_see_field_then_I_enter(String field_name, String enter_text, String feild_attri) throws Throwable
    {
        garAirCraftPage.enter_text_in_the_mentioned_field(field_name, enter_text, feild_attri);
    }

    @When("^I can also see radio buttons \"([^\"]*)\" or \"([^\"]*)\" asking if the due taxes are paid$")
    public void i_can_also_see_radio_buttons_or_asking_if_the_due_taxes_are_paid(String possitive, String negative) throws Throwable
    {
        garAirCraftPage.check_if_yes_Or_no_options_visible(possitive,negative);
    }

    @Then("^I choose \"([^\"]*)\" option$")
    public void i_choose_option(String option_to_choose) throws Throwable
    {
        garAirCraftPage.choose_checkbox_options(option_to_choose);
    }

    @Then("^I \"([^\"]*)\"$")
    public void i(String button_to_be_clickable) throws Throwable
    {
      garStartPage.click_buttons(button_to_be_clickable);
    }

}
