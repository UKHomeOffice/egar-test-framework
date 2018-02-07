package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.When;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarAirCraftPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarCreateAccountPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarSignInPage;

public class GarSingInPageSteps
{
    WebUtils webUtils;
    GarSignInPage garSignInPage;

    public GarSingInPageSteps(WebUtils webUtils, GarSignInPage garSignInPage)
    {
        this.webUtils = webUtils;
        this.garSignInPage = garSignInPage;
    }

    @When("^I see \"([^\"]*)\" field then I enter \"([^\"]*)\" as \"([^\"]*)\"$")
    public void i_see_field_then_I_enter_as(String field_name, String enter_text, String feild_attri)
    {
        garSignInPage.enter_field_details(field_name, enter_text,feild_attri);
    }
}
