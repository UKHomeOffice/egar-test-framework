package uk.gov.digital.ho.egar.automation.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(GarDeparturePage.class);
    WebUtils webUtils;

    public CommonUtils(WebUtils utils)
    {
        webUtils = utils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(css = "input[class*='autocomplete__input--show-all-values']")
    private WebElement dropdown_list_box;

    @FindBy(css = "ul[class*='autocomplete__menu'] li")
    List<WebElement> dropDown_menu_list;

    @FindBy(css = "input[type='submit']")
    List<WebElement> multiple_buttons_on_the_page;

    @FindBy(css = "input[type='submit']")
    WebElement single_button_on_the_page;

    @FindBy(css = "input[type='checkbox']")
    List<WebElement> multiple_checkbox_on_page;

    @FindBy(css = "input[type='checkbox']")
    private WebElement single_checkbox_on_page;

    @FindBy(css = "h1")
    List<WebElement> multiple_page_headers;

    @FindBy(css = "h1")
    private WebElement page_header_name;

    @FindBy(css = "span")
    List<WebElement> links_on_the_page;

    @FindBy(css = "span")
    private WebElement single_link_on_page;

    @FindBy(css = "a[href]")
    List<WebElement> anchor_links_on_page;

    @FindBy(css = "label")
    List<WebElement> fields_title;

    @FindBy(css = "label")
    private WebElement single_field_title;

    @FindBy(css = "input[type]")
    List<WebElement> empty_feilds_on_the_page;

    @FindBy(css = "input[type]")
    private WebElement single_empty_field_on_the_page;

    @FindBy(css = "li p")
    private WebElement user_logged_in_as;

    @FindBy(css = "button")
    List<WebElement> button_with_button_tag;

    @FindBy(css = "input[type='submit']")
    WebElement only_button_on_page;



    public boolean select_required_option_from_dropdown_list(String name_of_dropdown_list)
    {
        boolean list = true;
        if (dropdown_list_box.isEnabled());
        {
            dropdown_list_box.click();
            dropdown_list_box.clear();
            if (dropDown_menu_list.size()!=0)
            {
                for (WebElement dd_choice:dropDown_menu_list)
                {
                    webUtils.waitUntilElementIsVisible(dd_choice);
                    if (dd_choice.getText().trim().contains(name_of_dropdown_list))
                    {
                        dd_choice.click();
                        break;
                    }
                }
                LOGGER.info("The Outline colour is --> " + dropdown_list_box.getCssValue("outline-color"));
                list = true;
            }
        }
        return list;
    }

    public void click_checkBox()
    {
        if (multiple_checkbox_on_page.size() > 1)
        {
            for (WebElement checkbox : multiple_checkbox_on_page)
            {
                if (checkbox.getAttribute("required").equals("true"))
                {
                    checkbox.click();
                    break;
                }
            }
        }
        else
        {
            if (single_checkbox_on_page.getAttribute("required").equals("true"))
            {
                single_checkbox_on_page.click();
            }
        }
    }

    public void visible_text_on_the_page(String text_instructions)
    {
        webUtils.getDriver().getPageSource().contains(text_instructions);
    }

    public boolean click_visible_link_on_page(String link_name)
    {
        boolean result = false;
        if (links_on_the_page.size()>=1)
        {
            for (WebElement link_to_be_clicked:links_on_the_page)
            {
                if (link_to_be_clicked.getText().trim().equalsIgnoreCase(link_name))
                {
                    webUtils.waitUntilElementIsClickable(link_to_be_clicked);
                    link_to_be_clicked.click();
                    result = true;
                    break;
                }
            }
        }
        else
            {
            if (single_link_on_page.getText().trim().equalsIgnoreCase(link_name))
            {
                webUtils.waitForSeconds(2);
                single_link_on_page.click();
                result = true;
            }
        }
        return result;
    }


    public void navigate_to_requested_page(String header1_page_title)
    {
        webUtils.waitForSeconds(1);
        while (!page_header_name.getText().equals(header1_page_title))
        {
            if (multiple_buttons_on_the_page.size()>=1)
            {
                for (WebElement choose_only_one:multiple_buttons_on_the_page)
                {
                    if (choose_only_one.getAttribute("value").trim().contains("Start now")||choose_only_one.getAttribute("value").trim().contains("Save and continue"))
                    {
                        choose_only_one.click();
                        break;
                    }
                }
            }
            else
            {
                single_button_on_the_page.click();
            }
        }
        LOGGER.info("I am on --> " + page_header_name.getText().equals(header1_page_title));
    }


    public boolean click_anchor_link_on_the_page(String name_of_the_anchor_link)
    {
        boolean anchor_link = false;
        for(WebElement a_link:anchor_links_on_page)
            {
                if (a_link.getText().trim().contains(name_of_the_anchor_link))
                    {
                        LOGGER.info("The "+ a_link.getText()+" anchor link is clicked");
                        webUtils.waitUntilElementIsClickable(a_link);
                        a_link.click();
                        anchor_link = true;
                        break;
                    }
            }
        return anchor_link;
    }


    public boolean click_button_on_the_page(String name_of_the_button)
    {
        boolean visible_button = false;
        for(WebElement button:button_with_button_tag)
        {
            if (button.getText().trim().contains(name_of_the_button))
            {
                LOGGER.info("The "+ button.getText()+" anchor link is clicked");
                webUtils.waitUntilElementIsClickable(button);
                button.click();
                visible_button = true;
                break;
            }
        }
        return visible_button;
    }

    public boolean visible_anchor_link_on_the_page(String name_of_the_anchor_link)
    {
        boolean anchor_link = false;
        for(WebElement a_link:anchor_links_on_page)
        {
            if (a_link.getText().trim().contains(name_of_the_anchor_link))
            {
                LOGGER.info("The "+ a_link.getText()+" anchor link is visible");
                anchor_link = true;
                break;
            }
        }
        return anchor_link;
    }

    public boolean visible_buttons_on_the_page(String name_of_the_button)
    {
        boolean button = false;
        for(WebElement a_button:button_with_button_tag)
        {
            if (a_button.getText().trim().contains(name_of_the_button))
            {
                LOGGER.info("The "+ a_button.getText()+" button is visible");
                button = true;
                break;
            }
        }
        return button;
    }

    public void close_second_browser_tab()
    {
        ArrayList<String> tabs2 = new ArrayList<String> (webUtils.getDriver().getWindowHandles());
        webUtils.getDriver().switchTo().window(tabs2.get(1));
        webUtils.getDriver().close();
        webUtils.getDriver().switchTo().window(tabs2.get(0));
    }

    public boolean check_the_title_of_the_required_field(String name_of_field_or_rbutton)
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

    public boolean enter_text_in_the_feild(String attri_name, String  text_or_choice_made)
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



    public void type_of_user_logs_in(String usertype, String email_address, String password)
    {

        switch (usertype.toLowerCase())
        {
            case "public":

                webUtils.click_button(single_button_on_the_page);

                if (isLoggedIn())
                    {
                        click_anchor_link_on_the_page("Sign out");
                        webUtils.visitPage(webUtils.getValueFromProperties("baseUrl") + "/welcome");
                        only_button_on_page.click();
                    }

                click_visible_link_on_page("Sign in with your email and password");

                if (check_the_title_of_the_required_field("Email address"));
                    {
                        enter_text_in_the_feild("username", email_address);
                    }
                if (check_the_title_of_the_required_field("Password"))
                    {
                        enter_text_in_the_feild("password", password);
                    }

                webUtils.click_button(single_button_on_the_page);

            break;

            case"admin":
                    break;

        }
    }

    public void navigate_as_per_choice(String navigation_option)
    {
        switch (navigation_option.toLowerCase())
        {
            case "back":
                webUtils.getDriver().navigate().back();
                break;
        }
    }


    public boolean isLoggedIn()
    {
        boolean status = false;
        if (visible_anchor_link_on_the_page("Sign out"))
        if (user_logged_in_as.getText().contains("Signed in as:"))
        {
            LOGGER.info("User is logged in as --> " + user_logged_in_as.getText());
            status = true;
        }
        return status;
    }
}
