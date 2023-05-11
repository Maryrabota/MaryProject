package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static constants.constant.Locators.searchBtn;
import static constants.constant.Locators.searchInput;
import static constants.constant.TextDataForSearchPage.*;

public class SearchPage extends BasePage {

        public SearchPage (WebDriver driver) {
            super (driver);
        };

        private final By firstShoes= By.xpath ("(//div[@class='goods-tile__inner']) [1]");

        private final By allShoes = By.xpath("//div[@class = 'goods-tile__inner']");

        /**
         * we enter the searched item into the search field
         */

        public SearchPage searchForShoes () {
            driver.findElement(searchInput).sendKeys(ADIDAS_SHOES);
            driver.findElement(searchBtn).click();
            return this;
        }

        /**
         * we check correct tiles number of shoes on the page
         */

        public int numberofShoeTiles  () {

            int tilesSize = driver.findElements(allShoes).size();
            return tilesSize;
        }

        /**
         * we check if shoes are displayed after implementing search
         */

        public boolean firstShoesOpened () {
            waitElementVisible(driver.findElement(firstShoes)).isDisplayed();
            return true;
        }


}
