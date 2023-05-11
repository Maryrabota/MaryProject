package tests.All;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.constant.TextdataForLoginPage.LOGGED_IN_CONFIRM;
import static constants.constant.TextdataForLoginPage.NOT_LOGGED_IN_MESSAGE;

public class LoginTest extends BaseTest {

    @Test

    public void verifyYouLoggedIn() {

        loginPage.clickBtntoLogin().enterLoginPassword();

        if (loginPage.authorizedUserNameIsPresent())

        {
            System.out.println(LOGGED_IN_CONFIRM);

        } else {
            System.out.println(NOT_LOGGED_IN_MESSAGE);
        }

        logger.info("Check if the login is successful");
    }
}
