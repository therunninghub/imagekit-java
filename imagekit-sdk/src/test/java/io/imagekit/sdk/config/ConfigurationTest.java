package io.imagekit.sdk.config;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class ConfigurationTest {

    Configuration SUT;

    @Test
    public void configFileExit_validate_successExpected() {
        SUT = new Configuration();
        SUT.setPrivateKey("privateKey");
        SUT.setPublicKey("publicKey");
        SUT.setUrlEndpoint("endPoint");

        boolean result = SUT.validate();
        assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void configNotExit_validate_errorExpected() {
        SUT = new Configuration();
        SUT.setPrivateKey("privateKey");
        SUT.setUrlEndpoint("endPoint");

        boolean result = SUT.validate();
        assertTrue(result);
    }

    @Test
    public void config_getter_setter_successExpected() {
        String privateKey = "privateKey";
        String publicKey = "publicKey";
        String endPoint = "endPoint";
        SUT = new Configuration(publicKey, privateKey, endPoint);
        MatcherAssert.assertThat(privateKey, is(SUT.getPrivateKey()));
        MatcherAssert.assertThat(publicKey, is(SUT.getPublicKey()));
        MatcherAssert.assertThat(endPoint, is(SUT.getUrlEndpoint()));
    }
}
