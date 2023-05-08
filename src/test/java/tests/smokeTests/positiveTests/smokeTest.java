package tests.smokeTests.positiveTests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import java.util.logging.Logger;

import static constants.Constant.Urls.ROZETKA_APPLE_URL;

public class smokeTest extends BaseTest  {

    private static final Logger logger = Logger.getGlobal();

    @Test
    public void loginWithExistingUser ()  {

        loginRozPage
                .enterLoginPassword()
                .verifyYouLoggedIn();
    }

    @Test
    public void IsLoggedUserInfoAutofilledInCart ()  {

        /**
         * the test checks if logged-in user's data is autofilled in shopping cart
         */

        loginRozPage.enterLoginPassword();

        basePage.open(ROZETKA_APPLE_URL);

        buyPage
                .addingToCart()
                .oformiZakaz()
                .isContactinfoAutofilled();

        logger.info("When user logged in & makes order, his data is autofilled in shopping cart");
    }

    @Test

    public void searchItem () {

        /**
         * the test checks if search is working correctly and if it displays all items
         */

        searchPage
                .searchForShoes()
                .checknumberofShoeTiles()
                .chooseFirstShoes();

        logger.info("We implemented search, verified all shoes tiles are displayed, and verified, we can open one of items in the list");
    }

    @Test

    /**
     * the test checks if filtering works correctly. After filtered, we make sure the price is chosen correctly
     */

        public void checkFilteringFunctionality ()  {

        basePage.open(ROZETKA_APPLE_URL);

        filteringPage
                .chooseDiagonal65()
                .tagDiagonal65IsPresent();

        logger.info("After filtered on diagonal, verify if the filtering tag appeared");

        filteringPage
                .increasePhonePrice()
                .tagIncreasedPriceIsPresent();

        logger.info("After setting mininmal price, verify if minimal price tag appeared");

        filteringPage
                .countPhonCards();

        logger.info("Verify number of cards with such parameters is 6");
    }

}
