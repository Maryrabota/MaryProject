package pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.WebDriverSingl.getDriver;
import static constants.constant.Timeout.EXPL_WAIT;

public class BasePage {


    public void open (String url) {
        getDriver().get(url);
    }

    public WebElement waitElementVisible (WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(EXPL_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}