package tests.All;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.rozetkaPages.*;
import tests.base.BaseTest;

import java.net.MalformedURLException;

public class userTests extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private BuyPage buyPage = new BuyPage();
    private FilteringPage filteringPage = new FilteringPage();
    private NotFoundPage notFoundPage = new NotFoundPage();
    private SearchPage searchPage = new SearchPage();
    private WishlistPage wishlistPage = new WishlistPage ();

    private SoftAssert softAssertion = new SoftAssert();

    @Test

    public void logIn() {

        loginPage
                .logIn("Natali123", "Nata!@#")
                .clickUserCabinettoLogin();

        Assert.assertTrue(loginPage.authorizedUserNameIsPresent());
    }

    @Test

    public void IsLoggedUserInfoAutofilledInCart () throws MalformedURLException {

        /**
         * the test checks if logged-in user's data is autofilled in shopping cart
         */

        open("/ua/mobile-phones/c80003/producer=apple/");

        buyPage
                .goToProduct()
                .clickBuyBtnOnProduct()
                .makeOrder();

        Assert.assertTrue(buyPage.fulfillOrder());
    }

    @Test

    public void checkFilteringFunctionality () throws InterruptedException, MalformedURLException {

        open("/ua/mobile-phones/c80003/producer=apple/");

        Thread.sleep(3000);

        filteringPage
                .chooseDiagonal65();

        softAssertion.assertTrue(filteringPage.tagDiagonal65IsPresent());

        filteringPage
                .clearPhonePrice()
                .increasePhonePrice("45000")
                .submitBtn();

        softAssertion.assertTrue(filteringPage.tagIncreasedPriceIsPresent());

        Assert.assertEquals(filteringPage.countPhonCards(), 8);

        logger.info("Verify number of cards with set diagonal & price parameters is 6");
    }

    @Test
    public void hintOfNonExistingMatch ()  {

        notFoundPage.enterProductNameIntoSearch("***");

        Assert.assertEquals (notFoundPage.hintofNotFound(), "По вашему запросу ничего не найдено. Уточните свой запрос");

        notFoundPage
                .enterProductNameIntoSearch("---")
                .pressSearch();

        Assert.assertEquals (notFoundPage.textNotFoundOnPage(), "За заданими параметрами не знайдено жодної моделі");

    }

    @Test
    public void searchItem () {

        /**
         * the test checks if search is working correctly and if it displays all items
         */

        searchPage
                .enterProductNameIntoSearch("adidas кросівки")
                .pressSearch();

        Assert.assertEquals(searchPage.numberofShoeTiles(), 36);

        searchPage
                .openFirstShoes();

        logger.info("We implemented search, verified all shoes tiles are displayed, and verified, we can open one of items in the list");
    }

    @Test

    public void addToFavorites() {

        /**
         * the test checks if the chosen item is added to the wishlist
         */

        loginPage
                .clickUserCabinettoLogin()
                .enterLoginPasswordOfConstantUser();

        wishlistPage
                .enterProductNameIntoSearch("huawei смартфон")
                .pressSearch();

        wishlistPage
                .firstPhoneAddToWishlist()
                .openWishList();

        Assert.assertTrue(wishlistPage.phoneDisplayed());

        logger.info("Verified that the added -to-wishlist phone is displayed in the wishlist");
    }
}
