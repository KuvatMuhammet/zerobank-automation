package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().loginAsAnyUser();
        new SafetyPage().backToSafetyButton.click();
        new DashboardPage().onlineBankingMenu.click();
        new OnlineBankingPage().accountActivityLink.click();
        new AccountActivityPage().findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {

        new AccountActivityPage().fromDate.clear();
        new AccountActivityPage().fromDate.sendKeys(from);
        new AccountActivityPage().toDate.clear();
        new AccountActivityPage().toDate.sendKeys(to);
    }

    @When("clicks search")
    public void clicks_search() {

        new AccountActivityPage().findBtn.click();
        BrowserUtils.waitFor(3);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) throws ParseException {

        SimpleDateFormat fromDate = new SimpleDateFormat ("yyyy-MM-dd");
        Date start = fromDate.parse(from);
        SimpleDateFormat toDate = new SimpleDateFormat ("yyyy-MM-dd");
        Date end = fromDate.parse(to);

        List<String> list = BrowserUtils.getElementsText(new AccountActivityPage().datesFromTable);
        for (String dates : list) {
            SimpleDateFormat date = new SimpleDateFormat ("yyyy-MM-dd");
            Date dd = fromDate.parse(dates);
            Assert.assertTrue(start.compareTo(dd)<=0 && end.compareTo(dd)>=0);
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> list = BrowserUtils.getElementsText(new AccountActivityPage().datesFromTable);
        for(int i=0; i<list.size()-1; i++){
            Assert.assertTrue(list.get(i).compareTo(list.get(i+1))>=0);
        }
        System.out.println("sortedList = " + list);

    }


    @Then("the results table should only not contain transactions dates {string}")
    public void the_results_table_should_only_not_contain_transactions_dates(String dd) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        Date start = df.parse(dd);

        List<String> list = BrowserUtils.getElementsText(new AccountActivityPage().datesFromTable);
        for (String dates : list) {
            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
            Date date = sdf.parse(dates);
            Assert.assertFalse(start.compareTo(date) == 0);
        }
        System.out.println("list = " + list);

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        new AccountActivityPage().descriptionInputBox.clear();
        new AccountActivityPage().descriptionInputBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String str) {

        for (WebElement eachRow : new AccountActivityPage().rows) {
            System.out.println(eachRow.getText());
            Assert.assertTrue(eachRow.getText().contains(str));
        }

    }

    @But("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String str2) {
        for (WebElement eachRow : new AccountActivityPage().rows) {
            System.out.println(eachRow.getText());
            Assert.assertFalse(eachRow.getText().contains(str2));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        System.out.println(new AccountActivityPage().depositValue.size());
        Assert.assertTrue(new AccountActivityPage().depositValue.size()>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        System.out.println(new AccountActivityPage().withdrawalValue.size());
        Assert.assertTrue(new AccountActivityPage().withdrawalValue.size()>0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String str) {

        Select typeDropdown = new Select(new AccountActivityPage().typeDropdownElement);
        typeDropdown.selectByVisibleText(str);
        List<WebElement> typeOptions = typeDropdown.getOptions();
        for (WebElement typeOption : typeOptions) {
            System.out.println(typeOption.getText());
        }

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        System.out.println(new AccountActivityPage().withdrawalValue.size());
        Assert.assertFalse(new AccountActivityPage().withdrawalValue.isEmpty());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        System.out.println(new AccountActivityPage().depositValue.size());
        Assert.assertFalse(new AccountActivityPage().depositValue.isEmpty());
    }




}
