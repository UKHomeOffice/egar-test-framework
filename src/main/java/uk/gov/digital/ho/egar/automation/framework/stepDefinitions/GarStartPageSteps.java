package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarStartPage;

import java.util.List;

public class GarStartPageSteps {
    WebUtils webUtils;
    GarStartPage garStartPage;


    public GarStartPageSteps(GarStartPage garStartPage, WebUtils webUtils)
    {
        this.garStartPage = garStartPage;
        this.webUtils = webUtils;
    }

    @Given("^user is on \"([^\"]*)\" page$")
    public void userIsOnPage(String page_name) throws Throwable
    {
        webUtils.visitPage(webUtils.getValueFromProperties("baseUrl") + page_name);
    }

    @When("^I land on the page, I should see a link indicating \"([^\"]*)\"$")
    public void iLandOnThePageIShouldSeeALinkIndicating(String link_available) throws Throwable
    {
        Assert.assertTrue(garStartPage.check_if_link_visible_to_user(link_available));
    }


    @When("^I should see Instructions \"([^\"]*)\" like to how to apply for GAR registration$")
    public void i_should_see_Instructions_like_to_how_to_apply_for_GAR_registration(String instructions) throws Throwable
    {
        Assert.assertTrue(garStartPage.check_instructions_present_for_users(instructions));
    }


    @Then("^I should see \"([^\"]*)\" button which will redirect me to \"([^\"]*)\"$")
    public void i_should_see_button_which_will_redirect_me_to(String button, String page_name) throws Throwable
    {
        Assert.assertTrue(garStartPage.visible_buttons(button));
    }

    @Then("^I should also see \"([^\"]*)\" like \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_should_also_see(String header2, String visible_text1, String visible_text2) throws Throwable
    {
        garStartPage.visible_alternate_options_to_users(header2, visible_text1, visible_text2);
    }
}
