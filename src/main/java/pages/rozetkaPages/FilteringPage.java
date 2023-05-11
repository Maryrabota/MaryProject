package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class FilteringPage extends BasePage {

    public FilteringPage (WebDriver driver) {

            super(driver);
        }

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
            waitElementVisible(driver.findElement(phoneDiagonal65)).click();
            return this;
        }

        public boolean tagDiagonal65IsPresent () {
            waitElementVisible(driver.findElement(phoneDiagonal65Tag));
            return true;
        }

        /**
         *  set min iPhone price to 45000
         */

        public FilteringPage increasePhonePrice () {
            driver.findElement(minPrice).clear();
            driver.findElement(minPrice).sendKeys("45000");
            driver.findElement(submitPriceBtn).submit();
            return this;
        }

        public boolean tagIncreasedPriceIsPresent () {
            waitElementVisible(driver.findElement(increasedMinPriceTag));
            return true;
        }

        /**
         *  count number of phone tiles on the page
         */

        public int countPhonCards () {
            return driver.findElements(phoneCards).size();
        }
    }

