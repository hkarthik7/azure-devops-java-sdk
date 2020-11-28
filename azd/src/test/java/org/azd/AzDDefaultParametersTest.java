package org.azd;

import org.junit.Test;
import org.azd.utils.AzDDefaultParameters;

import static org.junit.Assert.*;


public class AzDDefaultParametersTest {

    @Test
    public void shouldReturnOrganiation() {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";

        // When
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, token);

        // Then(assert and act)
        assertSame(defaultParameters.getOrganization(), organization);
    }

    @Test
    public void shouldSetDifferentOrganization() {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";

        // When
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, token);
        defaultParameters.setOrganization("Check");

        // Then(assert and act)
        assertSame("Check", defaultParameters.getOrganization());
    }

    @Test
    public void shouldReturnNull() {
        // When
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters();

        // Then(assert and act)
        assertNull(defaultParameters.getOrganization());
    }
}