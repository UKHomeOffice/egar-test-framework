package uk.gov.digital.ho.egar.automation.framework.pages;

import com.sun.jna.platform.win32.Netapi32Util;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.DriverUtils;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.util.List;

public class GarStartPage extends DriverUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GarStartPage.class);
    WebUtils webUtils;

    public GarStartPage(WebUtils utils) {
        webUtils = utils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }


    @FindBy(css = "h1")
    private WebElement page_header_name;

    @FindBy(css = "h1")
    List<WebElement> multiple_page_headers;

    @FindBy(css = "nav[role='navigation'] ul a")
    List<WebElement> top_right_navigation_links;

    @FindBy(css = "ul[class='list list-bullet'] li")
    List<WebElement> block_of_instructions_list;

    @FindBy(css = "input[type='submit']")
    List<WebElement> buttons;

    @FindBy(css = "input[type='submit']")
    WebElement only_button_on_page;

    @FindBy(css = "h2")
    List<WebElement> header_levels_2;

    @FindBy(css = "h3")
    List<WebElement> header_levels3;

    public boolean user_is_on_page(String pageName)
    {
        boolean onPage = false;
        webUtils.waitUntilElementIsVisible(page_header_name);

        if (multiple_page_headers.size()>1)
        {
            LOGGER.info("ThIS PAGE HAS MULTIPLE HEADER 1 TITLES");
            for(WebElement page_header:multiple_page_headers)
            {
                if(page_header.getText().trim().contains(pageName))
                {
                    onPage = true;
                    break;
                }
            }
        }
        else
           {
                    LOGGER.info("User is on --> " + page_header_name.getText().contains(pageName));
                    LOGGER.info("The Font Size seen is " + page_header_name.getCssValue("font-size"));
                    onPage = true;
           }
        return onPage;
    }

    public boolean check_if_link_visible_to_user(String names_of_link)
    {
        boolean result = true;
        for (WebElement link:top_right_navigation_links)
        {
            if (link.getText().trim().equalsIgnoreCase(names_of_link))
            {
                if (LOGGER.isInfoEnabled())
                {
                    LOGGER.info("User is can see link" + link.getText().equalsIgnoreCase(names_of_link));
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean check_fonts_size(String font_size)
    {
        boolean fonts = false;
        if (page_header_name.getCssValue("font-size").equalsIgnoreCase("48px"))
        {
            LOGGER.info("The Font Size seen is " + page_header_name.getCssValue("font-size"));

            fonts = true;

        }
        return fonts;
    }


    public boolean check_instructions_present_for_users(String user_instructions)
    {
        boolean result = false;
        for (WebElement instructions:block_of_instructions_list)
        {
            if (instructions.getText().trim().contains(user_instructions))
            {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean visible_buttons(String button_name)
    {
        boolean visible_input_button = false;

        if (buttons.size()>1) {

            for (WebElement button : buttons)
            {
                if (button.getAttribute("value").trim().equalsIgnoreCase(button_name))
                {
                    visible_input_button = true;
                    continue;
                }
            }

        }else {

                if (only_button_on_page.getAttribute("value").trim().contains(button_name))
                {
                    visible_input_button = true;

                }
        }

            return visible_input_button;
    }

    public void click_buttons(String button_name) 
    { 
        if (buttons.size()>1) { 
 
            for (WebElement button:buttons)
            { 
                if (button.getAttribute("value").trim().contains(button_name))
                { 
                    webUtils.click_button(button);
                    break; 
                } 
            } 
 
        }
    else
        {
            if (only_button_on_page.getAttribute("value").contains(button_name)) 
            { 
                webUtils.click_button(only_button_on_page); 
          //      webUtils.waitUntilElementIsVisible(page_header_name);
            } 
        } 
 
 
    } 
 
    public boolean visible_headers2_on_page(String header2Name)
    {
        boolean types = false;

        if (header_levels_2.size()>1) {
            for (WebElement header : header_levels_2) {
                if (header.getText().trim().contains(header2Name)) {
                    types = true;
                    continue;
                }
            }
        }else for (WebElement header : header_levels_2) {
            if (header.getText().trim().contains(header2Name)) {
                types = true;
                break;
            }
        }
        return types;
    }

    public boolean visible_headers3_on_page(String header3Names) {
        boolean types = false;

    if (header_levels3.size()>1)
    {
        for (WebElement header : header_levels3) {
            if (header.getText().trim().contains(header3Names)) {
                types = true;
                break;
            }
        }
    }else
        for (WebElement header : header_levels3)
        {
            if (header.getText().trim().contains(header3Names))
            {
                types = true;
                break;
            }
        }
        return types;
    }


    public void visible_alternate_options_to_users(String headerTypes, String visible_text1, String visible_text2)
    {
        Assert.assertTrue(visible_headers2_on_page(headerTypes));
        Assert.assertTrue(visible_headers3_on_page(visible_text1));
        Assert.assertTrue(visible_headers3_on_page(visible_text2));
    }
}
