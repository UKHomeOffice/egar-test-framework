package uk.gov.digital.ho.egar.automation.framework.stepDefinitions;

import cucumber.api.java.en.Then;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import uk.gov.digital.ho.egar.automation.framework.pages.GarSummaryPage;
import uk.gov.digital.ho.egar.automation.framework.pages.GarUploadDocPage;

import java.awt.*;

public class GARUploadDocSteps
{
    GarUploadDocPage garUploadDocPage;
    WebUtils webUtils;

    public GARUploadDocSteps(WebUtils webUtils, GarUploadDocPage garUploadDocPage)
    {   this.webUtils = webUtils;
        this.garUploadDocPage = garUploadDocPage;
    }

    @Then("^I upload a single file \"([^\"]*)\"$")
    public void i_upload_a_single_file(String fileName) throws AWTException
    {
        garUploadDocPage.uploadFile(fileName);
    }

    @Then("^I upload a another file \"([^\"]*)\"$")
    public void i_upload_a_another_file(String fileName) throws AWTException
    {
        garUploadDocPage.uploadFile(fileName);
    }
}
