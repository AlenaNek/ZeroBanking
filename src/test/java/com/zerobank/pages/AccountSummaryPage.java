package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {
    @FindBy(linkText = "Loan")
    public WebElement lnk_loan;

    @FindBy(tagName = "h2")
    public List<WebElement> hdr_accountTypes;

    @FindBy(xpath = "(//table)[3]/thead/tr/th")
    public List<WebElement> hdr_tableColumns;

    @FindBy(linkText = "Savings")
    public WebElement lnk_savings;

    @FindBy(linkText = "Brokerage")
    public WebElement lnk_brokerage;

    @FindBy(linkText = "Checking")
    public WebElement lnk_checking;

    @FindBy(linkText = "Credit Card")
    public WebElement lnk_creditCard;





}
