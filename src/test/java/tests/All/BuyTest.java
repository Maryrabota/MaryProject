package tests.All;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.constant.Urls.ROZETKA_APPLE_URL;

public class BuyTest extends BaseTest {

    @Test
    public void IsLoggedUserInfoAutofilledInCart ()  {

        /**
         * the test checks if logged-in user's data is autofilled in shopping cart
         */

        loginPage
                .clickBtntoLogin()
                .enterLoginPassword();

        basePage.open(ROZETKA_APPLE_URL);

        buyPage
                .addingToCart()
                .oformiZakaz();

        if (buyPage.contactInfoMarker())
        {
            System.out.println("The contact information is autofilled");
        }
        else
        {
            System.out.println("The contact information is not autofilled");
        }
    }

}
