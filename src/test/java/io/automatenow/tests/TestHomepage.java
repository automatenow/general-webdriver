package io.automatenow.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestHomepage extends BaseTest {

    @Test
    public void testLogo() {
        boolean logoIsPresent = homePage.logoIsDisplayed();
        assertTrue(logoIsPresent, "The automateNow log is not displayed");
    }
}
