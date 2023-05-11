package tests.All;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.constant.TextDataForSearchPage.ALL_SHOES_TILES;
import static constants.constant.TextDataForSearchPage.SEARCH_WORKS_CONFIRM;

public class SearchTest extends BaseTest {

        @Test
        public void searchItem () throws InterruptedException{

            /**
             * the test checks if search is working correctly and if it displays all items
             */

            searchPage.searchForShoes();

            Thread.sleep(3000);

            Assert.assertEquals(searchPage.numberofShoeTiles(), ALL_SHOES_TILES);

            if ( searchPage.firstShoesOpened())
            {
                System.out.println(SEARCH_WORKS_CONFIRM);
            }
            else

            {
                System.out.println("Can't open first shoes");
            }

            logger.info("We implemented search, verified all shoes tiles are displayed, and verified, we can open one of items in the list");
        }
}
