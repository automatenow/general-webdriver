package io.automatenow.pages;

import org.openqa.selenium.By;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marco A. Cruz
 */
public class SandboxPage extends BasePage {
    private By adsBtn = By.xpath("//a[contains(text(),'Ads')]");
    private By twitterBtn = By.xpath("//a[@title='Click to share on Twitter']");
    private By formFieldsBtn = By.xpath("//a[contains(text(),'Form Fields')]");
    private By tablesBtn = By.xpath("//a[contains(text(),'Tables')]");
    private By calendarsBtn = By.xpath("//a[contains(text(),'Calendars')]");
    private By searchBoxesBtn = By.xpath("//a[contains(text(),'Search Boxes')]");
    private By gesturesBtn = By.xpath("//a[contains(text(),'Gestures')]");
    private By popupsBtn = By.xpath("//a[contains(text(),'Popups')]");
    private By modalsBtn = By.xpath("//a[contains(text(),'Modals')]");
    private By hoverBtn = By.xpath("//a[contains(text(),'Hover')]");
    private By fileUpload = By.xpath("//a[contains(text(),'File Upload')]");
    private By fileDownload = By.xpath("//a[contains(text(),'File Download')]");
    private By iframes = By.xpath("//a[contains(text(),'IFrames')]");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickTwitterButton() {
        click(twitterBtn);
    }

    public void switchToNewWindow() {
        // Get current window handle
        String currentWindow = getWindowHandle();

        // Get all window handles
        Set<String> handles = getWindowHandles();

        // Switch to new window
        Iterator<String> iter = handles.iterator();
        String newWindow = null;
        while (iter.hasNext()) {
            newWindow = iter.next();
            if (!currentWindow.equals(newWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

    public SandboxPage scrollAdsButtonIntoView() {
        scrollElementIntoView(adsBtn);
        return this;
    }

    public FormFieldsPage clickFormFields() {
        click(formFieldsBtn);
        return new FormFieldsPage();
    }

    public TablesPage clickTables() {
        click(tablesBtn);
        return new TablesPage();
    }

    public CalendarsPage clickCalendars() {
        click(calendarsBtn);
        return new CalendarsPage();
    }

    public SearchBoxesPage clickSearchBoxes() {
        click(searchBoxesBtn);
        return new SearchBoxesPage();
    }

    public GesturesPage clickGestures() {
        click(gesturesBtn);
        return new GesturesPage();
    }

    public PopupsPage clickPopups() {
        click(popupsBtn);
        return new PopupsPage();
    }

    public ModalsPage clickModals() {
        click(modalsBtn);
        return new ModalsPage();
    }

    public HoverPage clickHover() {
        click(hoverBtn);
        return new HoverPage();
    }

    public FileUploadPage clickFileUpload() {
        click(fileUpload);
        return new FileUploadPage();
    }

    public FileDownloadPage clickFileDownload() {
        click(fileDownload);
        return new FileDownloadPage();
    }

    public SandboxPage screenshotModalsButton() {
        takeElementScreenshot(modalsBtn);
        return this;
    }

    public IframesPage clickIframes() {
        click(iframes);
        return new IframesPage();
    }
}
