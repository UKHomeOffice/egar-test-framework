package uk.gov.digital.ho.egar.automation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.WebUtils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class GarUploadDocPage
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GarUploadDocPage.class);
    WebUtils webUtils;

    public GarUploadDocPage(WebUtils webUtils)
    {
        this.webUtils=webUtils;
        PageFactory.initElements(webUtils.getDriver(), this);
    }

    @FindBy(css = "input[type='file']")
    WebElement fileUpload_button;

    public void uploadFile(String fileName) throws AWTException {
        webUtils.click_button(fileUpload_button);

        Robot robot = new Robot();
        LOGGER.info("The file path is --> " +System.getProperty("user.dir")+"\\src\\test\\resources\\uploaddocuments\\"+fileName);
        StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\src\\test\\resources\\uploaddocuments\\" + fileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
