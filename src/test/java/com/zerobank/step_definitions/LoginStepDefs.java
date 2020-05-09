package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Constants;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage= new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.out.println("Going to the login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("username"),
        ConfigurationReader.getProperty("password"));
    }

    @Then("{} page should be displayed")
    public void account_summary_page_should_be_displayed(String page) {
        switch(page.toLowerCase()) {
            case Constants.ACCOUNTACTIVITY:
                Assert.assertTrue("url didn't match",Driver.getDriver().getCurrentUrl().contains(Constants.ACCOUNTACTIVITY));
                Assert.assertTrue("Page title didn't match",Driver.getDriver().getTitle().toLowerCase().endsWith(Constants.ACCOUNTACTIVITY));
                break;
            case Constants.ACCOUNTSUMMARY:
                Assert.assertTrue("url didn't match",Driver.getDriver().getCurrentUrl().contains(Constants.ACCOUNTSUMMARY));
                Assert.assertTrue("Page title didn't match",Driver.getDriver().getTitle().toLowerCase().endsWith(Constants.ACCOUNTSUMMARY));
                break;
            case Constants.TRANSFERFUNDS:
                Assert.assertTrue("url didn't match",Driver.getDriver().getCurrentUrl().contains(Constants.TRANSFERFUNDS));
                Assert.assertTrue("Page title didn't match",Driver.getDriver().getTitle().toLowerCase().endsWith(Constants.TRANSFERFUNDS));
                break;
            case Constants.PAYBILLS:
                Assert.assertTrue("url didn't match",Driver.getDriver().getCurrentUrl().contains(Constants.PAYBILLS));
                Assert.assertTrue("Page title didn't match",Driver.getDriver().getTitle().toLowerCase().endsWith(Constants.PAYBILLS));
                break;
            case Constants.MONEYMAP:
                Assert.assertTrue("url didn't match",Driver.getDriver().getCurrentUrl().contains(Constants.MONEYMAP));
                Assert.assertTrue("Page title didn't match",Driver.getDriver().getTitle().toLowerCase().endsWith(Constants.MONEYMAP));
                break;
            case Constants.ONLINESTATEMENTS:
                Assert.assertTrue("url didn't match",Driver.getDriver().getCurrentUrl().contains(Constants.ONLINESTATEMENTS));
                Assert.assertTrue("Page title didn't match",Driver.getDriver().getTitle().toLowerCase().endsWith(Constants.ONLINESTATEMENTS));
                break;
        }

    }
    @When("I login with wrong username")
    public void i_login_with_wrong_username() {
        loginPage.login("anyUsername",
                ConfigurationReader.getProperty("password"));
    }


    @Then("Error message should be displayed")
    public void errorMessageLoginAndOrPasswordAreWrongShouldBeDisplayed() {
        BrowserUtils.waitForVisibility(loginPage.errorMessage,5);
       Assert.assertTrue("Error message is not displayed",loginPage.errorMessage.isDisplayed());
        Assert.assertEquals("The text of ",loginPage.errorMessage.getText(),
                "Login and/or password are wrong.");
    }

    @When("I login with wrong password")
    public void iLoginWithWrongPassword() {
        loginPage.login(ConfigurationReader.getProperty("username"),
                "anyPassword");
    }

    @When("I login with blank username")
    public void iLoginWithBlankUsername() {
        loginPage.login("",
                ConfigurationReader.getProperty("password"));
    }

    @When("I login with blank password")
    public void iLoginWithBlankPassword() {
        loginPage.login(ConfigurationReader.getProperty("username"),
                "");
    }


}
