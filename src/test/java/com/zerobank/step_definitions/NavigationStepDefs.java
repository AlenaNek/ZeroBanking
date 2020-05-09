package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class NavigationStepDefs {
    BasePage basePage = new BasePage();
    AccountSummaryPage acPage=new AccountSummaryPage();

    @And("navigate/go to {string} page")
    public void navigate_go_to_page(String page) {
        System.out.println("Going to the " + page);
        switch (page.toUpperCase()) {
            case Constants.ACCOUNTACTIVITY:
                basePage.tab_accountActivity.click();
                break;
            case Constants.ACCOUNTSUMMARY:
                basePage.tab_accountSummary.click();
                break;
            case Constants.TRANSFERFUNDS:
                basePage.tab_transferFunds.click();
                break;
            case Constants.PAYBILLS:
                basePage.tab_payBills.click();
                break;
            case Constants.MONEYMAP:
                basePage.tab_moneyMap.click();
                break;
            case Constants.ONLINESTATEMENTS:
                basePage.tab_onlineStatements.click();
                break;
        }
    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        System.out.println("Clicking on "+link);
        BrowserUtils.wait(1);
        switch(link.toUpperCase()){
            case Constants.SAVINGS:
               acPage.lnk_savings.click();
               break;
            case Constants.BROKERAGE:
                acPage.lnk_brokerage.click();
                break;
            case Constants.CHECKING:
                acPage.lnk_checking.click();
                break;
            case Constants.CREDITCARD:
                acPage.lnk_creditCard.click();
                break;
            case Constants.LOAN:
                acPage.lnk_loan.click();
                break;
        }

    }
}
