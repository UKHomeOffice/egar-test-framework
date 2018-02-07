package uk.gov.digital.ho.egar.automation.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.util.List;

public class GarDeparturePage
{

    private static final Logger LOGGER = LoggerFactory.getLogger(GarDeparturePage.class);
    WebUtils webUtils;

    public GarDeparturePage(WebUtils utils)
    {
        webUtils = utils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(css ="span")
    List<WebElement> list_of_subject_title;

    @FindBy(css ="span")
    WebElement single_subject_title_on_page;

    @FindBy(css = "label")
    List<WebElement> multiple_dropdown_list_titles_on_page;

    @FindBy(css = "label")
    private WebElement single_dropdown_list_title_on_page;

    public boolean title_seen_by_user(String title)
    {
        boolean visible_title = false;

        if (list_of_subject_title.size()>1)
        {
            for (WebElement seen_title:list_of_subject_title)
            {
                if (seen_title.getText().trim().equalsIgnoreCase(title))
                {
                    LOGGER.info("The seen title"+seen_title.getText().trim());
                    visible_title = true;
                    break;
                }
            }
        }
        else
        {
            if (single_subject_title_on_page.getText().trim().equalsIgnoreCase(title))
            {
                LOGGER.info("The visible subject title is--> "+single_subject_title_on_page.getText().trim());
                visible_title = true;
            }
        }
        return visible_title;
    }

    public boolean dropdown_title_seen_by_user(String title)
    {
        boolean visible_title = false;

        if (multiple_dropdown_list_titles_on_page.size()>1)
        {
            for (WebElement seen_title:multiple_dropdown_list_titles_on_page)
            {
                if (seen_title.getText().trim().equalsIgnoreCase(title))
                {
                    LOGGER.info("The seen title"+seen_title.getText().trim());
                    visible_title = true;
                    break;
                }
            }
        }
        else
        {
            if (single_dropdown_list_title_on_page.getText().trim().equalsIgnoreCase(title))
            {
                LOGGER.info("The visible subject title is--> "+single_dropdown_list_title_on_page.getText().trim());
                visible_title = true;
            }
        }
        return visible_title;
    }
}
