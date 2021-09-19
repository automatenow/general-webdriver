package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class FileUploadPage extends BasePage {
    private By chooseFileBtn = By.id("file_upload");
    private By uploadBtn = By.xpath("//input[@value='Upload']");
    private By uploadStatus = By.xpath("//div[@class='wpcf7-response-output']");
    
    public FileUploadPage uploadFile(String filepath) {
        driver.findElement(chooseFileBtn).sendKeys(filepath);
        click(uploadBtn);
        waitForElementText(uploadStatus, "Thank you for your message. It has been sent.");
        return this;
    }
}
