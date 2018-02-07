package uk.gov.digital.ho.egar.automation.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.util.List;

public class GarSignInPage
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GarSignInPage.class);
    WebUtils webUtils;
    public GarSignInPage(WebUtils utils)
    {
        webUtils = utils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(css = "label")
    List<WebElement> fields_title;

    @FindBy(css = "label")
    private WebElement single_field_title;

    @FindBy(css = "input[type]")
    List<WebElement> empty_feilds_on_the_page;

    @FindBy(css = "input[type]")
    private WebElement single_empty_field_on_the_page;

    public boolean check_the_title_of_field(String name_of_field_or_rbutton)
    {
        boolean result = false;

        if (fields_title.size()>1)
        {
            for (WebElement typeOfFieldOrRbutton:fields_title)
            {
                if (typeOfFieldOrRbutton.getText().trim().contains(name_of_field_or_rbutton))
                {
                    LOGGER.info("The feild name is -->" + typeOfFieldOrRbutton.getText().trim());
                    result = true;
                    break;
                }
            }

        }else
        {
            if (single_field_title.getText().trim().contains(name_of_field_or_rbutton))
            {
                result = true;
            }
        }
        return result;
    }

    public boolean enter_text_in_feild(String attri_name, String  text_or_choice_made)
    {
        boolean result = true;
        if (empty_feilds_on_the_page.size()>1)
        {
            for (WebElement field_to_enter_text:empty_feilds_on_the_page)
            {
                if (field_to_enter_text.getAttribute("name").contains(attri_name))
                {
                    webUtils.fillTextField(field_to_enter_text,text_or_choice_made);
                    result = true;
                    break;
                }
            }

        }else
        {
            if (single_empty_field_on_the_page.getAttribute("id").contains(attri_name))
            {
                webUtils.fillTextField(single_empty_field_on_the_page, text_or_choice_made);
                result = true;
            }
        }
        return result;
    }


    public void enter_field_details(String field_name, String enter_text, String feild_attri)
    {
        Assert.assertTrue(check_the_title_of_field(field_name));
        Assert.assertTrue(enter_text_in_feild(feild_attri,enter_text));

    }

}
