package io.automatenow.tests;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class WindowsAndTabs extends BaseTest {

    @Test(description = "Opens a new browser window")
    public void testOpenNewWindow() {
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        getDriver().get("https://www.google.com");
    }

    @Test(description = "Opens a new browser tab")
    public void testOpenNewTab() {
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get("https://www.google.com");
    }
}
