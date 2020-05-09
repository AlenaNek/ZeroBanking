package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Constants;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefs {
    AccountActivityPage aaPage=new AccountActivityPage();
    AccountSummaryPage asPage=new AccountSummaryPage();

    @Then("verify Transactions table options are displayed")
    public void verify_Transactions_table_options_are_displayed(List<String> dataTable) {
        Assert.assertEquals(BrowserUtils.getElementsText(aaPage.findTransactionRows),dataTable);
    }
    @Then("verify that Account drop down has")
    public void verify_that_Account_drop_down_has(List<String> dataTable) {
        Assert.assertEquals(BrowserUtils.getElementsText(aaPage.accountOptions().getOptions()),dataTable);
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        Assert.assertEquals(aaPage.accountOptions().getFirstSelectedOption().getText(),"Savings");
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_Brokerage_selected(String link) {
        switch (link.toUpperCase()) {
            case Constants.SAVINGS:
                Assert.assertEquals(aaPage.accountOptions().getFirstSelectedOption().getText(),"Savings");
                break;
            case Constants.BROKERAGE:
                Assert.assertEquals(aaPage.accountOptions().getFirstSelectedOption().getText(),"Brokerage");
                break;
            case Constants.CHECKING:
                Assert.assertEquals(aaPage.accountOptions().getFirstSelectedOption().getText(),"Checking");
                break;
            case Constants.CREDITCARD:
                Assert.assertEquals(aaPage.accountOptions().getFirstSelectedOption().getText(),"Credit Card");
                break;
            case Constants.LOAN:
                Assert.assertEquals(aaPage.accountOptions().getFirstSelectedOption().getText(),"Loan");
                break;
        }
    }

}
