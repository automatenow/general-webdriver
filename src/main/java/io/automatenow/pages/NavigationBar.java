package io.automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Marco A. Cruz
 */
public class NavigationBar extends BasePage {
    private By sandbox = By.xpath("//*[contains(text(),'Sandbox')]");
    private By vlog = By.xpath("//a[text()='Vlog']");
    private By webdriverIntro = By.xpath("//a[text()='Intro to Selenium WebDriver']");
    private By acceptCookiesBtn = By.id("cookie_action_close_header");

    public SandboxPage selectSandbox() {
        getDriver().findElement(sandbox).click();
        return new SandboxPage();
    }

    public void selectIntroToSeleniumWebDriver() {
        hoverOverElement(vlog);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webdriverIntro)).click();
    }

    public NavigationBar acceptCookies() {
        click(acceptCookiesBtn);
        return this;
    }
}
