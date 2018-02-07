package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.*;

public class CommonSteps
{

    WebUtils webUtils;
    CommonUtils commonUtils;
    GarAirCraftPage garAirCraftPage;
    GarStartPage garStartPage;
    GarDeparturePage garDeparturePage;
    GarSignInPage garSignInPage;
    GarFullJourneyPage garFullJourneyPage;

    public CommonSteps(GarStartPage garStartPage,GarAirCraftPage garAirCraftPage, WebUtils webUtils,CommonUtils commonUtils, GarDeparturePage garDeparturePage, GarSignInPage garSignInPage, GarFullJourneyPage garFullJourneyPage)
    {
        this.webUtils = webUtils;
        this.garAirCraftPage = garAirCraftPage;
        this.garStartPage = garStartPage;
        this.garDeparturePage = garDeparturePage;
        this.commonUtils = commonUtils;
        this.garSignInPage = garSignInPage;
        this.garFullJourneyPage = garFullJourneyPage;
    }

    @Given("^I navigate to \"([^\"]*)\" page$")
    public void i_navigate_to_page(String navitating_to_page)
    {
        commonUtils.navigate_to_requested_page(navitating_to_page);
    }

    @Then("^I should successfully land on \"([^\"]*)\" page$")
    public void i_should_successfully_land_on_page(String page_name)
    {
        Assert.assertTrue(garStartPage.user_is_on_page(page_name));
    }

    @Then("^I should be able to select \"([^\"]*)\" from dropdown list$")
    public void i_should_be_able_to_select_from_dropdown_list(String drop_down_list_box)
    {
       Assert.assertTrue("I am able to select options --> ",commonUtils.select_required_option_from_dropdown_list(drop_down_list_box));
    }

    @Then("^I should confirm checkbox$")
    public void i_should_confirm_checkbox()
    {
        commonUtils.click_checkBox();
    }

    @Then("^I should see Instructions \"([^\"]*)\"$")
    public void i_should_see_Instructions(String seen_text)
    {
        commonUtils.visible_text_on_the_page(seen_text);
    }

    @And("^I should see link \"([^\"]*)\"$")
    public void i_should_see_link(String link_name)
    {
       if (link_name.equalsIgnoreCase("Resend Email.")||link_name.equalsIgnoreCase("Sign out"))

       {
         Assert.assertTrue(commonUtils.visible_anchor_link_on_the_page(link_name));  ;
       }
       else
           Assert.assertTrue(commonUtils.visible_buttons_on_the_page(link_name));

    }

    @And("^I click a link \"([^\"]*)\"$")
    public void i_click_a_link(String click_link)
    {
        Assert.assertTrue("The Link is now clicked --> ",commonUtils.click_visible_link_on_page(click_link));
    }

    @And("^I now click anchor link \"([^\"]*)\" on page$")
    public void i_now_click_anchor_link_on_page(String anchor_link) throws Throwable
    {
        if(anchor_link.equalsIgnoreCase("Sign out")||anchor_link.equalsIgnoreCase("My details")||anchor_link.equalsIgnoreCase("Create an account for GAR submissions"))
        {
          Assert.assertTrue(commonUtils.click_anchor_link_on_the_page(anchor_link));
        }
        else
        Assert.assertTrue(commonUtils.click_button_on_the_page(anchor_link));
    }

    @And("^I see them as \"([^\"]*)\"$")
    public void i_see_them_as(String text_on_page)
    {
        commonUtils.visible_text_on_the_page(text_on_page);
    }

    @Then("^I should be able to see error message \"([^\"]*)\"$")
    public void i_should_be_able_to_see_error_message(String error_message)
    {
        commonUtils.visible_text_on_the_page(error_message);
    }

    @Then("^I close the page$")
    public void i_close_the_page() throws Throwable
    {
        commonUtils.close_second_browser_tab();
    }

    @Given("^\"([^\"]*)\" user logs in with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_logs_in_with_username_as_and_password_as(String usertype, String email_address, String password)
    {
        commonUtils.type_of_user_logs_in(usertype,email_address,password);
    }

    @And("^I navigate \"([^\"]*)\"$")
    public void i_navigate(String navigation_function)
    {
        commonUtils.navigate_as_per_choice(navigation_function);
    }

    @Then("^I should not see \"([^\"]*)\" anchor link on top$")
    public void i_should_not_see_anchor_link_on_top(String anchor_link)
    {
        Assert.assertFalse("The status is --> ",commonUtils.visible_anchor_link_on_the_page(anchor_link));
    }

    @Then("^user lands on \"([^\"]*)\" and fills all valid details$")
    public void user_lands_on_and_fills_all_valid_details(String page_name)
    {
        garFullJourneyPage.enter_details_on_the_requested_page(page_name);
    }

    @Then("^I should be able to view \"([^\"]*)\" success message$")
    public void i_should_be_able_to_view_success_message(String success_message)
    {
        garFullJourneyPage.success_message_status(success_message);
    }
}
