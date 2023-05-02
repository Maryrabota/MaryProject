package tests.regressionTests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class regressionTest extends BaseTest {

    @Test
    public void addToFavorites () {
        regressionPage
                .searchHuawei()
                .firstHuaweiAddToWishlist()
                .isHuaweiInWishlistDisplayed();
    }
}
