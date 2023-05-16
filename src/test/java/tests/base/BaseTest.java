package tests.base;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.base.BasePage;
import pages.rozetkaPages.*;

import java.util.logging.Logger;

import static common.WebDriverSingl.getDriver;
import static common.config.BROWSER_IS_OPEN;
import static common.config.CLEAR_COOKIE_AND_STORAGE;
import static constants.constant.Urls.ROZETKA_URL;

public class BaseTest {

    protected BasePage basePage = new BasePage();
    protected WishlistPage wishlistPage = new WishlistPage ();
    protected LoginPage loginPage = new LoginPage();
    protected SearchPage searchPage = new SearchPage();
    protected FilteringPage filteringPage = new FilteringPage();
    protected NotFoundPage notFoundPage = new NotFoundPage();
    protected BuyPage buyPage = new BuyPage();

    protected Logger logger = Logger.getGlobal();

    @BeforeTest
    public void setUp() {
        getDriver().get (ROZETKA_URL);
    }

    @AfterTest

    public void clearCookieAndStorage () {
        if (CLEAR_COOKIE_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
            getDriver().manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterTest (alwaysRun = true)

    public void closeBrowser () {
        if (BROWSER_IS_OPEN) {
            getDriver().quit();
        }
    }
}
