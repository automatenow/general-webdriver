package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class FileDownloadPage extends BasePage {
    private By pdfDownloadBtn = By.xpath("//a[@class='wpdm-download-link download-on-click btn btn-primary ']");

    public FileDownloadPage downloadPDF() {
        click(pdfDownloadBtn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
