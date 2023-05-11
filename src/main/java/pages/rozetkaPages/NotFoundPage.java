package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static constants.constant.Locators.searchBtn;
import static constants.constant.Locators.searchInput;

public class NotFoundPage extends BasePage {

        public NotFoundPage (WebDriver driver) {
            super (driver);
        };

        private final By nthgFoundMsg =  By.xpath ("//p[@class='search-suggest__item search-suggest__item-content search-suggest__item-content_type_no-results search-suggest__item-text ng-star-inserted']");
        private final By nthgFoundPage =  By.xpath("(//span[@class='ng-star-inserted']) [1]");



        /**
         * we enter the searched item into the search field
         */

        public NotFoundPage enterIncorrectSymbol () {
            driver.findElement(searchInput).sendKeys("***");
            return this;
        }

        public String hintofNotFound () {
            WebElement hintNotFound = driver.findElement(nthgFoundMsg);
            return waitElementVisible(hintNotFound).getText();
        }

        public NotFoundPage pressSearch () {
            driver.findElement(searchBtn).click();
            return this;
        }

        public String textNotFoundOnPage () {
            WebElement textNotFoundonPage = driver.findElement(nthgFoundPage);
            return waitElementVisible(textNotFoundonPage).getText();
        }
}
