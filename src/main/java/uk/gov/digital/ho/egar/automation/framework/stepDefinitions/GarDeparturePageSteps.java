package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarAirCraftPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarDeparturePage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarStartPage;

public class GarDeparturePageSteps
{
    WebUtils webUtils;
    GarAirCraftPage garAirCraftPage;
    GarStartPage garStartPage;
    GarDeparturePage garDeparturePage;


    public GarDeparturePageSteps(GarStartPage garStartPage,GarAirCraftPage garAirCraftPage, WebUtils webUtils, GarDeparturePage garDeparturePage)
    {
        this.webUtils = webUtils;
        this.garAirCraftPage = garAirCraftPage;
        this.garStartPage = garStartPage;
        this.garDeparturePage = garDeparturePage;
    }

    @And("^I should see subject titles as \"([^\"]*)\" on page$")
    public void then_I_should(String subject_title) throws Throwable
    {
        Assert.assertTrue(garDeparturePage.title_seen_by_user(subject_title));
    }

    @And("^I should also see Dropdown List \"([^\"]*)\"$")
    public void i_should_also_see_Dropdown_List(String dropdown_list_titles) throws Throwable
    {
        Assert.assertTrue(garDeparturePage.dropdown_title_seen_by_user(dropdown_list_titles));
    }

    @And("^I saw \"([^\"]*)\" checkBox$")
    public void i_saw_checkBox(String checkbox_name) throws Throwable {

    }


}
