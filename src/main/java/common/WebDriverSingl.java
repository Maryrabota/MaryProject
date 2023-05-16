package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

import static common.config.PLATFORM_AND_BROWSER;
import static constants.constant.Timeout.IMPL_WAIT;

public class WebDriverSingl {

    private static WebDriver driver;
    public static String browserName = "chrome";

    public static WebDriver getDriver () {

        if (driver == null) {

            switch (PLATFORM_AND_BROWSER) {
                case "win_chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                default:
                    Assert.fail("Incorrect platform or browser" + PLATFORM_AND_BROWSER);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPL_WAIT));
        }
        return driver;
    }
 }


