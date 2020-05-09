package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends  BasePage {

    @FindBy(id="aa_accountId")
    public WebElement accountDropDown;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> findTransactionRows;

    @FindBy(xpath = "//a[contains( text(),\"Find Transactions\")]")
    public WebElement findTransaction;

    @FindBy(id="aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id="aa_toDate")
    public WebElement dateTo;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement find;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr")
    public List<WebElement> transactionsRows;

    @FindBy(xpath ="//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> transactionsDates;

    @FindBy(id="aa_description")
    public WebElement description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    public List<WebElement> transactionDescription;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    public List<WebElement> transactionDeposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]")
    public List<WebElement> transactionWithdrawal;

    @FindBy(id="aa_type")
    public WebElement typeDropDown;








    public Select accountType(){
        return new Select(typeDropDown);
    }
    public Select accountOptions(){
        return new Select(accountDropDown);
    }


}
