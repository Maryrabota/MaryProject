package pages.rozetkaPages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static common.WebDriverManager.getDriver;

public class SearchPage extends BasePage {

        private final By firstShoes= By.xpath ("(//div[@class='goods-tile__inner']) [1]");

        private final By allShoes = By.xpath("//div[@class = 'goods-tile__inner']");

        /**
         * we check correct tiles number of shoes on the page
         */

        public int numberofShoeTiles  () {
            logger.info("Get the number of shoe tiles");
            int tilesSize = getDriver().findElements(allShoes).size();
            return tilesSize;
        }

        /**
         * we check if shoes are displayed after implementing search
         */

        public void openFirstShoes () {
            logger.info("Open first shoes");
            waitElementVisible(getDriver().findElement(firstShoes)).click();
        }
}
