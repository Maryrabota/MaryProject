package constants;

import org.openqa.selenium.By;

public class constant {

    public static class Timeout {
        public static final int IMPL_WAIT = 5;
        public static final int EXPL_WAIT = 15;
    }

    public static class Urls {
        public static final String ROZETKA_URL = "https://rozetka.com.ua";
        public static final String ROZETKA_APPLE_URL = "https://rozetka.com.ua/ua/mobile-phones/c80003/producer=apple/";
    }

    public static class TextdataForLoginPage {
        public static final String ROZETKA_LOGIN = "login";
        public static final String ROZETKA_PASSWORD = "password";
        public static final String LOGGED_IN_CONFIRM = "You are logged in";
        public static final String NOT_LOGGED_IN_MESSAGE = "You are not logged in";
    }

    public static class TextDataForSearchPage {
        public static final String ADIDAS_SHOES = "adidas кросівки";
        public static final String SEARCH_WORKS_CONFIRM = "The search is working";
        public static final int ALL_SHOES_TILES = 36;
    }

    public static class Locators {
        public static final By searchInput = By.xpath("//input[@name='search']");
        public static final By searchBtn = By.cssSelector(".button.button_color_green");
    }

    public static class TextDataForWishlistPage {

        public static final String HUAWEI_PHONE = "huawei смартфон";
    }
}