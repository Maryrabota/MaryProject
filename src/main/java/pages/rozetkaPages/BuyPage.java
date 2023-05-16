package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import static common.WebDriverSingl.getDriver;

public class BuyPage extends BasePage {

    private final By buyBtn = By.xpath ("(//button[@class = 'buy-button goods-tile__buy-button ng-star-inserted']) [1]");

    private final By cartBtn = By.xpath ("//button[@class = 'header__button ng-star-inserted header__button--active']");

    private final By oformiZakazBtn = By.xpath ("//a[@data-testid = 'cart-receipt-submit-order']");

    private final By contactInfo = By.xpath ("//p[@class = 'checkout-user__text checkout-user__toggle-animation ng-star-inserted show']");

    public BuyPage addingToCart () {
        getDriver().findElement(buyBtn).click();
        getDriver().findElement(cartBtn).click();
        return this;
    }

    public BuyPage oformiZakaz () {
        WebElement oformiZakazElement = getDriver().findElement(oformiZakazBtn);
        waitElementVisible(oformiZakazElement).click();
        return this;
    }

    public boolean contactInfoMarker () {
        getDriver().findElement(contactInfo).isDisplayed();
        return true;
    }
}
