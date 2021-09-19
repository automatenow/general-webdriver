package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class CalendarsPage extends BasePage {
    private By calendarYear = By.xpath("//span[@class='ui-datepicker-year']");
    private By calendarMonth = By.xpath("//span[@class='ui-datepicker-month']");
    private By calendarField = By.id("g1065-selectorenteradate");
    private By calendarRightArrow = By.xpath("//a[@title='Next']");

    public CalendarsPage setDate(String month, String day, String year) {
        click(calendarField);

        while (true) {
            String currentMonth = getText(calendarMonth);
            String currentYear = getText(calendarYear);
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            click(calendarRightArrow);
        }

        click(By.xpath("//table//a[text()='" + day + "']"));
        return this;
    }

    public String getDate() {
        return getText(calendarField);
    }
}
