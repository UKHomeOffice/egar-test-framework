package uk.gov.digital.ho.egar.automation.framework.pages;

import org.junit.Assert;import org.openqa.selenium.WebElement;import org.openqa.selenium.support.FindBy;import org.openqa.selenium.support.PageFactory;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import uk.gov.digital.ho.egar.automation.framework.WebUtils;import java.util.List;public class GarFullJourneyPage
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GarFullJourneyPage.class);
    WebUtils webUtils;
    CommonUtils commonUtils;
    GarAirCraftPage garAirCraftPage;
    GarCreateAccountPage garCreateAccountPage;
    GarDeparturePage garDeparturePage;
    GarStartPage garStartPage;
    GarSummaryPage garSummaryPage;

    public GarFullJourneyPage(WebUtils utils, CommonUtils commonUtils, GarAirCraftPage garAirCraftPage, GarCreateAccountPage garCreateAccountPage, GarDeparturePage garDeparturePage, GarStartPage garStartPage, GarSummaryPage garSummaryPage)
    {
        webUtils = utils;
        this.commonUtils = commonUtils;
        this.garAirCraftPage = garAirCraftPage;
        this.garCreateAccountPage = garCreateAccountPage;
        this.garDeparturePage = garDeparturePage;
        this.garStartPage = garStartPage;
        this.garSummaryPage=garSummaryPage;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(css = "h1")
    List<WebElement> multipleHeadersOnThePage;

    public void enter_details_on_the_requested_page(String pageName)
    {
        switch (pageName.toLowerCase())
        {
            case "aircraft details":
            {
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garAirCraftPage.enter_text_in_the_mentioned_field("Aircraft registration", "eGAR", "aircraft-registration");
                garAirCraftPage.enter_text_in_the_mentioned_field("Type of aircraft", "TESTING BOEING 777", "aircraft-type");
                garAirCraftPage.enter_text_in_the_mentioned_field("Usual base of aircraft", "TEST LONDON HEATHROW", "aircraft-base");
                garAirCraftPage.choose_checkbox_options("Yes");
                garStartPage.click_buttons("Save and continue");
                break;
            }

            case "departure details":
            {
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "31", "departure-date-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "12", "departure-date-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "2018", "departure-date-year");
                garAirCraftPage.enter_text_in_the_mentioned_field("Hour", "23", "departure-time-hour");
                garAirCraftPage.enter_text_in_the_mentioned_field("Minute", "59", "departure-time-minute");
                garAirCraftPage.enter_text_in_the_mentioned_field("Departure ICAO", "HAAB", "icao-autocomplete");
                garStartPage.click_buttons("Save and continue");
                break;
            }
            case "arrival details":
            {
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "01", "arrival-date-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "01", "arrival-date-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "2019", "arrival-date-year");
                garAirCraftPage.enter_text_in_the_mentioned_field("Hour", "06", "arrival-time-hour");
                garAirCraftPage.enter_text_in_the_mentioned_field("Minute", "59", "arrival-time-minute");
                garAirCraftPage.enter_text_in_the_mentioned_field("Arrival ICAO", "HAAL", "icao-autocomplete");
                garStartPage.click_buttons("Save and continue");
                break;
            }
            case "are there any hazardous or prohibited goods on board?":
            {
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garAirCraftPage.choose_checkbox_options("Yes");
                garStartPage.click_buttons("Save and continue");
                break;
            }
            case "adding captain, crew and passengers":
            {
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garStartPage.click_buttons("Add new");
                Assert.assertTrue(garStartPage.user_is_on_page("Select the type of person you wish to add to this flight"));
                garAirCraftPage.choose_checkbox_options("Captain");
                garStartPage.click_buttons("Save and continue");
                Assert.assertTrue(garStartPage.user_is_on_page("Information about the captain"));
                garAirCraftPage.enter_text_in_the_mentioned_field("Given name(s)", "Flight", "given-name");
                garAirCraftPage.enter_text_in_the_mentioned_field("Family Name", "Captain", "family-name");
                garAirCraftPage.choose_checkbox_options("Male");
                garAirCraftPage.enter_text_in_the_mentioned_field("UK home address or address visiting in UK", "1 Bank Road, London HC1 1CH", "uk-address");
                garStartPage.click_buttons("Save and continue");
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "01", "dob-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "01", "dob-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "1990", "dob-year");
                garAirCraftPage.enter_text_in_the_mentioned_field("Place of birth", "Alaska", "birth-place");
                Assert.assertTrue("I am able to select options --> ",commonUtils.select_required_option_from_dropdown_list("Algeria"));
                garStartPage.click_buttons("Save and continue");
                garAirCraftPage.choose_checkbox_options("Passport");
                garAirCraftPage.enter_text_in_the_mentioned_field("Travel document number (if available)", "ALGE12345RIA", "document-number");
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "31", "expiry-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "12", "expiry-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "2019", "expiry-year");
                Assert.assertTrue("I am able to select options --> ",commonUtils.select_required_option_from_dropdown_list("Algeria"));
                garStartPage.click_buttons("Save and continue");
                Assert.assertTrue(garStartPage.user_is_on_page("Please specify who is responsible for goods and people on this flight?"));
                garAirCraftPage.choose_checkbox_options("Captain");
                garStartPage.click_buttons("Save and continue");

                //user adding crew on the flight
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garStartPage.click_buttons("Add new");
                Assert.assertTrue(garStartPage.user_is_on_page("Select the type of person you wish to add to this flight"));
                garAirCraftPage.choose_checkbox_options("Crew");
                garStartPage.click_buttons("Save and continue");
                Assert.assertTrue(garStartPage.user_is_on_page("Information about the crew"));
                garAirCraftPage.enter_text_in_the_mentioned_field("Given name(s)", "Flight", "given-name");
                garAirCraftPage.enter_text_in_the_mentioned_field("Family Name", "Crew", "family-name");
                garAirCraftPage.choose_checkbox_options("Female");
                garAirCraftPage.enter_text_in_the_mentioned_field("UK home address or address visiting in UK", "2 Bank Road, London HC2 2CH", "uk-address");
                garStartPage.click_buttons("Save and continue");
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "02", "dob-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "02", "dob-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "1990", "dob-year");
                garAirCraftPage.enter_text_in_the_mentioned_field("Place of birth", "Afghanistan", "birth-place");
                Assert.assertTrue("I am able to select options --> ",commonUtils.select_required_option_from_dropdown_list("Afghanistan"));
                garStartPage.click_buttons("Save and continue");
                garAirCraftPage.choose_checkbox_options("Identity Card");
                garAirCraftPage.enter_text_in_the_mentioned_field("Travel document number (if available)", "AFGA12345NISTHAN", "document-number");
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "30", "expiry-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "12", "expiry-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "2019", "expiry-year");
                Assert.assertTrue("I am able to select options --> ",commonUtils.select_required_option_from_dropdown_list("Afghanistan"));
                garStartPage.click_buttons("Save and continue");

                //user adding passenger on flight
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garStartPage.click_buttons("Add new");
                Assert.assertTrue(garStartPage.user_is_on_page("Select the type of person you wish to add to this flight"));
                garAirCraftPage.choose_checkbox_options("Passenger");
                garStartPage.click_buttons("Save and continue");
                Assert.assertTrue(garStartPage.user_is_on_page("Information about the passenger"));
                garAirCraftPage.enter_text_in_the_mentioned_field("Given name(s)", "Flight", "given-name");
                garAirCraftPage.enter_text_in_the_mentioned_field("Family Name", "Passenger", "family-name");
                garAirCraftPage.choose_checkbox_options("Unspecified");
                garAirCraftPage.enter_text_in_the_mentioned_field("UK home address or address visiting in UK", "3 Bank Road, London HC3 3CH", "uk-address");
                garStartPage.click_buttons("Save and continue");
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "03", "dob-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "03", "dob-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "1990", "dob-year");
                garAirCraftPage.enter_text_in_the_mentioned_field("Place of birth", "Antarctica", "birth-place");
                Assert.assertTrue("I am able to select options --> ",commonUtils.select_required_option_from_dropdown_list("Antarctica"));
                garStartPage.click_buttons("Save and continue");
                garAirCraftPage.choose_checkbox_options("Unspecified");
                garAirCraftPage.enter_text_in_the_mentioned_field("Travel document number (if available)", "ANTAR12345TICA", "document-number");
                garAirCraftPage.enter_text_in_the_mentioned_field("Day", "29", "expiry-day");
                garAirCraftPage.enter_text_in_the_mentioned_field("Month", "12", "expiry-month");
                garAirCraftPage.enter_text_in_the_mentioned_field("Year", "2019", "expiry-year");
                Assert.assertTrue("I am able to select options --> ",commonUtils.select_required_option_from_dropdown_list("Antarctica"));
                garStartPage.click_buttons("Save and continue");
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                garStartPage.click_buttons("Save and continue");
                break;
            }

            case "would you like to add any supporting files to accompany your gar submission?":
             {
                 Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                 garAirCraftPage.choose_checkbox_options("No");
                 garStartPage.click_buttons("Save and continue");
                 break;
             }
            case "gar summary":
            {
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                //user checking Aircraft Details on summary page
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Aircraft details","Aircraft Registration:","eGAR");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Aircraft details","Type of Aircraft:","TESTING BOEING 777");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Aircraft details","Usual base of aircraft:","TEST LONDON HEATHROW");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Aircraft details","Have all taxes due on the aircraft been paid and accounted for within the UK?","Yes");

                //user checking Departure details on summary page
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Departure details","Date of departure:","31 12 2018");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Departure details","Time of departure:","23 59");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Departure details","Departure location:","HAAB");

                //user checking Arrival Details on summary page
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Arrival details","Date of arrival:","01 01 2019");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Arrival details","Time of arrival:","06 59");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Arrival details","Arrival location:","HAAL");

                //user checking declaration of hazardous goods
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Hazardous goods","Are there any dangerous or hazardous goods on board?","Yes");

                //user checking captain details
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Given names(s)","Flight");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Family name:","Captain");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Gender:","Male");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","UK home address:","1 Bank Road, London HC1 1CH");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Date of birth:","01 01 1990");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Place of birth:","Alaska");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Country of nationality:","Algeria");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Travel document type:","passport");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Travel document number:","ALGE12345RIA");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Travel document expiry date:","31 12 2019");
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Travel document issuing country:","Algeria");

                //user checking responsible person on flight
                garSummaryPage.checkIfSummaryFieldHasSummaryDataInIt("Captain details","Responsible person:","Captain");
                garStartPage.click_buttons("Save and continue");
                break;
            }
            case "submit gar":
            {
                Assert.assertTrue(garStartPage.user_is_on_page(pageName));
                Assert.assertTrue(garSummaryPage.verifyIfFieldsAreVisible("GAR Reference:"));
                garStartPage.click_buttons("Submit GAR");
                break;
            }

        }

    }

    public boolean success_message_status(String success_message)
    {
        boolean message = false;

        for (WebElement header:multipleHeadersOnThePage)
        {
            if (header.getText().trim().equalsIgnoreCase(success_message))
            {
                webUtils.waitUntilElementIsVisible(header);
                LOGGER.info("I am able to confirm that " + header.getText()+"ed");
                message = true;
            }
        }


        return message;
    }
}
