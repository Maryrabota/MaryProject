package pages.smokePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import static pages.smokePages.TextData.FilteringPageTextData.expectedPhoneTiles;
import static pages.smokePages.TextData.FilteringPageTextData.newMinPhonePrice;

public class FilteringPage extends BasePage {

    public FilteringPage (WebDriver driver) {

        super(driver);
    }

    private final By phoneDiagonal65 = By.xpath("//a[contains (text(), '6.5')]");
    private final By phoneDiagonal65Tag = By.xpath("//li[@class='catalog-selection__item ng-star-inserted']//a[contains (text(), ' 6.5')]");

    private final By minPrice = By.xpath("//input[@formcontrolname='min']");

    private final By submitPriceBtn = By.xpath("//div[@class='slider-filter__inner']//button");
    private final By increasedMinPriceTag = By.xpath("//li[@class='catalog-selection__item ng-star-inserted']//a[contains (text(), ' 45000 - ')]");

    private final By phoneCards = By.xpath("//div[@class='goods-tile__inner']");

    /**
     *  switch iPhone diagonal to 165 and more
     */

    public FilteringPage chooseDiagonal65 () {
        WebElement diagonalInput = driver.findElement(phoneDiagonal65);
        waitElementVisible(diagonalInput).click();
        return this;
    }

    public FilteringPage tagDiagonal65IsPresent () {
        Assert.assertTrue( driver.findElement(phoneDiagonal65Tag).isDisplayed());
        return this;
    }

    /**
     *  set min iPhone price to 45000
     */

    public FilteringPage increasePhonePrice () {
        driver.findElement(minPrice).clear();
        driver.findElement(minPrice).sendKeys(newMinPhonePrice);
        driver.findElement(submitPriceBtn).submit();
        return this;
    }

    public FilteringPage tagIncreasedPriceIsPresent () {
        Assert.assertTrue(driver.findElement(increasedMinPriceTag).isDisplayed());
        return this;
    }

    /**
     *  count number of phone tiles on the page
     */

    public FilteringPage countPhonCards () {
        int countCards = driver.findElements(phoneCards).size();
        Assert.assertEquals(countCards, expectedPhoneTiles);
        return this;
    }
}
