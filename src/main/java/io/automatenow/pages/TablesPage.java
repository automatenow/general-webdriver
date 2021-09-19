package io.automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author Marco A. Cruz
 */
public class TablesPage extends BasePage {
    private By countrySort = By.cssSelector(".column-2.sorting");
    private By noNextBtn = By.cssSelector(".paginate_button.next.disabled");
    private By nextBtn = By.xpath("//a[normalize-space()='Next']");

    public String getItemPrice(String item) {
        return driver.findElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }

    public void sortByCountry() {
        click(countrySort);
    }

    /**
     * Gets a country's population
     *
     * @param country The name of the country
     * @return Population in millions when country is found; -1 otherwise.
     */
    public String getPopulation(String country) {
        boolean foundCountry = false;

        while (!foundCountry) {
            List<WebElement> countryListedOnCurrentPage = driver.findElements(By.xpath("//table[@id='tablepress-1']//td[normalize-space()='"+ country +"']"));
            List<WebElement> disabledNextBtn = driver.findElements(noNextBtn);

            if (countryListedOnCurrentPage.size() > 0) {
                foundCountry = true;
            } else if (disabledNextBtn.size() == 0) {
                click(nextBtn);
            } else {
                return "-1";
            }
        }

        // Return the country's population
        return getText(By.xpath("//td[normalize-space()='" + country + "']/following-sibling::td"));
    }
}
