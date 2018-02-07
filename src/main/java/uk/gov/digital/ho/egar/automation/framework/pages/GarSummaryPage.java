package uk.gov.digital.ho.egar.automation.framework.pages;

import org.junit.Assert;import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.util.List;

public class GarSummaryPage
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GarSummaryPage.class);
    WebUtils webUtils;

    public GarSummaryPage(WebUtils webUtils)
    {
        this.webUtils=webUtils;
        PageFactory.initElements(webUtils.getDriver(), this);

    }


    @FindBy(css = "div[class='summary-field-name']")
    List<WebElement> suumary_page_fields;

    @FindBy(css= "div[class='summary-row'] div[class='summary-field-info']")
    List<WebElement> summary_field_info_entered_by_user;

    @FindBy(css= "div[class='summary-row'] div[class='summary-field-data']")
    List<WebElement> summary_field_data_entered_by_user;

    @FindBy(css = "div[class='summary-data'] span")
    List<WebElement> summary_info_link;

    public boolean verifyIfFieldsAreVisible(String visibleFieldName) {
        boolean filters = false;

        for (WebElement summaryField : suumary_page_fields) {
            if (summaryField.getText().trim().contains(visibleFieldName)) {
                LOGGER.info("The summary field visible is -->" + summaryField.getText());
                filters = true;
                break;
            }
        }
        return filters;
    }

    public void click_related_link_on_summary_page()
    {
        if (summary_info_link.size()>=1)
        {
            for (WebElement info_link:summary_info_link)
            {
                if (info_link.getText().trim().contains("Captain")||info_link.getText().trim().contains("Crew")||info_link.getText().trim().contains("Passengers"))
                {
                    if (verifyIfFieldsDataVisible("Captain")||verifyIfFieldsDataVisible("Crew")|| verifyIfFieldsDataVisible("Passenger"))
                    info_link.click();
                    LOGGER.info("I have clicked --> " + info_link.getText());
                    break;
                }
            }
        }
    }

    public boolean verifyIfFieldsInfoVisible(String visibleFieldInfo) {
        boolean filters = false;

        for (WebElement summaryFieldInfo : summary_field_info_entered_by_user) {
            if (summaryFieldInfo.getText().trim().contains(visibleFieldInfo)) {
                LOGGER.info("The summary field visible is -->" + summaryFieldInfo.getText());
                filters = true;
                break;
            }
        }
        return filters;
    }

    public boolean verifyIfFieldsDataVisible(String visibleFieldData) {
        boolean filters = false;

        for (WebElement summaryFieldData : summary_field_data_entered_by_user)
        {
            if (summaryFieldData.getText().trim().contains(visibleFieldData))
            {
                LOGGER.info("The summary field visible is -->" + summaryFieldData.getText());
                filters = true;
                break;
            }
        }
        return filters;
    }


    public void checkIfSummaryFieldHasSummaryDataInIt(String field_name,String field_info ,String data_entered)
    {
        Assert.assertTrue(verifyIfFieldsAreVisible(field_name));

        if (verifyIfFieldsDataVisible("Captain")||verifyIfFieldsDataVisible("Crew")||verifyIfFieldsDataVisible("Passengers"))
            {
                click_related_link_on_summary_page();
                Assert.assertTrue(verifyIfFieldsInfoVisible(field_info));
            }
        else
            {
                Assert.assertTrue(verifyIfFieldsInfoVisible(field_info));
            }
        Assert.assertTrue(verifyIfFieldsDataVisible(data_entered));
    }

}
