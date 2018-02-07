package uk.gov.digital.ho.egar.automation.framework;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.service.PropertyService;
import uk.gov.digital.ho.egar.automation.framework.service.impl.MultiSourcePropertyService;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import static uk.gov.digital.ho.egar.automation.framework.DriverUtils.driver;

public class WebUtils {
	DriverUtils driverUtils;
    private PropertyService propertyService= new MultiSourcePropertyService();
    
    private static final String TASKLIST_FOR_MAC = "tasklist";
    private static final String TASKLIST_FOR_LINUX = "ps -l";
    
    // Works also on Mac (???)
    private static String KILL_FOR_WIN = "\\System32\\taskkill /F/IM";
    
    private Scenario scenario;
    private WebDriverWait wait;
    private HashMap<String, Date>startTimes=new HashMap();
    public static String OS = System.getProperty("os.name").toLowerCase();
    private static final Logger LOGGER = LoggerFactory.getLogger(WebUtils.class);

    public WebDriverWait waitFor() {
        return wait;
    }

    public WebUtils() throws Throwable {
        driverUtils = new DriverUtils();
        PageFactory.initElements(getDriver(), this);
        loadProperties();
    }

    public EventFiringWebDriver getDriver() {
        if (driver == null)
        { driver = driverUtils.getDriver();

        }return driver;
    }

    public void setScenario(Scenario currentScenario)
        {
            this.scenario = currentScenario;
            LOGGER.info("setScenario() - Scenario name: " + scenario.getName());
        }

    public void setStartTimeForScenario(String scenarioName, Date startTime)
        {
            startTimes.put(scenarioName, startTime);
        }

  public Date getStartTimeForScenario(String scenarioName)
        {
            Date startTime = null;
              if(startTimes.containsKey(scenarioName))
              {
                  startTime = startTimes.get(scenarioName);
              }
              return startTime;
        }

    public void takeScreenShot(String screenshotDir, String fileName)
    {
        try
        {
         byte[] screenshot =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
         File file = new File(screenshotDir + fileName);
         int i = 0;
         while (file.exists())
            {
             file = new File(screenshotDir + fileName + "_" + i++);
            }
            FileUtils.writeByteArrayToFile(file, screenshot);
        }
        catch(IOException e){
            e.printStackTrace();;
         }

    }
    public static boolean isMac()
    {
        return (OS.indexOf("Mac")>=0);
    }

    public static boolean isLinux()
    {
	return (OS.toLowerCase().indexOf("linux")>=0);
    }

    public static boolean isProcessRunning(String serviceName) throws Exception {

    	Process p ;
    	
        if (isLinux()) {
            p = Runtime.getRuntime().exec(TASKLIST_FOR_LINUX);
        }
        else
        if ( !isMac() )
        {
            p = Runtime.getRuntime().exec(TASKLIST_FOR_MAC);
        }
        else
        	return false ;
        
        // Read lines from process
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(serviceName)) {
                return true;
            }
        }

        return false;
    }
    /*@param String servicename
     *@Description This function will kill the service passed to it */

    public static void killProcess(String serviceName) throws IOException
    {
    	Process p ;
    	
        if (isLinux()) {
        	p = Runtime.getRuntime().exec(TASKLIST_FOR_LINUX);

            // Read lines from process
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(serviceName)) {
                	// Found
                	String parts[] = line.split(" ");
                	String pid = parts[4];
                	Runtime.getRuntime().exec(String.format("kill -9 %s", pid));
                	
                    return ;
                }
            }

            return ;
        }
        
    	
        KILL_FOR_WIN = System.getenv("SystemRoot") + KILL_FOR_WIN;
            Runtime.getRuntime().exec(KILL_FOR_WIN + serviceName);
    }

    public void killDrivers() throws Throwable {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("killDrivers() - Killing the drivers after test execution");
        }

        if (!isMac()&&!isLinux())
            {
                if (isProcessRunning("iexplore.exe"))
                    {
                        killProcess("iexplore.exe");
                    }
                else if (isProcessRunning("chromedriver.exe"))
                    {
                        killProcess("chromedriver.exe");
                    }
                if (isProcessRunning("firefoxdriver.exe"))
                    {
                        killProcess("firefoxdriver.exe");
                    }
            }

	else
	    {
		if(isProcessRunning("chromedriver"))
		 { 
			killProcess("chromedriver");
		 }
	    }
    }

    public String getValueFromProperties(String key)
    {
        return propertyService.propertyValue(key);
    }



    public void visitPage(String newUrl)
    {
        if(LOGGER.isInfoEnabled())
        {
            LOGGER.info("visitPage() - Visiting page: " + newUrl);
        }
        driver.get(newUrl);
    }



    public void loadProperties() throws Throwable {

        String API = getValueFromProperties("API");
        if (!API.equals("Yes"))
        {
            driver = getDriver();
            String maxWaitTime = getValueFromProperties("MaxWaitTime");
            if (maxWaitTime== null)
            {
                maxWaitTime = "30";
            }
            wait = new WebDriverWait(driver,Integer.parseInt(maxWaitTime));
        }
    }

    public WebElement waitUntilElementIsVisible(WebElement element)
    {
        return waitFor().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementIsClickable(WebElement element)
    {
        return waitFor().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click_button(WebElement element)
    {
        if (element != null)
        {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(element);
            waitUntilElementIsClickable(element);
            actions.click().perform();
        }
        else
        {
           if (LOGGER.isInfoEnabled())
           {
               LOGGER.info("The element to be clicked as click_button() - Element is null");
           }
        }
    }

    public void fillTextField(WebElement element, String value)
    {
        if (element != null) {
            waitUntilElementIsVisible(element);
            element.clear();
            element.sendKeys(value);//, Keys.TAB);
        }

    }

    public void handleException(Exception e, String message)
    {
        if(LOGGER.isInfoEnabled())
        {
            LOGGER.info(message);
            e.printStackTrace();
        }
    }

    public void waitForSeconds(double seconds)
    {
        try {
            Thread.sleep(new Double((seconds * 1000)).longValue());
        } catch (InterruptedException e) {
            handleException(e, "Wait got interrupted");
        }
    }
}
