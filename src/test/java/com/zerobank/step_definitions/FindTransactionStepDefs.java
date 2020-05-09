package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindTransactionStepDefs {
    AccountActivityPage aaPage=new AccountActivityPage();
    SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
    Date d1,d2,first,last;

    @And("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        BrowserUtils.wait(1);
        aaPage.findTransaction.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) throws ParseException {
       int size=aaPage.transactionsDates.size();
        d1 = sdfo.parse(from);
        d2=sdfo.parse(to);
        first=sdfo.parse(aaPage.transactionsDates.get(0).getText());
        last=sdfo.parse(aaPage.transactionsDates.get(aaPage.transactionsDates.size()-1).getText());
       Assert.assertTrue(first.after(d1)&(first.before(d2)||first.equals(d2)));
        Assert.assertTrue(last.before(d2)&(last.after(d1)||last.equals(d1)));

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException{
        first = sdfo.parse(aaPage.transactionsDates.get(0).getText());
        last=sdfo.parse(aaPage.transactionsDates.get(aaPage.transactionsDates.size()-1).getText());
        Assert.assertTrue(first.after(last));

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from,String to) {
        aaPage.dateFrom.click();
        aaPage.dateFrom.clear();
        aaPage.dateFrom.sendKeys(from +Keys.ENTER);
        aaPage.dateTo.click();
        aaPage.dateTo.clear();
        aaPage.dateTo.sendKeys(to+Keys.ENTER);
    }

    @When("clicks search")
    public void clicks_search() {
        aaPage.find.click();
    }

    @Then("the results table should not contain transactions dated {string}")
    public void the_results_table_should_not_contain_transactions_dated(String date) {
    for(WebElement each: aaPage.transactionsDates){
    Assert.assertNotEquals(each.toString(), date); }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
                aaPage.description.clear();
                aaPage.description.sendKeys(description.toUpperCase()+Keys.ENTER);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        if(aaPage.transactionDescription.size()==0) Assert.fail();
        for (WebElement each : aaPage.transactionDescription){
            Assert.assertTrue(each.getText().contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        for(WebElement each:aaPage.transactionDescription){
            Assert.assertFalse(each.getText().contains(string));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        switch(string.toUpperCase()){
            case Constants.DEPOSIT:
                Assert.assertTrue(aaPage.transactionDeposit.size()>=1);
                break;
            case Constants.WITHDRAWAL:
                Assert.assertTrue(aaPage.transactionWithdrawal.size()>=1);
                break;
        }

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        switch(type.toUpperCase()){
            case Constants.DEPOSIT:
                aaPage.accountType().selectByVisibleText("Deposit");
                break;
            case Constants.WITHDRAWAL:
                aaPage.accountType().selectByVisibleText("Withdrawal");
                break;}
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String type) {
        BrowserUtils.wait(1);
        switch(type.toUpperCase()){
            case Constants.DEPOSIT:
                for(WebElement each:aaPage.transactionDeposit){
                    Assert.assertTrue(each.getText().isEmpty());}
                break;
            case Constants.WITHDRAWAL:
                for(WebElement each:aaPage.transactionWithdrawal){
                    Assert.assertTrue(each.getText().isEmpty());
                break;}
                }
    }
}
