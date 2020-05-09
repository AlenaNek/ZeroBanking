package com.zerobank.step_definitions;

import com.zerobank.pages.OnlineStatementsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.File;

public class StatementsStepDefs {
    OnlineStatementsPage osPage=new OnlineStatementsPage();
    File file;
    File[] files;
    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(int year) {
        switch(year){
            case 2012:osPage.recentStatements.get(0).click();
            break;
            case 2011:osPage.recentStatements.get(1).click();
                break;
            case 2010:osPage.recentStatements.get(2).click();
                break;
            case 2009:osPage.recentStatements.get(3).click();
                break;
        }

    }

    @Then("{int} statements should be displayed for that {int}")
    public void statements_should_be_displayed_for_that_year(int count,int year) {
        Assert.assertEquals(count,osPage.statementsTable(year));
    }

    @When("the user clicks on statement {string} for {int}")
    public void the_user_clicks_on_statement_for(String statement, Integer year) {
        for (WebElement stat:osPage.statementsCount(year)){
            if(stat.getText().equals(statement)){
                stat.click();
                break;
            }
        }
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String nameOfTheFile) {
        BrowserUtils.wait(3);
        try {
            file = new File("/Users/alonalos/Downloads/");
            files = file.listFiles();
            boolean nameCheck = false;
            for (File each:files){
                if (each.getName().contains(nameOfTheFile)){
                    System.out.println(each.getName());
                    nameCheck = true;
                    file = each;
                    break;
                }
            }
            Assert.assertTrue(nameCheck);
        }finally {
            System.out.println("See what happened");
        }
    }

    @Then("the file type should be {string}")
    public void the_file_type_should_be_pdf(String extension) {

        try {
            boolean extensionCheck = false;
            for (File each:files){
                if (each.getName().contains(extension)){
                    System.out.println(each.getName());
                    extensionCheck = true;
                    file = each;
                    break;
                }
            }
            Assert.assertTrue(extensionCheck);
        }finally {
            file.delete();
        }
    }
}
