package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage {

    @FindBy (id="sp_amount")
    public WebElement amount;

    @FindBy (id="sp_date")
    public WebElement date;

    @FindBy (id="pay_saved_payees")
    public WebElement pay;

    @FindBy (id="alert_content")
    public WebElement messageSuccess;

    @FindBy (id="sp_payee")
    public WebElement payee;

    @FindBy (id="sp_account")
    public WebElement account;

    @FindBy (id="np_new_payee_name")
    public WebElement np_name;

    @FindBy (id="np_new_payee_address")
    public WebElement np_address;

    @FindBy (id="np_new_payee_account")
    public WebElement np_account;

    @FindBy (id="add_new_payee")
    public WebElement np_add;

    @FindBy (id="np_new_payee_details")
    public WebElement np_details;

    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    public WebElement tab_foreignCurrency;

    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    public WebElement tab_addNewPayee;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy (id="purchase_cash")
    public WebElement purchase;

    @FindBy (id="pc_calculate_costs")
    public WebElement calculate;


    public Select payeeSelect(){
        return new Select(payee);
    }
    public Select accountSElect(){
        return new Select(account);
    }
    public Select selectCurrency(){
        return new Select(currencyDropdown);
    }


}
