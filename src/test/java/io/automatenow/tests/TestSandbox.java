package io.automatenow.tests;

import io.automatenow.pages.*;
import io.automatenow.utils.DataUtil;
import io.automatenow.utils.TestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

/**
 * @author Marco A. Cruz
 */
@Listeners(TestListener.class)
public class TestSandbox extends BaseTest {

    @BeforeTest
    public void testNavigateToSandboxPage() {
        navBar.acceptCookies().selectSandbox();
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void testSubmitForm(HashMap<String, String> hashMap) {
        FormFieldsPage formFields = sandboxPage.clickFormFields();
        formFields.setInputFieldText(hashMap.get("Input Field"))
                .selectCheckbox(hashMap.get("Checkbox"))
                .selectRadioButton(hashMap.get("Radio Button"))
                .selectFromDropdown(hashMap.get("Dropdown"))
                .setEmail(hashMap.get("Email"))
                .setMessage(hashMap.get("Message"))
                .clickSubmit();

        String confirmationMsg = formFields.getConfirmationMessage();
        assertTrue(confirmationMsg.contains("Message Sent"), "Form not submitted successfully");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void testVerifyTableItems(HashMap<String, String> hashMap) {
        TablesPage tables = sandboxPage.clickTables();

        String price = tables.getItemPrice("Oranges");
        assertEquals(price, hashMap.get("Oranges"), "Price mismatch");

        price = tables.getItemPrice("Laptop");
        assertEquals(price, hashMap.get("Laptop"), "Price mismatch");

        price = tables.getItemPrice("Marbles");
        assertEquals(price, hashMap.get("Marbles"), "Price mismatch");
    }
}
