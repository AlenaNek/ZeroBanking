package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.util.Random;

public class PayBillsStepDefs {
    PayBillsPage pbPage=new PayBillsPage();
    Random rand = new Random();
    Alert alert;
    int a;
    @When("user selects random payee option")
    public void user_selects_random_payee_option() {
        pbPage.payeeSelect().selectByVisibleText("Wells Fargo");
       pbPage.payeeSelect().selectByIndex(a);
    }

    @When("user selects random account option")
    public void user_selects_random_account_option() {
        a= rand.nextInt(7);
        pbPage.accountSElect().selectByIndex(a);
    }

    @When("user enters random amount")
    public void user_enters_random_amount() {
        a=rand.nextInt(1000);
        pbPage.amount.click();
        pbPage.amount.sendKeys(String.valueOf(a)+ Keys.ENTER);
    }

    @Then("{string} message should be displayed.")
    public void message_should_be_displayed(String string) {
        BrowserUtils.wait(1);
        Assert.assertTrue(pbPage.messageSuccess.isDisplayed());
        Assert.assertEquals(pbPage.messageSuccess.getText(),string);
    }
    @Then("{string} alert message should be displayed.")
    public void alert_message_should_be_displayed(String string) {
        try {
            alert = Driver.getDriver().switchTo().alert();
            Assert.assertEquals(string, alert.getText());
            alert.accept();
        }catch (Exception e){
            e.printStackTrace();
        }
        BrowserUtils.wait(2);
    }

    @When("user enters valid date")
    public void user_enters_valid_date() {
        pbPage.date.sendKeys(LocalDate.now().toString()+Keys.ENTER);
    }

    @When("user clicks on pay button")
    public void user_clicks_on_pay_button() {
        pbPage.pay.click();
    }

}
