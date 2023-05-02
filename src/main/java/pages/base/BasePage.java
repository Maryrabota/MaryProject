package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constant.Timeout.EXPL_WAIT;

public class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver) {

        this.driver=driver;
    }

    public static final By searchInput = By.xpath("//input[@name='search']");
    public static final By searchBtn = By.cssSelector(".button.button_color_green");

    public void open (String url) {
        driver.get(url);
    }

    public WebElement waitElementVisible (WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPL_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }



}
