package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class SearchBoxesPage extends BasePage {
    private By searchBox = By.id("wp-block-search__input-1");
    private By searchBtn = By.xpath("//button[text()='Search']");
    private By noSearchResults = By.xpath("//h1[text()='Nothing Found']");

    public boolean search(String text) {
        setText(searchBox, text);
        click(searchBtn);

        if (driver.findElements(noSearchResults).size() > 0) {
            goBack();
            return false;
        }
        return true;
    }

}
