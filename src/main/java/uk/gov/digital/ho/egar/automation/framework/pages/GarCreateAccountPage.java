package uk.gov.digital.ho.egar.automation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.DriverUtils;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

public class GarCreateAccountPage extends DriverUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GarCreateAccountPage.class);
    WebUtils webUtils;
    public GarCreateAccountPage(WebUtils utils)
    {
        webUtils = utils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[1]/a/span[1]")
    private WebElement first_email;

    @FindBy(css = "tbody font b")
    private WebElement email_header_name;

    @FindBy(css = "a[href*='http://key.egarteam']")
    private WebElement email_link_to;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/iframe[1]")
    private WebElement iframe1;

    public void choose_option(String option_name)
    {
        WebElement option_to_choose = webUtils.getDriver().findElement(By.xpath("//*[contains(text(),'"+option_name+"')]"));

        option_to_choose.click();
    }

    public void user_clicks_email_in_inbox()
    {
        first_email.click();
    }

    public boolean check_email_title(String email_header)
    {
        boolean result = false;

        webUtils.getDriver().switchTo().frame(iframe1);
        webUtils.waitUntilElementIsVisible(email_header_name);
        if (email_header_name.getText().trim().contains(email_header))
        {
            LOGGER.info("User can see" + email_header_name.getText());
            webUtils.getDriver().switchTo().defaultContent();
            result = true;
        }
        return result;
    }

    public void click_email_verification_link() throws InterruptedException {
        webUtils.getDriver().switchTo().frame(iframe1);
        webUtils.waitForSeconds(2);
        email_link_to.click();
        webUtils.getDriver().switchTo().defaultContent();
    }

}
