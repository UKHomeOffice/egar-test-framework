package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarSummaryPage;

import java.util.List;

public class GarSummaryPageSteps
{

    GarSummaryPage garSummaryPage;
    WebUtils webUtils;

    public GarSummaryPageSteps(WebUtils webUtils,GarSummaryPage garSummaryPage)
    {   this.webUtils = webUtils;
        this.garSummaryPage = garSummaryPage;
    }

    @Then("^user finds below list of fields present on the page$")
    public void user_finds_below_list_of_fields_present_on_the_page(List<String> expTableColumns)
    {

    }

    @Then("^user finds details related to \"([^\"]*)\" and others similer feilds$")
    public void user_finds_details_related_to_and_others_similer_feilds(String fieldName)
    {
        Assert.assertTrue(garSummaryPage.verifyIfFieldsAreVisible(fieldName));
    }

    @Then("^I check on GAR summary page if \"([^\"]*)\" feild asking user \"([^\"]*)\" on/of flight \"([^\"]*)\"$")
    public void i_check_on_GAR_summary_page_if_is_showing_as(String summaryFieldName, String summaryFieldInfo, String summaryFieldData)
    {
        garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt(summaryFieldName,summaryFieldInfo,summaryFieldData);
    }

}
