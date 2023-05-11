package tests.All;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class WishlistTest extends BaseTest {

    @Test

    public void addToFavorites() {

        /**
         * the test checks if the chosen item is added to the wishlist
         */

        loginPage
                .clickBtntoLogin()
                .enterLoginPassword();

        wishlistPage
                .searchHuawei()
                .firstHuaweiAddToWishlist()
                .openWishList();

        Assert.assertTrue(wishlistPage.phoneDisplayed());

        logger.info("Verified that the added -to-wishlist phone is displayed in the wishlist");
    }
}
