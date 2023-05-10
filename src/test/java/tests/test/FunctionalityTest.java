package pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.TextDataForSearchPage.ALL_SHOES_TILES;
import static constants.Constant.TextdataForFilterPage.EXPECTED_PHONE_TILES;
import static constants.Constant.TextdataForNotfoundPage.NO_MODEL_FOUND;
import static constants.Constant.Urls.ROZETKA_APPLE_URL;

public class FunctionalityTest extends BaseTest  {

    @Test
    public void searchItem () {

        /**
         * the test checks if search is working correctly and if it displays all items
         */

        searchPage.searchForShoes();

        Assert.assertEquals(searchPage.getCountTiles(), ALL_SHOES_TILES);

        searchPage.chooseFirstShoes();

        logger.info("We implemented search, verified all shoes tiles are displayed, and verified, we can open one of items in the list");
    }

    @Test
    /**
     * the test checks if filtering works correctly. After filtered, we make sure the price is chosen correctly
     */

        public void checkFilteringFunctionality ()  {

        basePage.open(ROZETKA_APPLE_URL);

        filteringPage
                .chooseDiagonal65();

        Assert.assertTrue(filteringPage.getDiagonal165TagElem().isDisplayed());

        logger.info("After filtered on diagonal, verify the filtering tag appeared");

        filteringPage
                .increasePhonePrice();

        Assert.assertTrue(filteringPage.getIncreaseMinPriceTagElem().isDisplayed());

        logger.info("After setting minimal price, verify minimal price tag appeared");

        Assert.assertEquals(filteringPage.getCountCards(), EXPECTED_PHONE_TILES);
        logger.info("Verify number of cards with such parameters is 6");
    }

    @Test

    public void addToFavorites () {

        /**
         * the test checks if the chosen item is added to the wishlist
         */

        wishlistPage
                .searchHuawei()
                .firstHuaweiAddToWishlist()
                .openWishlist();

        Assert.assertTrue(wishlistPage.getFirstHuaweiElem().isDisplayed());

        logger.info("Verified that the added-to-wishlist phone is displayed in the wishlist");
    }

    @Test
    public void pageNotFound ()  {

        notFoundPage.enterIncorrectSymbol();

        Assert.assertTrue(notFoundPage.getNothingFoundElem().isDisplayed());

        notFoundPage.searchForIncorrectSymbol();
        Assert.assertTrue(notFoundPage.getNothingFoundPage().isDisplayed());

        Assert.assertEquals (notFoundPage.getTextOfNthgFoundPage(), NO_MODEL_FOUND);

        logger.info("Enter & search for incorrect message to find out error message");
    }
}
