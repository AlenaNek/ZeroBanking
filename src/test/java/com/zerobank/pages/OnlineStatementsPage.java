package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlineStatementsPage extends BasePage {
    @FindBy(xpath ="//a[@data-toggle='pill']")
    public List<WebElement> recentStatements;

    public int statementsTable(int year){
        String path="//div[@id='os_"+year+"']//tbody/tr";
        List<WebElement> statement= Driver.getDriver().findElements(By.xpath(path));
        return statement.size();
    }
    public List<WebElement> statementsCount(int year){
        String path="//div[@id='os_"+year+"']//tbody/tr/td/a";
        List<WebElement> statement= Driver.getDriver().findElements(By.xpath(path));
        return statement;
    }



}
