package uk.gov.digital.ho.egar.automation.framework;

import com.sun.javafx.runtime.SystemProperties;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.gov.digital.ho.egar.automation.framework.service.PropertyService;
import uk.gov.digital.ho.egar.automation.framework.service.impl.MultiSourcePropertyService;

//Setting all Driver related Utilities

public class DriverUtils {
    public static EventFiringWebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverUtils.class);
    
    // Instantiate the property service
    private static PropertyService propService = new MultiSourcePropertyService();
    
    // Initialise the constants.
    private static String Chrome = propService.propertyValue("Chrome");
    private static String Firefox = propService.propertyValue("Firefox");
    private static String IE = propService.propertyValue("IE");
    private static String Safari = propService.propertyValue("Safari");
    private static String API = propService.propertyValue("API");
    //private static String UserPath = System.getProperty("user.dir");
    
    private static File   binariesPath = new File(propService.propertyValue("binaries.path"));
    
    private static String OS = System.getProperty("os.name").toLowerCase();

    private static String FIREFOX_SYSTEM_PROP_KEY = "webdriver.gecko.driver";

    //Setting Browser driver
    public void setDriver()
    {
        if (driver == null)
        {
            if (API.equals("Yes"))
            {
                LOGGER.info("I am inside API");
                driver = null;
            }

            if (Chrome.equals("Yes"))
                {
                    setDriverPathForBrowser("chrome");
                if (isLinux())
                    {
                      //ChromeOptions options = new ChromeOptions();
                      //options.setBinary(SystemProperties.getProperty("webdriver.chrome.driver"));
                      //options.addArguments("--headless");
                      //driver = new EventFiringWebDriver(new ChromeDriver(options));
			driver = new EventFiringWebDriver(new ChromeDriver());
                    }
                else
                    {
                        driver = new EventFiringWebDriver(new ChromeDriver());
                    }
                driver.manage().window().maximize();
                }

            if (Firefox.equals("Yes"))
                {
                    setDriverPathForBrowser("firefox");
                    driver = new EventFiringWebDriver(new FirefoxDriver());
                    driver.manage().window().maximize();
                }

            if (IE.equals("Yes"))
                {
                    setDriverPathForBrowser("ie");
                    driver = new EventFiringWebDriver(new InternetExplorerDriver());
                    driver.manage().window().maximize();
                }

            if (Safari.equals("Yes"))
                {
                    driver = new EventFiringWebDriver(new SafariDriver());
                    driver.manage().window().maximize();
                }
        }
    }

    //Selenium Driver
    public EventFiringWebDriver getDriver() {
        setDriver();
        return driver;
    }

    //Spike if this method should be used or not ?
    public void closeDriver() {
        driver.quit();
    }

    //Method reading Browser which is declared in prop file
    //Redundant method
    private void setDriverPathForBrowser(String browserName) {
    	
    	if ( !binariesPath.exists() ) throw new IllegalStateException("No path at " + binariesPath.getAbsolutePath() );
    	
        switch (browserName.toLowerCase()) {
            case "firefox":
                {
                if (isMac())
                    {
                        System.setProperty("webdriver.gecko.driver", new File(binariesPath,"/MAC/geckodriver-v0.19.0-macos.tar.gz/geckodriver-v0.19.0-macos.tar").getAbsolutePath());
                    }
                else if (isLinux())
                    {
                        System.setProperty("webdriver.gecko.driver", new File(binariesPath, "/Ubuntu/geckodriver").getAbsolutePath());
                    }
                else
                    {
                        System.setProperty("webdriver.gecko.driver", new File(binariesPath, "/Windows/geckodriver.exe").getAbsolutePath());
                    }
                break;
            }
            case "chrome": {
                if (isMac()) {
                    System.setProperty("webdriver.chrome.driver", new File(binariesPath, "/MAC/chromedriver").getAbsolutePath());
                } else if (isLinux()) {
                    System.setProperty("webdriver.chrome.driver",new File(binariesPath, "/Ubuntu/chromedriver").getAbsolutePath());
                } else {
                    System.setProperty("webdriver.chrome.driver",new File(binariesPath,"/Windows/chromedriver.exe").getAbsolutePath());
                }
                break;
            }
            case "ie":
                System.setProperty("webdriver.ie.driver", new File(binariesPath,"/Windows/IEDriverServer.exe").getAbsolutePath());
        }
    }


    //method asserting platform
    private boolean isLinux() {
        return (OS.indexOf("linux") >= 0);
    }

    //method asserting platform
    private boolean isMac() {
        return (OS.indexOf("Mac") >= 0);
    }

}
