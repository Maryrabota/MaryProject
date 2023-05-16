package pages.rozetkaPages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static common.WebDriverSingl.getDriver;
import static constants.constant.Locators.searchInput;
import static constants.constant.TextDataForWishlistPage.HUAWEI_PHONE;

public class WishlistPage extends BasePage{

    private final By findBtn = By.xpath("//button[contains (text(), 'Знайти ')]");

    private final By firstHuawei = By.xpath("//a[@class='goods-tile__picture ng-star-inserted'])[1]");

    private final By firstHuaweiWishBtn = By.xpath("(//button[@class='wish-button js-wish-button ng-star-inserted'])[1]");

    private final By wishList = By.linkText("https://rozetka.com.ua/cabinet/wishlist/");

    public WishlistPage searchHuawei () {
        getDriver().findElement(searchInput).sendKeys(HUAWEI_PHONE);
        getDriver().findElement(findBtn).click();
        return this;
    }

    public WishlistPage firstHuaweiAddToWishlist () {
        getDriver().findElement(firstHuaweiWishBtn).click();
        return this;
    }

    public WishlistPage openWishList () {
        getDriver().findElement(wishList).click();
        return this;
    }

    public boolean phoneDisplayed () {
        waitElementVisible(getDriver().findElement(firstHuawei)).isDisplayed();
        return true;
    }

}