package se.bjornhansson.selenium.testing.tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import se.bjornhansson.selenium.testing.base.TestBase;
import se.bjornhansson.selenium.testing.pages.GooglePage;

/**
 * Tests for {@link GooglePage}
 */
public class GoogleTest extends TestBase {
    private static final GooglePage PAGE = new GooglePage();

    @Before
    public void before() {
        PAGE.navigateTo(GooglePage.BASE_URL);
    }

    @AfterClass
    public static void after() {
        PAGE.close();
    }

    @Test
    public void testThatTitleIsCorrect() {
        assertEquals("Title should be correct", "Google", PAGE.getPageTitle());
    }
}
