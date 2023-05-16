package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static common.WebDriverSingl.getDriver;

import static constants.constant.Locators.searchBtn;
import static constants.constant.Locators.searchInput;

public class NotFoundPage extends BasePage {


        private final By nthgFoundMsg =  By.xpath ("//p[@class='search-suggest__item search-suggest__item-content search-suggest__item-content_type_no-results search-suggest__item-text ng-star-inserted']");
        private final By nthgFoundPage =  By.xpath("(//span[@class='ng-star-inserted']) [1]");

        /**
         * we enter the searched item into the search field
         */

        public NotFoundPage enterIncorrectSymbol () {
            getDriver().findElement(searchInput).sendKeys("***");
            return this;
        }

        public String hintofNotFound () {
            WebElement hintNotFound = getDriver().findElement(nthgFoundMsg);
            return waitElementVisible(hintNotFound).getText();
        }

        public NotFoundPage pressSearch () {
            getDriver().findElement(searchBtn).click();
            return this;
        }

        public String textNotFoundOnPage () {
            WebElement textNotFoundonPage = getDriver().findElement(nthgFoundPage);
            return waitElementVisible(textNotFoundonPage).getText();
        }
}
