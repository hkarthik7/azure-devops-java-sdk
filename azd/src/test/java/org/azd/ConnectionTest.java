package org.azd;

import org.azd.connection.Connection;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;


public class ConnectionTest {

    @Test
    public void shouldReturnOrganisation() {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";

        // When
        Connection defaultParameters = new Connection(organization, token);

        // Then(assert and act)
        assertSame(defaultParameters.getOrganization(), organization);
    }

    @Test
    public void shouldSetDifferentOrganization() {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";

        // When
        Connection defaultParameters = new Connection(organization, token);
        defaultParameters.setOrganization("Check");

        // Then(assert and act)
        assertSame("Check", defaultParameters.getOrganization());
    }

    @Test
    public void shouldReturnNull() {
        // When
        Connection defaultParameters = new Connection();

        // Then(assert and act)
        assertNull(defaultParameters.getOrganization());
    }
}