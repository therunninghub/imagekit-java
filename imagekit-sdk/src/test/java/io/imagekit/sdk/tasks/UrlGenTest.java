package io.imagekit.sdk.tasks;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class UrlGenTest {
    @Test
    public void signUrl_tests() {
        String url = "https://test-domain.com/test-endpoint/tr:w-100/test-signed-url.png";
        String signature = UrlGen.signUrl("private_key_test", url, "https://test-domain.com/test-endpoint/", 100);
        MatcherAssert.assertThat("5e5037a31a7121cbe2964e220b4338cc6e1ba66d", is(signature));
    }

    @Test
    public void signUrl_tests_expire_zero() {
        String url = "https://test-domain.com/test-endpoint/tr:w-100/test-signed-url.png";
        String signature = UrlGen.signUrl("private_key_test", url, "https://test-domain.com/test-endpoint/", 0);
        MatcherAssert.assertThat("41b3075c40bc84147eb71b8b49ae7fbf349d0f00", is(signature));
    }

    @Test
    public void signUrl_tests_without_slash_expire_zero() {
        String url = "https://test-domain.com/test-endpoint/tr:w-100/test-signed-url.png";
        String signature = UrlGen.signUrl("private_key_test", url, "https://test-domain.com/test-endpoint", 0);
        MatcherAssert.assertThat("41b3075c40bc84147eb71b8b49ae7fbf349d0f00", is(signature));
    }
}
