package tests.base;

import common.commonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.NegativeTestPages.NotFoundPage;
import pages.base.BasePage;
import pages.regressionPages.RegressionPage;
import pages.smokePages.FilteringPage;
import pages.smokePages.LoginRozPage;
import pages.smokePages.SearchPage;

import static common.config.BROWSER_IS_OPEN;
import static common.config.CLEAR_COOKIE_AND_STORAGE;
import static constants.Constant.Urls.ROZETKA_URL;

public class BaseTest {

    protected WebDriver driver = commonActions.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected RegressionPage regressionPage = new RegressionPage (driver);
    protected LoginRozPage loginRozPage = new LoginRozPage(driver);
    protected SearchPage searchPage = new SearchPage(driver);
    protected FilteringPage filteringPage = new FilteringPage(driver);
    protected NotFoundPage notFoundPage = new NotFoundPage(driver);

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


