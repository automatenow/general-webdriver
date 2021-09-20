package io.automatenow.tests;

import io.automatenow.utils.CustomSoftAssert;
import org.testng.annotations.*;

/**
 * @author Marco A. Cruz
 */
public class SoftAssertions extends BaseTest {
    public static CustomSoftAssert softAssert = new CustomSoftAssert();

    @Test
    public void testSoftAssert() {
        String pageTitle = homePage.getPageTitle();
        softAssert.assertEquals(pageTitle, "Homes - automateNow", "The title is invalid");

        String greeting = homePage.getWelcomeMessage();
        softAssert.assertTrue(greeting.contains("Welcomes"), "The greeting message does not contain 'Welcome'");

        softAssert.assertAll();
    }
}