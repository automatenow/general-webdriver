package io.automatenow.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators extends BaseTest {

    @BeforeTest
    public void testNavigateToSandboxPage() {
        getDriver().get("https://automatenow.io/click-events/");
    }

    @Test(description = "Makes use of relative locators in Selenium 4")
    public void testRelativeLocators() {
        // Click below element
        WebElement cat = getDriver().findElement(By.xpath("//button[text()='Cat']"));
//        getDriver().findElement(with(By.tagName("button")).below(cat)).click();

        // Click near element
        getDriver().findElement(with(By.tagName("button")).near(cat)).click();

        // Click to the right of element
//        getDriver().findElement(with(By.tagName("button")).toRightOf(cat)).click();

        // Click above element
//        WebElement cow = driver.findElement(By.xpath("//button[text()='Cow']"));
//        getDriver().findElement(with(By.tagName("button")).above(cow)).click();

        // Click to the left of element
//        getDriver().findElement(with(By.tagName("button")).toLeftOf(cow)).click();
    }
}
