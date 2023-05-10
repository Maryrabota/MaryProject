package pages.NegativeTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import static pages.NegativeTestPages.NotFoundPageTextData.IncorrectSymbol;
import static pages.NegativeTestPages.NotFoundPageTextData.NoModelFound;

public class NotFoundPage extends BasePage {

    public NotFoundPage (WebDriver driver) {
        super (driver);
    };

    private final By nthgFoundMsg =  By.xpath ("//p[@class='search-suggest__item search-suggest__item-content search-suggest__item-content_type_no-results search-suggest__item-text ng-star-inserted']");

    private final By nthgFoundPage =  By.xpath("(//span[@class='ng-star-inserted']) [1]");

    /**
     * we enter the searched item into the search field
     */

    public NotFoundPage enterIncorrectSymbol () {
        driver.findElement(searchInput).sendKeys(IncorrectSymbol);
        Assert.assertTrue(waitElementVisible(driver.findElement(nthgFoundMsg)).isDisplayed());
        return this;
    }

    public NotFoundPage searchForIncorrectSymbol () {
        driver.findElement(searchBtn).click();
        Assert.assertTrue(waitElementVisible(driver.findElement(nthgFoundPage)).isDisplayed());
        return this;
    }

    public NotFoundPage compareIsTextCorrect () {
        Assert.assertEquals (waitElementVisible(driver.findElement(nthgFoundPage)).getText(), NoModelFound);
        return this;
    }

}
