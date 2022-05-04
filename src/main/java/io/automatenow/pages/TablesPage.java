package io.automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author Marco A. Cruz
 */
public class TablesPage extends BasePage {
    private By countrySort = By.cssSelector(".column-2.sorting");
    private By noNextBtn = By.cssSelector(".paginate_button.next.disabled");
    private By nextBtn = By.xpath("//a[normalize-space()='Next']");
    private By h1 = By.cssSelector("h1[itemprop='headline']");

    public TablesPage() {
        // This should be one of the few type of assertions that are made in a page object class
        String h1Heading = getText(h1);
        assertEquals(h1Heading, "Tables");
    }

    public void verifyCountryInRow(int row, String expectedCountry) {
        String actualCountry = getText(By.xpath("//table[@id='tablepress-1']/tbody/tr[" + row + "]/td[2]"));
        assertEquals(actualCountry, expectedCountry, "Unexpected country found");
    }

    public String getCountryInRow(int row) {
        return getText(By.xpath("//table[@id='tablepress-1']/tbody/tr[" + row + "]/td[2]"));
    }

    public String getItemPrice(String item) {
        return getDriver().findElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
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
            List<WebElement> countryListedOnCurrentPage = getDriver().findElements(By.xpath("//table[@id='tablepress-1']//td[normalize-space()='"+ country +"']"));
            List<WebElement> disabledNextBtn = getDriver().findElements(noNextBtn);

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
