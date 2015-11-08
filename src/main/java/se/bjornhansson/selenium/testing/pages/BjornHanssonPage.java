package se.bjornhansson.selenium.testing.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;

/**
 * Page for bjornhansson.se
 */
public class BjornHanssonPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(BjornHanssonPage.class.getName());
    public static final String BASE_URL = "http://bjornhansson.se";

    /**
     * Checks if the "about image" is visible
     * 
     * @return true or false
     */
    public boolean isAboutImageVisible() {
        LOG.info("Gets the about image");
        return myDriver.findElement(By.id("me")).findElement(By.tagName("img")).isDisplayed();
    }
}
