package uk.gov.digital.ho.egar.automation.framework.pages;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.DriverUtils;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.util.List;

public class GarPeoplePage extends DriverUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GarPeoplePage.class);
    WebUtils webUtils;
    CommonUtils commonUtils;
    GarAirCraftPage garAirCraftPage;

    public GarPeoplePage (WebUtils utils, CommonUtils commonUtils, GarAirCraftPage garAirCraftPage)
    {
        webUtils = utils;
        this.commonUtils = commonUtils;
        this.garAirCraftPage=garAirCraftPage;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(css = "input[type='radio']")
    List<WebElement> count_of_radio_buttons;

    @FindBy(css = "input[type='submit'")
    WebElement button_name_on_page;

    @FindBy(css = "tbody th")
    List<WebElement> table_title;

    @FindBy(css="tbody tr td")
    List<WebElement> table_content;

    @FindBy(css="tbody tr td")
    private WebElement single_table_content;

    public boolean number_of_radio_button(int no_of_count)
    {
        boolean numbers = false;

        if (count_of_radio_buttons.size()==no_of_count)
            {
                LOGGER.info("The total count is " + count_of_radio_buttons.size());
                numbers = true;
            }
        return numbers;
    }

    public void click_button_on_people_page(String name_of_button)
    {
        if (button_name_on_page.getAttribute("value").trim().contains(name_of_button))
        {
            button_name_on_page.click();
        }
    }

    public boolean enter_text_in_relavent_fields(List<String> fieldsNames)
    {
        boolean fields = false;

        for (String fieldlabel:fieldsNames)
        {
            switch (fieldlabel.toLowerCase())
            {
                case "given name(s)":
                    garAirCraftPage.enter_text_in_the_mentioned_field(fieldlabel, fieldlabel, fieldlabel);
            }
        }

        return fields;
    }

    public boolean is_table_category_visible(String name_of_table_category)
    {
        boolean category =false;

        for (WebElement specific_category:table_title)
        {
            if (specific_category.getText().trim().equalsIgnoreCase(name_of_table_category))
            {
                LOGGER.info("I can see column title as --> " + specific_category.getText());
                category = true;
                break;
            }
        }
        return category;
    }

    public boolean is_person_added(String type_of_person)
    {
        boolean person = false;

        if (table_content.size()>1)
        {
            for (WebElement visible_person : table_content)
            {
                if (visible_person.getText().trim().equalsIgnoreCase(type_of_person))
                {
                    LOGGER.info("The visible person is --> " + visible_person.getText());
                    person = true;
                    break;

                }
            }
        }else
        {
           if (single_table_content.getText().trim().equalsIgnoreCase(type_of_person))
           {
               LOGGER.info("The Visible person is --> " + single_table_content.getText());
               person = true;
           }
        }
        return person;
    }




    public void check_if_person_is_added_or_not(String typeOfTitle, String typeOfPerson)
    {
        Assert.assertTrue(is_table_category_visible(typeOfTitle));
        Assert.assertTrue(is_person_added(typeOfPerson));
    }


}
