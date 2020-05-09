package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Constants;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;
import java.util.Map;

public class PaymentStepDefs {
    PayBillsPage pbPage=new PayBillsPage();
    Alert alert;
    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        BrowserUtils.waitForPageToLoad(2);
        switch(tab.toUpperCase()) {
            case Constants.ADDNEWPAYEE:
                pbPage.tab_addNewPayee.click();
                break;
            case Constants.FOREIGNCURRENCY:
                pbPage.tab_foreignCurrency.click();
                break;
        }
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        pbPage.np_name.sendKeys(dataTable.get("Payee Name"));
        pbPage.np_address.sendKeys(dataTable.get("Payee Address"));
        pbPage.np_account.sendKeys(dataTable.get("Account"));
        pbPage.np_details.sendKeys(dataTable.get("Payee details"));
        pbPage.np_add.click();

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        Assert.assertTrue(pbPage.messageSuccess.isDisplayed());
        Assert.assertEquals(pbPage.messageSuccess.getText(),message);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {

        Assert.assertTrue(BrowserUtils.getElementsText(pbPage.selectCurrency().getOptions()).containsAll(dataTable));
    }
    @When("user clicks on Calculate cost button")
    public void user_clicks_on_Calculate_cost_button() {
        BrowserUtils.waitForPageToLoad(2);
        pbPage.calculate.click();
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String message) {
        try{alert= Driver.getDriver().switchTo().alert();
            Assert.assertEquals(message,alert.getText());
            alert.accept();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
