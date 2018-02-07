package uk.gov.digital.ho.egar.automation.framework.service;


/**
 * The property service provides access to property values.
 * @Gareth.Penfold
 */
public interface PropertyService {

    /**
     * Retrieves a property value corresponding to the provided key.
     * @param key The property key.
     * @return The property value.
     */
    public String propertyValue(final String key);

}
