package se.bjornhansson.selenium.testing.pages;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Common base page holding the driver and starting Firefox
 */
public class BasePage {
    private static final Logger LOG = Logger.getLogger(BasePage.class.getName());
    private static FirefoxProfile myPofile;
    protected static WebDriver myDriver;

    protected BasePage() {
        LOG.info("Starting Firefox");
        myPofile = new FirefoxProfile();
        myDriver = new FirefoxDriver(myPofile);
    }

    /**
     * Navigates/Loads the given URL
     * 
     * @param url
     *            the URL to navigate to
     */
    public void navigateTo(String url) {
        LOG.info("Navigates to " + url);
        myDriver.navigate().to(url);
    }

    /**
     * Closing Firefox
     */
    public void close() {
        LOG.info("Closing Firefox");
        myDriver.close();
    }

    /**
     * Gets the page title
     * 
     * @return the page title
     */
    public String getPageTitle() {
        LOG.info("Gets the page title");
        return myDriver.getTitle();
    }
}
