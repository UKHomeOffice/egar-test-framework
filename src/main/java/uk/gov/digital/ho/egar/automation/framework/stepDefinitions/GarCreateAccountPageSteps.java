package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.omg.CORBA.TIMEOUT;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarAirCraftPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarCreateAccountPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GarCreateAccountPageSteps
{
    WebUtils webUtils;
    GarAirCraftPage garAirCraftPage;
    GarCreateAccountPage garCreateAccountPage;
    public GarCreateAccountPageSteps(GarAirCraftPage garAirCraftPage, WebUtils webUtils, GarCreateAccountPage garCreateAccountPage)
    {
       this.garAirCraftPage = garAirCraftPage;
       this.webUtils = webUtils;
       this.garCreateAccountPage = garCreateAccountPage;
    }

    @Then("^in \"([^\"]*)\" field I enter \"([^\"]*)\" \"([^\"]*)\"$")
    public void in_field_I_enter(String field_name, String randomEmail, String feild_attri)
    {
        Random random = new Random();
        garAirCraftPage.enter_text_in_the_mentioned_field(field_name,randomEmail+random.nextInt()+"@dev.egarteam.co.uk", feild_attri);

    }

    @When("^\"([^\"]*)\" conditions$")
    public void i_agree_conditions(String option_name)
    {
        garCreateAccountPage.choose_option(option_name);
    }

    @Given("^user logs in \"([^\"]*)\" email$")
    public void user_logs_in_email(String url)
    {
       webUtils.getDriver().get(url);
       webUtils.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^user clicks email in inbox$")
    public void user_clicks_email_in_inbox()
    {
        garCreateAccountPage.user_clicks_email_in_inbox();
    }

    @Then("^I should see email with title \"([^\"]*)\"$")
    public void i_should_see_email_with_title(String email_title)
    {
        webUtils.waitForSeconds(2);
        garCreateAccountPage.check_email_title(email_title);
    }

    @When("^I click verification link$")
    public void i_click_verification_link() throws InterruptedException {
    garCreateAccountPage.click_email_verification_link();
    }
}
