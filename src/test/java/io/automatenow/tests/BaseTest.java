package io.automatenow.tests;

import io.automatenow.pages.BasePage;
import io.automatenow.pages.HomePage;
import io.automatenow.pages.NavigationBar;
import io.automatenow.pages.SandboxPage;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author Marco A. Cruz
 */
public class BaseTest extends BasePage {
    protected NavigationBar navBar;
    protected HomePage homePage;
    protected SandboxPage sandboxPage;

    @BeforeMethod
    public void setup() {
        Assert.assertTrue(goToHomepage(), "An error occurred while navigating to the homepage");

        navBar = new NavigationBar();
        homePage = new HomePage();
        sandboxPage = new SandboxPage();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
