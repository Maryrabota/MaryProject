package tests.smokeTests.negativeTests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.logging.Logger;

public class smokeNegTest extends BaseTest {

    private static final Logger logger = Logger.getGlobal();

    @Test
    public void pageNotFound () {

    notFoundPage
            .enterIncorrectSymbol()
            .searchForIncorrectSymbol()
            .compareIsTextCorrect();

    logger.info("Enter & search for incorrect message to find out the error message");
    }

}
