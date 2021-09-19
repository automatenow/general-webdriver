package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class GesturesPage extends BasePage {
    private By map = By.tagName("canvas");

    public void dragMap(int x, int y) {
        dragAndDropByOffset(map, x, y);
    }
}
