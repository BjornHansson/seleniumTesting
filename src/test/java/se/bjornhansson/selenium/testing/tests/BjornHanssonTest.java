package se.bjornhansson.selenium.testing.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import se.bjornhansson.selenium.testing.base.TestBase;
import se.bjornhansson.selenium.testing.pages.BjornHanssonPage;

/**
 * Tests for {@link BjornHanssonPage}
 */
public class BjornHanssonTest extends TestBase {
    private static final BjornHanssonPage PAGE = new BjornHanssonPage();

    @Before
    public void before() {
        PAGE.navigateTo(BjornHanssonPage.BASE_URL);
    }

    @AfterClass
    public static void after() {
        PAGE.close();
    }

    @Test
    public void testThatTitleIsCorrect() {
        assertEquals("Title should be correct", "Björn Hansson | Software Engineer", PAGE.getPageTitle());
    }

    @Test
    public void testThatAboutImageIsVisible() {
        assertTrue("Image should be visible", PAGE.isAboutImageVisible());
    }
}
