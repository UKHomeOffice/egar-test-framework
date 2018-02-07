package uk.gov.digital.ho.egar.automation.framework;


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
retryCount = 0,
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = true,
coverageReport = true,
usageReport = true,
jsonUsageReport = "target/cucumber-usage.json",
toPDF = true,
includeCoverageTags = "@passed",
outputFolder = "target")
@CucumberOptions(plugin = { "html:target/cucumber-html-report",
                            "json:target/cucumber.json",
                            "pretty:target/cucumber-pretty.txt",
                            "usage:target/cucumber-usage.json","junit:target/cucumber-results.xml"},
                             features = "classpath:featurefiles",
                             glue = "classpath:",
                             tags = "@automated",
                             dryRun = false)

public class CucumberTest extends AbstractTestNGCucumberTests {
}
