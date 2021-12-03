package io.automatenow.tests;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class WindowsAndTabs extends BaseTest {

    @Test(description = "Opens a new browser window")
    public void testOpenNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com");
    }

    @Test(description = "Opens a new browser tab")
    public void testOpenNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
    }
}
