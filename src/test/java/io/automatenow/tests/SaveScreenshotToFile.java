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

    @Test(description = "Saves a screenshot to a Word document as long as the proper onTestFailure() method is used " +
            "in the TestListener class")
    public void testSaveScreenshotToWordDoc() {
        String pageTitle = homePage.getPageTitle();
        assertEquals(pageTitle, "Homes - automateNow", "The title is invalid");
    }
}