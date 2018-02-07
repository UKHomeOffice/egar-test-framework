package uk.gov.digital.ho.egar.automation.framework;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.service.PropertyService;
import uk.gov.digital.ho.egar.automation.framework.service.impl.MultiSourcePropertyService;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks
{

    private static int passedTestCount;
    private static int failedTestCount;
    private static PropertyService propService = new MultiSourcePropertyService();
    private static String API = propService.propertyValue("API");
    private static boolean initialised = false;
    private static final SimpleDateFormat SCREENSHOT_FILENAME_DATE_FORMAT = new SimpleDateFormat
            ("yyyMMdd'-'HHmmssSSS");
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
     WebUtils utils;
    public Hooks(WebUtils webUtils)
    {
        utils=webUtils;
    }

    //The below method will assist in handling SSL exception during Handshake
    @Before(order = 1)
    public void allowConnectionToBadlySetupServers()
    {
        System.setProperty("jsse.enableSNIExtension", "false");
    }

    //This cucumber api @Before has scenario class in it calling ability... this will effectively call a
    @Before(order = 2)
    public void before(Scenario scenario)
    {
        if (LOGGER.isInfoEnabled())
            {
                LOGGER.info("Executing scenario --> " + scenario.getName() + "\n");
            }
        utils.setScenario(scenario);
        utils.setStartTimeForScenario(scenario.getName(), new Date(System.currentTimeMillis()));
    }

    @After(order = 3)
    public void deleteCookiesAfterTestExecution()
    {
			LOGGER.info("deleteCookiesAfterTestExecution() - order =2, Delete all cookies all the cookies at the end of the test execution");
			String API = propService.propertyValue("API");
        if (!API.equals("Yes"))
            {
                utils.getDriver().manage().deleteAllCookies();
            }
    }

    @After(order = 4)
    public void printScenarioStatus(Scenario scenario)
    {
        
			LOGGER.info("Printing Scenario status below\n");
        
			LOGGER.info("Hooks() - printScenarioStatus() order=3 "
                + " Scenario with name -->" + scenario.getName()
                + "--> has been executed and its status is --> "
                + scenario.getStatus() +"\n");

        if (scenario.getStatus().equalsIgnoreCase("passed"))
        {
            passedTestCount = passedTestCount + 1;
        }
        else if(scenario.getStatus().equalsIgnoreCase("failed"))
        {
            failedTestCount = failedTestCount + 1;
        }

        
			LOGGER.info("PASSED TEST CASE COUNT --> " + "[" + passedTestCount + "]" + "  FAILED TEST CASE COUNT --> " + "[" + failedTestCount + "]" + "\n");

    }

    @After(order = 5)
    public void captureScreenShot(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            LOGGER.info("captureScreenshot() - order = 4 - capture the screenshot of the failed test\n");
            String workingDir = System.getProperty("user.dir");
            String screenshotDir = workingDir + "//target//selenium-test-screenshots//";
            String fileName = (scenario.getName() != null ? ""
                    + scenario.getName(): "")
                    + "_"
                    +SCREENSHOT_FILENAME_DATE_FORMAT.format(new Date())
                    + ".png";

            utils.takeScreenShot(screenshotDir, fileName);
        }
    }

    @cucumber.api.java.Before
    public void setUp() throws Throwable
    {
        if (!initialised)
        {
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run()
                {
                    if (!API.equalsIgnoreCase("Yes"))
                    {
                        
			            LOGGER.info("End of test - closing all Webdriver Browsers");
                    }
                    try
                    {
                        if (utils.getDriver()!=null)
                        {
                            utils.getDriver().close();
                            utils.killDrivers();
                        }
                        else
                        {
                            if (LOGGER.isInfoEnabled()) {
                                LOGGER.info("Found Driver instance was null. Nothing to kill");
                            }
                        }
                    }catch (Throwable e)
                    {
                        e.printStackTrace();
                    }
                    
			LOGGER.info("End of test - Killing All WebDrivers");
                }
            });
            initialised = true;
        }
    }
}
