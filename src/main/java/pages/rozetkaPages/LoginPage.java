package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static constants.constant.TextdataForLoginPage.ROZETKA_LOGIN;
import static constants.constant.TextdataForLoginPage.ROZETKA_PASSWORD;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {

            super (driver);
        }

        private final By userCabinet = By.xpath ("//li[@class='header-actions__item header-actions__item--user']");

        private final By loginInput = By.id ("auth_email");

        private final By passwordInput = By.id ("auth_pass");

        private final By LgnButton = By.xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");

        private final By authorizedUserName = By.xpath ("//span [@class = 'main-auth__user-name']");

        /**
         * We log in with an existing user
         */

        public LoginPage clickBtntoLogin () {
            driver.findElement(userCabinet).click();
            return this;
        }

        public LoginPage enterLoginPassword (){
            driver.findElement(loginInput).sendKeys(ROZETKA_LOGIN);
            driver.findElement(passwordInput).sendKeys(ROZETKA_PASSWORD);
            driver.findElement(LgnButton).click();
            return this;
        }

        /**
         * If user is authorized, Parameter authorizedUserName is displayed with the name and login of the user
         */

        public boolean authorizedUserNameIsPresent () {
            waitElementVisible(driver.findElement(authorizedUserName));
            return true;
        }
    }
