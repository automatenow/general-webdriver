package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class PopupsPage extends BasePage {
    private By alertBtn = By.id("alert");
    private By confirmBtn = By.id("confirm");
    private By confirmPopupResult = By.id("confirmResult");
    private By promptBtn = By.id("prompt");
    private By promptPopupResult = By.id("promptResult");

    public void clickAlertPopup() {
        click(alertBtn);
    }

    public void clickConfirmPopup() {
        click(confirmBtn);
    }

    public String getConfirmPopupSelection() {
        return getText(confirmPopupResult);
    }

    public void clickPromptPopup() {
        click(promptBtn);
    }

    public void waitForPromptPopupResult(String expectedText) {
        waitForElementText(promptPopupResult, expectedText);
    }
}
