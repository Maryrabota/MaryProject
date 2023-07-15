package pages.rozetkaPages;

import org.openqa.selenium.By;
import pages.base.BasePage;
import static common.WebDriverManager.getDriver;

public class BuyPage extends BasePage {

    private final By buyBtn = By.xpath ("(//div[@class = 'goods-tile__inner']) [1]");

    private final By cartBtn = By.xpath ("//button[@class = 'header__button ng-star-inserted header__button--active']");

    private final By makeOrderBtn = By.xpath ("//a[@data-testid = 'cart-receipt-submit-order']");

    private final By contactInfo = By.xpath ("//p[@class = 'checkout-user__text checkout-user__toggle-animation ng-star-inserted show']");

    public BuyPage goToProduct () {
        logger.info ("Click on the product");
        getDriver().findElement(buyBtn).click();
        return this;
    }

    public BuyPage clickBuyBtnOnProduct () {
        logger.info ("Click Buy-button on the product page");
        getDriver().findElement(cartBtn).click();
        return this;
    }

    public BuyPage makeOrder () {
        logger.info ("Click make-order button");
        waitElementVisible(getDriver().findElement(makeOrderBtn)).click();
        return this;
    }

    public boolean fulfillOrder () {
        logger.info ("Is infomation of the logged-in user autofilled?");
        getDriver().findElement(contactInfo).isDisplayed();
        return true;
    }
}
