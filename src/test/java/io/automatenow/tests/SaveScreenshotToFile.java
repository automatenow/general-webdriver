package io.automatenow.tests;

import io.automatenow.utils.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Marco A. Cruz
 */
@Listeners(TestListener.class)
public class SaveScreenshotToFile extends BaseTest {

    /*
    Before running this test make sure that the appropriate onTestFailure() option is not commented out in the
    TestListener class.
     */
    @Test(description = "Saves a screenshot to a Word document as long as the proper onTestFailure() option is used " +
            "in the TestListener class")
    public void testSaveScreenshotToWordDoc() {
        String pageTitle = homePage.getPageTitle();
        assertEquals(pageTitle, "Homes - automateNow", "The title is invalid");
    }
}