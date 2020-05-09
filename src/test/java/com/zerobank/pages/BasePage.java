package com.zerobank.pages;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage{
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='span12']/div/ul/li/a[contains(text(),'Account Activity')]")
    public WebElement tab_accountActivity;

    @FindBy(xpath = "//div[@class='span12']/div/ul/li/a[contains(text(),'Pay Bills')]")
    public WebElement tab_payBills;

    @FindBy(xpath = "//div[@class='span12']/div/ul/li/a[contains(text(),'Online Statements')]")
    public WebElement tab_onlineStatements;

    @FindBy(xpath = "//div[@class='span12']/div/ul/li/a[contains(text(),'MY Money Map')]")
    public WebElement tab_moneyMap;

    @FindBy(xpath = "//div[@class='span12']/div/ul/li/a[contains(text(),'Transfer Funds')]")
    public WebElement tab_transferFunds;

    @FindBy(xpath = "//div[@class='span12']/div/ul/li/a[contains(text(),'Account Summary')]")
    public WebElement tab_accountSummary;




}
