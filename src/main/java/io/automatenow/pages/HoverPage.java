package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class HoverPage extends BasePage {
    private By hover = By.id("mouse_over");

    public HoverPage doHover() {
        hoverOverElement(hover);
        return this;
    }

    public String getHoverText() {
        return getText(hover);
    }
}
