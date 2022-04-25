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

    /**
     * This method runs before every test (including during parallel execution).
     * It expects a 'browser' parameter, which is passed through from the testng.xml file. The default browser to be
     * used is Chrome.
     *
     * @param browser The web browser on which tests should be executed.
     */
    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        navBar = new NavigationBar();
        homePage = new HomePage();
        sandboxPage = new SandboxPage();

        Assert.assertTrue(goToHomepage(browser), "An error occurred while navigating to the homepage");
    }

    /**
     * This method runs after every test (including during parallel execution).
     */
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
