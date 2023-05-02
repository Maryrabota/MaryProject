package pages.smokePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.base.BasePage;

import static pages.smokePages.TextData.LoginRozPageTextData.*;

public class LoginRozPage extends BasePage {

    public LoginRozPage (WebDriver driver) {

        super (driver);
    }

    private final By loginBtn = By.xpath ("//button[@class='header__button ng-star-inserted']) [1]");

    private final By loginInput = By.id ("auth_email");

    private final By passwordInput = By.id ("auth_pass");

    private final By authorizedUserName = By.xpath ("//span [@class = 'main-auth__user-name']");

    /**
     * We log in with an existing user
     */

    public LoginRozPage enterLoginPassword () {
        driver.findElement(loginInput).sendKeys(RozetkaLogin);
        driver.findElement(passwordInput).sendKeys(RozetkaPassword);
        driver.findElement(loginBtn).click();
        return this;
    }

    /**
     * If user is authorized, Parameter authorizedUserName is displayed with the name and login of the user
     */

    public LoginRozPage verifyYouLoggedIn () {
        if (driver.findElement(authorizedUserName).isDisplayed() )
        {
            System.out.println(LoggedInMessage);
        }

        else {
            System.out.println(NotLoggedInMessage);
        }
        return this;
    }

}
