package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (id = "user_login")
    public WebElement login;

    @FindBy (id = "user_password")
    public WebElement password;

    @FindBy (name = "submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    public void login( String username,String password){
       this.login.sendKeys(username);
       this.password.sendKeys(password);
       submit.click();
    }


}
