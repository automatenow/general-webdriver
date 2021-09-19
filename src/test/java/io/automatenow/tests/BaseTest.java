package io.automatenow.tests;

import io.automatenow.pages.BasePage;
import io.automatenow.pages.HomePage;
import io.automatenow.pages.NavigationBar;
import io.automatenow.pages.SandboxPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author Marco A. Cruz
 */
public class BaseTest extends BasePage {
    protected NavigationBar navBar;
    protected HomePage homePage;
    protected SandboxPage sandboxPage;

    @BeforeSuite
    public void setup() {
        Assert.assertTrue(goToHomepage(), "An error occurred while navigating to the the homepage");

        navBar = new NavigationBar();
        homePage = new HomePage();
        sandboxPage = new SandboxPage();
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
