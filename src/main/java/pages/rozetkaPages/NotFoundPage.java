package pages.rozetkaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static common.WebDriverManager.getDriver;

public class NotFoundPage extends BasePage {

        private final By nthgFoundMsg = By.xpath ("//p[@class='search-suggest__item search-suggest__item-content search-suggest__item-content_type_no-results search-suggest__item-text ng-star-inserted']");
        private final By nthgFoundPage =  By.xpath("(//span[@class='ng-star-inserted']) [1]");

        /**
         * we enter the searched item into the search field
         */

        public String hintofNotFound () {
            logger.info("Get hint in the search field about no item found");
            WebElement hintNotFound = getDriver().findElement(nthgFoundMsg);
            return waitElementVisible(hintNotFound).getText();
        }

        public String textNotFoundOnPage () {
            logger.info("Get text with the message about no item found");
            WebElement textNotFoundonPage = getDriver().findElement(nthgFoundPage);
            return waitElementVisible(textNotFoundonPage).getText();
        }
}
