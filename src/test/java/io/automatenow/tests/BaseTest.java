package io.automatenow.tests;

import io.automatenow.pages.*;
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
    @BeforeSuite(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        Assert.assertTrue(goToHomepage(browser), "An error occurred while navigating to the homepage");

        navBar = new NavigationBar();
        homePage = new HomePage();
        sandboxPage = new SandboxPage();
    }

    /**
     * This method runs after every test (including during parallel execution).
     */
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        closeBrowser();
    }
}
