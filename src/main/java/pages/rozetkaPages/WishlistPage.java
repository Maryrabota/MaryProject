package pages.rozetkaPages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static common.WebDriverManager.getDriver;

public class WishlistPage extends BasePage{

    private final By findBtn = By.xpath("//button[contains (text(), 'Знайти ')]");

    private final By firstPhone = By.xpath("//a[@class='goods-tile__picture ng-star-inserted'])[1]");

    private final By firstPhoneWishBtn = By.xpath("(//button[@class='wish-button js-wish-button ng-star-inserted'])[1]");

    private final By wishList = By.linkText("https://rozetka.com.ua/cabinet/wishlist/");

    public WishlistPage firstPhoneAddToWishlist () {
        logger.info("Add the first phone from all items into wishlist");
        getDriver().findElement(firstPhoneWishBtn).click();
        return this;
    }

    public WishlistPage openWishList () {
        logger.info("Click on wishlist icon");
        getDriver().findElement(wishList).click();
        return this;
    }

    public boolean phoneDisplayed () {
        logger.info("Find the added phone in the wishlist");
        waitElementVisible(getDriver().findElement(firstPhone)).isDisplayed();
        return true;
    }

}