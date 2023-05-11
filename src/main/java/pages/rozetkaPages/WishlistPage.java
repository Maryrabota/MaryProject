package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import static constants.constant.Locators.searchInput;
import static constants.constant.TextDataForWishlistPage.HUAWEI_PHONE;

public class WishlistPage extends BasePage {

    public WishlistPage(WebDriver driver){

        super(driver);
    }

    private final By findBtn = By.xpath("//button[contains (text(), 'Знайти ')]");

    private final By firstHuawei = By.xpath("//a[@class='goods-tile__picture ng-star-inserted'])[1]");

    private final By firstHuaweiWishBtn = By.xpath("(//button[@class='wish-button js-wish-button ng-star-inserted'])[1]");

    private final By wishList = By.linkText("https://rozetka.com.ua/cabinet/wishlist/");

    public WishlistPage searchHuawei () {
        driver.findElement(searchInput).sendKeys(HUAWEI_PHONE);
        driver.findElement(findBtn).click();
        return this;
    }

    public WishlistPage firstHuaweiAddToWishlist () {
        driver.findElement(firstHuaweiWishBtn).click();
        return this;
    }

    public WishlistPage openWishList () {
        driver.findElement(wishList).click();
        return this;
    }

    public boolean phoneDisplayed () {
        waitElementVisible(driver.findElement(firstHuawei)).isDisplayed();
        return true;
    }

}