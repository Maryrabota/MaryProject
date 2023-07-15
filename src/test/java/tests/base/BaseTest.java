package tests.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import static common.WebDriverManager.getDriver;
import static common.config.BROWSER_IS_OPEN;
import static common.config.Urls.ROZETKA_URL;

public abstract class BaseTest {

    protected Logger logger = Logger.getGlobal();

    public void open (String url) throws MalformedURLException {
        URL rozetkaBasepage = new URL(ROZETKA_URL);
        URL relativeUrl = new URL (rozetkaBasepage, url);
        getDriver().get (String.valueOf(relativeUrl.toString()));
    }

    public void openHomepage () {
        getDriver().get(ROZETKA_URL);
    }

    @BeforeTest
    public void setUp() {
        getDriver().get (ROZETKA_URL);
    }

    @AfterTest (alwaysRun = true)
    public void closeBrowser () {
        if (BROWSER_IS_OPEN) {
            getDriver().quit();
        }
    }
}
