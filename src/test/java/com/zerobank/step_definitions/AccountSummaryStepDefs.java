package com.zerobank.step_definitions;
import java.util.List;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class AccountSummaryStepDefs {
    AccountSummaryPage acPage=new AccountSummaryPage();
    @Then("verify that page title is {string}")
    public void verify_that_page_title_is(String title) {
        Assert.assertEquals(title, Driver.getDriver().getTitle());
    }
    @Given("verifies that account types are displayed")
    public void verifies_that_account_types_are_displayed(List<String> options) {
        Assert.assertEquals(options,BrowserUtils.getElementsText(acPage.hdr_accountTypes));
    }
    @Then("verifies that column names are displayed on Credits Accounts table")
    public void verifies_that_column_names_are_displayed_on_Credits_Accounts_table(List<String>options) {
        Assert.assertEquals(options,BrowserUtils.getElementsText(acPage.hdr_tableColumns));
    }
}
