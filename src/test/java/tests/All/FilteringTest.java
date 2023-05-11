package tests.All;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static constants.constant.Urls.ROZETKA_APPLE_URL;

public class FilteringTest extends BaseTest {

    @Test

    public void checkFilteringFunctionality () throws InterruptedException {

        basePage.open(ROZETKA_APPLE_URL);
        Thread.sleep(4000);
        filteringPage.increasePhonePrice();


        Thread.sleep(4000);
        if (filteringPage.tagIncreasedPriceIsPresent())
        {
            System.out.println("the increased-price tag appeared");
        }
        else
        {
            System.out.println("the increased-price tag has not appeared");
        }

        filteringPage.chooseDiagonal65();
        Thread.sleep(4000);

        if (filteringPage.tagDiagonal65IsPresent())
        {
            System.out.println("the diagonal filtering tag appeared");
        }
        else
        {
            System.out.println("the diagonal filtering tag has not appeared");
        }

        Assert.assertEquals(filteringPage.countPhonCards(), 6);

        logger.info("Verify number of cards with set diagonal & price parameters is 6");
    }
}
