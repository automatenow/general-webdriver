package io.automatenow.tests;

import io.automatenow.pages.TablesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Marco A. Cruz
 */
public class TestTables extends BaseTest {

    @Test(description = "A test that shows the wrong way to make assertions in Selenium")
    public void testCountriesWrongWay() {
        getDriver().get("https://automatenow.io/tables/");

        TablesPage tables = new TablesPage();
        tables.verifyCountryInRow(1, "China");
        tables.verifyCountryInRow(2, "India");
        tables.verifyCountryInRow(3, "United States");
    }

    @Test(description = "A test that shows the right way to make assertions in Selenium")
    public void testCountriesRightWay() {
        getDriver().get("https://automatenow.io/tables/");

        TablesPage tables = new TablesPage();
        String firstCountry = tables.getCountryInRow(1);
        assertEquals(firstCountry, "China", "Unexpected country found");

        String secondCountry = tables.getCountryInRow(2);
        assertEquals(secondCountry, "India", "Unexpected country found");

        String thirdCountry = tables.getCountryInRow(3);
        assertEquals(thirdCountry, "United States", "Unexpected country found");
    }
}
