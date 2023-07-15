package pages.rozetkaPages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static common.WebDriverManager.getDriver;

public class FilteringPage extends BasePage {

        private final By phoneDiagonal65 = By.xpath("//a[contains (text(), '6.5')]");
        private final By phoneDiagonal65Tag = By.xpath("//li[@class='catalog-selection__item ng-star-inserted']//a[contains (text(), ' 6.5')]");

        private final By minPrice = By.xpath("//input[@formcontrolname='min']");

        private final By submitPriceBtn = By.xpath("//div[@class='slider-filter__inner']//button");

        private final By increasedMinPriceTag = By.xpath("//li[@class='catalog-selection__item ng-star-inserted']//a[contains (text(), ' 45000 - ')]");

        private final By phoneCards = By.xpath("//div[@class='goods-tile__inner']");

        /**
         *  switch iPhone diagonal to 165 and more
         */

        public FilteringPage chooseDiagonal65 () {
            logger.info("set phone Diagonal to 165");
            waitElementVisible(getDriver().findElement(phoneDiagonal65)).click();
            return this;
        }

        public boolean tagDiagonal65IsPresent () {
            waitElementVisible(getDriver().findElement(phoneDiagonal65Tag));
            return true;
        }

        /**
         *  set min iPhone price to 45000
         */

        public FilteringPage clearPhonePrice () {
        logger.info("Clear the field 'min price'");
        getDriver().findElement(minPrice).clear();
        return this;
    }

    public FilteringPage increasePhonePrice (String setMinPrice) {
        logger.info("Set new 'min price'");
        getDriver().findElement(minPrice).clear();
        getDriver().findElement(minPrice).sendKeys(setMinPrice);
        return this;
    }
        public FilteringPage submitBtn () {
        logger.info("Click button Submit");
        getDriver().findElement(submitPriceBtn).submit();
        return this;
    }

        public boolean tagIncreasedPriceIsPresent () {
        waitElementVisible(getDriver().findElement(increasedMinPriceTag));
        return true;
        }

        /**
         *  count number of phone tiles on the page
         */

        public int countPhonCards () {
        logger.info("Get the number of phone tiles");
        return getDriver().findElements(phoneCards).size();
        }
    }

