package pages.regressionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import static pages.regressionPages.RegressPageTextData.*;

public class RegressionPage extends BasePage {

    public RegressionPage(WebDriver driver){

        super(driver);
    }

    private final By findBtn = By.xpath("//button[contains (text(), 'Знайти ')]");

    private final By firstHuawei = By.xpath("//a[@class='goods-tile__picture ng-star-inserted'])[1]");

    private final By firstHuaweiWishBtn = By.xpath("(//button[@class='wish-button js-wish-button ng-star-inserted'])[1]");

    private final By wishList = By.linkText("https://rozetka.com.ua/cabinet/wishlist/");

    public RegressionPage searchHuawei () {
        driver.findElement(searchInput).sendKeys(huaweiPhoneText);
        driver.findElement(findBtn).click();
        return this;
    }

    public RegressionPage firstHuaweiAddToWishlist () {
        driver.findElement(firstHuaweiWishBtn).click();
        return this;
    }

    public RegressionPage isHuaweiInWishlistDisplayed () {
        driver.findElement(wishList).click();
        Assert.assertTrue(driver.findElement(firstHuawei).isDisplayed());
        return this;
    }

}
