package pages.smokePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import static pages.smokePages.TextData.SearchPageTextData.*;

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
        driver.findElement(searchInput).sendKeys(adidasShoes);
        driver.findElement(searchBtn).click();
        return this;
    }

    /**
     * we check if shoes are displayed after implementing search
     */

    public SearchPage chooseFirstShoes () {
        waitElementVisible(driver.findElement(firstShoes)).isDisplayed();
        System.out.println(searchWorksMessage);
        return this;
    }

    /**
     * we check correct tiles number of shoes on the page
     */

    public SearchPage checknumberofShoeTiles () {
        int countTiles = driver.findElements(allShoes).size();
        Assert.assertEquals(countTiles, allShoesTiles);
        return this;
    }

}
