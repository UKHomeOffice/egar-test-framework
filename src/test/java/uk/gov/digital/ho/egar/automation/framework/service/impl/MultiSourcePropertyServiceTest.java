package uk.gov.digital.ho.egar.automation.framework.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import uk.gov.digital.ho.egar.automation.framework.service.PropertyService;

import static org.junit.Assert.assertEquals;

/**
 * The multi source property service tests.
 * The tests written cover 4 of the 5 loading methods:
 * - Command line arguments
 * - System arguments
 * - External properties file
 * - Default properties file
 *
 * We have deliberately not test environment variables as these external settings.
 *
 * @author Gareth.Penfold
 *
 */
public class MultiSourcePropertyServiceTest {

    private PropertyService underTest;

    @Ignore
    @Test
    public void testPropertyFromDefaultPropertiesFile(){

        underTest = new MultiSourcePropertyService();

        String result = underTest.propertyValue("baseUrl");

        assertEquals("http://dev.egarteam.co.uk", result);
    }

    @Ignore
    @Test
    public void testCommandLineProperty(){

        String[] args = {"baseUrl=hello","API"};

        underTest = new MultiSourcePropertyService(args);

        String result = underTest.propertyValue("baseUrl");

        assertEquals("hello", result);
    }

    /**
     * Requires and external property file.
     * Set -Dframework.property.file=/etc/test.properties
     */
    @Ignore
    @Test
    public void testPropertyFromExternalPropertiesFile(){

        underTest = new MultiSourcePropertyService();

        String result = underTest.propertyValue("baseUrl");

        assertEquals("bonjour", result);
    }

    /**
     * Requires a system property.
     * Set -baseUrl=hallo
     */
    @Ignore
    @Test
    public void testPropertyFromSystemProperty(){

        underTest = new MultiSourcePropertyService();

        String result = underTest.propertyValue("baseUrl");

        assertEquals("hallo", result);
    }

}
