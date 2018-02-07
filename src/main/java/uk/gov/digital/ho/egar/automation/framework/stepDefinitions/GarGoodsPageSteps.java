package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.And;
import org.junit.Assert;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.CommonUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarAirCraftPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarGoodsPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarStartPage;

public class GarGoodsPageSteps
{
    WebUtils webUtils;
    GarAirCraftPage garAirCraftPage;
    GarStartPage garStartPage;
    GarGoodsPage garGoodsPage;
    CommonUtils commonUtils;

    public GarGoodsPageSteps(GarGoodsPage garGoodsPage,GarStartPage garStartPage,GarAirCraftPage garAirCraftPage, WebUtils webUtils, CommonUtils commonUtils)
    {
        this.webUtils = webUtils;
        this.garAirCraftPage = garAirCraftPage;
        this.garStartPage = garStartPage;
        this.garGoodsPage = garGoodsPage;
        this.commonUtils = commonUtils;
    }



    @And("^I can also see radio buttons \"([^\"]*)\" or \"([^\"]*)\"$")
    public void i_can_also_see_radio_buttons_or(String possitive, String negative) throws Throwable
    {
        garAirCraftPage.check_if_yes_Or_no_options_visible(possitive,negative);
    }

}
