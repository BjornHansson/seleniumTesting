package se.bjornhansson.selenium.testing;

import org.junit.Rule;

/**
 * Base for all tests
 */
public class TestBase {
    @Rule
    public Retry retry = new Retry(3);
}
