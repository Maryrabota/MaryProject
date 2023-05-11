package tests.base;

import common.commonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.base.BasePage;
import pages.rozetkaPages.*;


import java.util.logging.Logger;

import static common.config.BROWSER_IS_OPEN;
import static common.config.CLEAR_COOKIE_AND_STORAGE;
import static constants.constant.Urls.ROZETKA_URL;

public class BaseTest {


    protected WebDriver driver = commonActions.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected WishlistPage wishlistPage = new WishlistPage (driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected SearchPage searchPage = new SearchPage(driver);
    protected FilteringPage filteringPage = new FilteringPage(driver);
    protected NotFoundPage notFoundPage = new NotFoundPage(driver);
    protected BuyPage buyPage = new BuyPage(driver);

    protected Logger logger = Logger.getGlobal();

    @BeforeTest
    public void setUp() {
        driver.get(ROZETKA_URL);
    }

    @AfterTest

    public void clearCookieAndStorage () {
        if (CLEAR_COOKIE_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterTest (alwaysRun = true)

    public void closeBrowser () {
        if (BROWSER_IS_OPEN) {
            driver.quit();
        }
    }


}
