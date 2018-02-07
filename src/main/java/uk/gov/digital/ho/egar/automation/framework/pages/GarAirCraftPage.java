package uk.gov.digital.ho.egar.automation.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.DriverUtils;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.util.List;

public class GarAirCraftPage extends DriverUtils
{

    private static final Logger LOGGER = LoggerFactory.getLogger(GarAirCraftPage.class);
    WebUtils webUtils;

    public GarAirCraftPage(WebUtils utils)
    {
        webUtils = utils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(css = "label")
    List<WebElement> fields_or_radio_buttons_title;

    @FindBy(css = "label")
    private WebElement single_field_or_radio_button_title;

    @FindBy(css = "input[type='text']")
    List<WebElement> empty_feilds_on_the_page;

    @FindBy(css = "input[type='text']")
    private WebElement single_empty_field_on_the_page;

    @FindBy(css = "label[class='block-label']")
    List<WebElement> multiple_radio_buttons;

    @FindBy(css = "label[class='block-label']")
    private WebElement single_radio_button;

    public boolean check_the_title_of_field_or_radioButton(String name_of_field_or_rbutton)
    {
        boolean result = false;

        if (fields_or_radio_buttons_title.size()>1)
        {
            for (WebElement typeOfFieldOrRbutton:fields_or_radio_buttons_title)
            {
                if (typeOfFieldOrRbutton.getText().trim().contains(name_of_field_or_rbutton))
                {
                    LOGGER.info("The feild or Radio Button Name is -->" + typeOfFieldOrRbutton.getText().trim());
                    result = true;
                    break;
                }
            }

        }else
        {
            if (single_field_or_radio_button_title.getText().trim().contains(name_of_field_or_rbutton))
            {
              result = true;
            }
        }
        return result;
    }


    public boolean enter_text_in_feild_or_select_selectRButton(String attri_name, String  text_or_choice_made)
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

    public void enter_text_in_the_mentioned_field(String field_name, String enter_text, String feild_attri)
    {
        Assert.assertTrue(check_the_title_of_field_or_radioButton(field_name));
        Assert.assertTrue(enter_text_in_feild_or_select_selectRButton(feild_attri,enter_text));

    }

    public void check_if_yes_Or_no_options_visible(String possitive, String negative)
    {
        Assert.assertTrue(check_the_title_of_field_or_radioButton(possitive));
        Assert.assertTrue(check_the_title_of_field_or_radioButton(negative));
    }


    public void choose_checkbox_options(String option_to_choose)
    {
        if (multiple_radio_buttons.size()>1)
        {
            for (WebElement radio_button:multiple_radio_buttons)
            {
                if (radio_button.getText().trim().contains(option_to_choose))
                  {
                    radio_button.click();
                    break;
                  }
             }
        }
        else
        {
          if (single_radio_button.getText().trim().contains(option_to_choose))
          {
              single_radio_button.click();
          }
        }
    }

}