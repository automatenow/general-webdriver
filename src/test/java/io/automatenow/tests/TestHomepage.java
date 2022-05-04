package io.automatenow.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

/**
 * @author Marco A. Cruz
 */
public class TestHomepage extends BaseTest {

    @Test(groups = "firefox")
    public void testLogo1() {
        boolean logoIsPresent = homePage.logoIsDisplayed();
        assertFalse(logoIsPresent, "The automateNow logo is displayed");
    }

    @Test(groups = "chrome")
    public void testLogo2() {
        boolean logoIsPresent = homePage.logoIsDisplayed();
        assertFalse(logoIsPresent, "The automateNow logo is  displayed");
    }

    @Test(groups = "chrome")
    public void testLogo3() {
        boolean logoIsPresent = homePage.logoIsDisplayed();
        assertFalse(logoIsPresent, "The automateNow logo is displayed");
    }
}
