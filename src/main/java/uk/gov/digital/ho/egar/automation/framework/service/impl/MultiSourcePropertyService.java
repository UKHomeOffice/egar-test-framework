package uk.gov.digital.ho.egar.automation.framework.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.digital.ho.egar.automation.framework.service.PropertyService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * The multi source property service resolves a request property key from multiple sources.
 * Resolves the property value by looking for the key in the following order:
 * - Command line arguments
 * - System arguments
 * - Environment variables
 * - External properties file
 * - Default properties file
 *
 * @author Gareth.Penfold
 *
 */
public class MultiSourcePropertyService implements PropertyService {

    /**
     * The default logger for the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MultiSourcePropertyService.class);

    /**
     * The default properties filename.
     */
    private static final String DEFAULT_PROPERTIES_FILENAME = "default.properties";

    /**
     * The external properties file key name as supplied by the system properties.
     */
    private static final String EXTERNAL_PROPERTIES_FILE_KEY_NAME = "framework.property.file";

    /**
     * The command line argument separator.
     */
    private static final String COMMAND_LINE_ARGUMENT_SEPARATOR = "=";

    /**
     * Command line arguments map containing parsed command line key value pairs.
     */
    private Map<String,String> commandLine;

    /**
     * Whether the command line utility is available.
     */
    private boolean commandLineAvailable = false;

    /**
     * The external properties.
     */
    private Properties externalProperties;

    /**
     * Whether the external properties are available.
     */
    private boolean externalPropertiesAvailable = false;

    /**
     * The default properties.
     */
    private Properties defaultProperties;

    /**
     * Whether the default properties are available.
     */
    private boolean defaultPropertiesAvailable = false;

    /**
     * Constructor that takes command line arguments which will intialise the command line utility.
     * Also calls the default constructor for other intialisation steps.
     * @param args The command line arguments
     */
    public MultiSourcePropertyService(final String[] args) {
        this();
        initialiseCommandLineArguments(args);
    }

    /**
     * Default constructor that will initialise the default and external properties files where applicable.
     */
    public MultiSourcePropertyService(){
        initialiseDefaultProperties();
        initialiseExternalProperties();
    }

    /**
     * Initialises the command line property map if arguments are available.
     * @param args The command line arguments
     */
    private void initialiseCommandLineArguments(final String[] args){

        if (args==null){
            return;
        }

        commandLine = new HashMap<>();
        this.commandLineAvailable = true;

        for (String arg : args) {
            if (arg.contains(COMMAND_LINE_ARGUMENT_SEPARATOR)) {
                String[] kvPair = arg.split(COMMAND_LINE_ARGUMENT_SEPARATOR);
                if (kvPair.length == 2) {
                    commandLine.put(kvPair[0], kvPair[1]);
                }
            }
        }
    }

    /**
     * Initialises the internal properties file from the default properties filename.
     * When no property file can be resolved the default properties are not initialised.
     */
    private void initialiseDefaultProperties(){
        defaultProperties = new Properties();
        try (final InputStream stream =
                     this.getClass().getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILENAME)) {
            if (stream!=null) {
                defaultProperties.load(stream);
                defaultPropertiesAvailable = true;
            }
        } catch (IOException e) {
            LOGGER.error("Unable to load default properties file.", e);
        }
    }

    /**
     * Initialises the external properties file from the supplied file name passed in as a system property.
     * When no external properties file is supplied the external properties are not initialised.
     */
    private void initialiseExternalProperties(){
        String filename = System.getProperty(EXTERNAL_PROPERTIES_FILE_KEY_NAME);
        if (filename!=null){
            externalProperties = new Properties();
            try (final InputStream stream = new FileInputStream(filename)) {
                if (stream!=null) {
                    externalProperties.load(stream);
                    externalPropertiesAvailable = true;
                }
            } catch (IOException e) {
                LOGGER.error("Unable to load external properties file.", e);
            }
        }
    }

    /**
     * Resolves the property value by looking for the key in the following order
     * - Command line arguments
     * - System arguments
     * - Environment variables
     * - External properties file
     * - Default properties file
     * If none is present null will be returned.
     * @param key The property key
     * @return The property value
     */
    @Override
    public String propertyValue(final String key) {

        String property = valueFromCommandLine(key);
        if (property != null) {
            return property;
        }

        property = valueFromSystemProperties(key);
        if (property!=null){
            return property;
        }

        property = valueFromEnvironment(key);
        if (property!=null){
            return property;
        }

        property = valueFromExternalProperties(key);
        if (property != null) {
            return property;
        }

        property = valueFromDefaultProperties(key);
        if (property == null) {
            LOGGER.warn("Unable to find property with key {}.", key);
        }

        return property;
    }

    /**
     * Retrieves the property value from the command line properties if available.
     * @param key The property key.
     * @return The property value.
     */
    private String valueFromCommandLine(final String key){
        String value = null;
        if (commandLineAvailable) {
            value = commandLine.get(key);
        }
        return value;
    }

    /**
     * Retrieves the property value from the system properties if present.
     * @param key The property key.
     * @return The property value.
     */
    private String valueFromSystemProperties(final String key){
        return System.getProperty(key);
    }

    /**
     * Retrieves the property value from the environment variables if present.
     * @param key The property key.
     * @return The property value.
     */
    private String valueFromEnvironment(final String key){
        return System.getenv(key);
    }

    /**
     * Retrieves the property value from the external properties file if available and present.
     * @param key The property key.
     * @return The property value.
     */
    private String valueFromExternalProperties(final String key){
        String value = null;
        if (externalPropertiesAvailable) {
            value = (String) externalProperties.get(key);
        }
        return value;
    }

    /**
     * Retrieves the property value from the default properties file if available and present.
     * @param key The property key.
     * @return The property value.
     */
    private String valueFromDefaultProperties(final String key){
        String value = null;
        if (defaultPropertiesAvailable) {
            value = (String) defaultProperties.get(key);
        }
        return value;
    }
}
