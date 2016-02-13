package se.bjornhansson.selenium.testing.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.bjornhansson.selenium.testing.pages.LocalPage;
import se.bjornhansson.selenium.testing.utils.LocalServer;

/**
 * Tests for {@link LocalServer}
 */
public class LocalServerTest {
    private static final LocalPage PAGE = new LocalPage();

    @Test
    public void testThatLocalServerCanBeStarted() {
        LocalServer server = new LocalServer();
        server.setPageDir("../myOtherProject/target/webapp");
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PAGE.navigateTo(LocalPage.BASE_URL + ":" + server.getPort());
        assertEquals("Title should be correct", "Hello World", PAGE.getPageTitle());

        PAGE.close();
        server.stop();
    }
}
