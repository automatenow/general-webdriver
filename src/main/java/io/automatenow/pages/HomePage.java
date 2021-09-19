package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class HomePage extends BasePage {
    private By welcomeMsg = By.xpath("//span[text()='Welcome to automateNow']");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMsg).getText();
    }
}
