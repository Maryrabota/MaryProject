package pages.rozetkaPages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static common.WebDriverManager.getDriver;
import static constants.constant.TextdataForLoginPage.ROZETKA_LOGIN;
import static constants.constant.TextdataForLoginPage.ROZETKA_PASSWORD;

public class LoginPage extends BasePage {

        private final By userCabinet = By.xpath ("//li[@class='header-actions__item header-actions__item--user']");

        private final By loginInput = By.id ("auth_email");

        private final By passwordInput = By.id ("auth_pass");

        private final By LgnButtonLocator = By.xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");

        private final By authorizedUserName = By.xpath ("//span [@class = 'main-auth__user-name']");

        public LoginPage clickUserCabinettoLogin () {
            logger.info ("click UserCabinet to Login");
            getDriver().findElement(userCabinet).click();
            return this;
        }

        public LoginPage setLogin (String login) {
            logger.info ("Set new login");
            getDriver().findElement(loginInput).sendKeys(login);
            return this;
        }

        public LoginPage setPassword (String password) {
            logger.info ("Set new password");
            getDriver().findElement(passwordInput).sendKeys(password);
            return this;
        }

        public LoginPage clickLgnBtn () {
            logger.info ("click Login button");
            getDriver().findElement(LgnButtonLocator).click();
            return this;
        }

        public LoginPage logIn (String login, String password){
            logger.info ("Fill in login, password and click Login");
            setLogin (login);
            setPassword (password);
            clickLgnBtn();
            return this;
    }

        public LoginPage enterLoginPasswordOfConstantUser (){
            logger.info ("Fill in login, password and click Login of an existing user");
            getDriver().findElement(loginInput).sendKeys(ROZETKA_LOGIN);
            getDriver().findElement(passwordInput).sendKeys(ROZETKA_PASSWORD);
            getDriver().findElement(LgnButtonLocator).click();
            return this;
        }

        /**
         * If user is authorized, Parameter authorizedUserName is displayed with the name and login of the user
         */

        public boolean authorizedUserNameIsPresent () {
            waitElementVisible(getDriver().findElement(authorizedUserName));
            return true;
        }
    }
