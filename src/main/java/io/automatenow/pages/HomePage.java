package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class HomePage extends BasePage {
    private By welcomeMsg = By.xpath("//span[text()='Welcome to automateNow']");
    private By logo = By.xpath("//img[@alt='automateNow Logo | automatenow.io']");

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public String getWelcomeMessage() {
        return getDriver().findElement(welcomeMsg).getText();
    }

    public boolean logoIsDisplayed() {
        return getDriver().findElement(logo).isDisplayed();
    }
}
