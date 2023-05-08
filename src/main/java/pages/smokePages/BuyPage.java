package pages.smokePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class BuyPage extends BasePage {

    public BuyPage (WebDriver driver) {
            super (driver);
        }

    private final By buyBtn = By.xpath ("(//button[@class = 'buy-button goods-tile__buy-button ng-star-inserted']) [1]");

    private final By cartBtn = By.xpath ("//button[@class = 'header__button ng-star-inserted header__button--active']");

    private final By oformiZakazBtn = By.xpath ("//a[@data-testid = 'cart-receipt-submit-order']");

    private final By contactInfo = By.xpath ("//p[@class = 'checkout-user__text checkout-user__toggle-animation ng-star-inserted show']");

    public BuyPage addingToCart () {
        driver.findElement(buyBtn).click();
        driver.findElement(cartBtn).click();
        return this;
    }

    public BuyPage oformiZakaz () {
        WebElement oformiZakazElement = driver.findElement(oformiZakazBtn);
        waitElementVisible(oformiZakazElement).click();
        return this;
    }

    public BuyPage isContactInfoAutofilled () {

        if (driver.findElement(contactInfo).isDisplayed())
        {
            System.out.println("The contact information is autofilled");
        }
        else
        {
            System.out.println("The contact information is not autofilled");
        }
        return this;
    }
}
