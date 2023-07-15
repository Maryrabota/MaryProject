package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.rozetkaPages.NotFoundPage;
import pages.rozetkaPages.WishlistPage;

import java.time.Duration;
import java.util.logging.Logger;

import static common.WebDriverManager.getDriver;
import static constants.constant.Timeout.EXPL_WAIT;

public class BasePage {

    protected Logger logger = Logger.getGlobal();

    public WebElement waitElementVisible (WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(EXPL_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public BasePage pressSearch () {
        logger.info("Click search button");
        getDriver().findElement(searchBtn).click();
        return this;
    }

    public BasePage enterProductNameIntoSearch (String name) {
        logger.info("Enter phone name into search");
        getDriver().findElement(searchInput).sendKeys(name);
        return this;
    }

    public static final By searchInput = By.xpath("//input[@name='search']");
    public static final By searchBtn = By.cssSelector(".button.button_color_green");


}