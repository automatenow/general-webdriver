package io.automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Marco A. Cruz
 */
public class FormFieldsPage extends BasePage {
    private By inputField = By.id("g1103-inputfield");
    private By dropDown = By.id("g1103-dropdownmenu");
    private By emailField = By.id("email");
    private By messageField = By.id("contact-form-comment-message");
    private By submit = By.cssSelector("div[class='entry-content'] button[type='submit']");
    private By confirmationMsg = By.xpath("//div[@id='contact-form-1103']//h3[1]");

    public FormFieldsPage setInputFieldText(String text) {
        setText(inputField, text);
        return this;
    }

    public String getInputFieldText() {
        return getText(inputField);
    }

    /**
     * Selects a check box
     *
     * @param option Range is 1 to 3
     */
    public FormFieldsPage selectCheckbox(String option) {
        click(By.xpath("//input[@value='Option " + option + "']"));
        return this;
    }

    public boolean checkboxIsSelected(String option) {
        return driver.findElement(By.xpath("//input[@value='Option " + option + "']")).isSelected();
    }

    /**
     * Selects drop-down option
     *
     * @param option Displayed text
     */
    public FormFieldsPage selectFromDropdown(String option) {
        Select dDown = new Select(driver.findElement(dropDown));
        dDown.selectByVisibleText(option);
        return this;
    }

    /**
     * @return The option that is currently selected.
     */
    public String getDropdownText() {
        Select dDown = new Select(driver.findElement(dropDown));
        return dDown.getFirstSelectedOption().getText();
    }

    /**
     * Selects a radio button
     *
     * @param option Case sensitive value
     */
    public FormFieldsPage selectRadioButton(String option) {
        click(By.cssSelector("input[value='" + option + "']"));
        return this;
    }

    public boolean radioButtonIsSelected(String option) {
        return driver.findElement(By.cssSelector("input[value='" + option + "']")).isSelected();
    }

    public FormFieldsPage setEmail(String email) {
        setText(emailField, email);
        return this;
    }

    public FormFieldsPage setMessage(String message) {
        setText(messageField, message);
        return this;
    }

    public FormFieldsPage clickSubmit() {
        click(submit);
        return this;
    }

    public String getConfirmationMessage() {
        return getText(confirmationMsg);
    }
}
