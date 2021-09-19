package io.automatenow.tests;

import io.automatenow.utils.CustomSoftAssert;
import io.automatenow.utils.TestListener;
import org.testng.annotations.*;

/**
 * @author Marco A. Cruz
 */
@Listeners(TestListener.class)
public class SoftAssertions extends BaseTest {

    @Test
    public void testSoftAssert() {
        // First soft assertion checks the page title
        String pageTitle = homePage.getPageTitle();
        CustomSoftAssert softAssert = new CustomSoftAssert();
        softAssert.assertEquals(pageTitle, "wrong title", "The tile is invalid");
//        softAssert.assertEquals(pageTitle, "Home - automateNow");

        // Second soft assertion checks the welcome message
        String greeting = homePage.getWelcomeMessage();
        softAssert.assertTrue(greeting.contains("Welcomes"), "The greeting does not contain 'Welcome'");

        softAssert.assertAll();
    }
}