package uk.gov.digital.ho.egar.automation.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;
import java.util.List;

public class GarGoodsPage
{

    private static final Logger LOGGER = LoggerFactory.getLogger(GarGoodsPage.class);
    WebUtils webUtils;

    public GarGoodsPage(WebUtils utils)
    {
        webUtils = utils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }



}
