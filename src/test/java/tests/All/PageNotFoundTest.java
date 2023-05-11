package tests.All;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class PageNotFoundTest extends BaseTest {

    @Test
    public void pageNotFound ()  {

        notFoundPage.enterIncorrectSymbol();
        Assert.assertEquals (notFoundPage.hintofNotFound(), "По вашому запиту нічого не знайдено. Уточніть свій запит");

        notFoundPage.pressSearch();
        Assert.assertEquals (notFoundPage.textNotFoundOnPage(), "За заданими параметрами не знайдено жодної моделі");

    }
}
