package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityNavStepDefs {

    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String userType) {

        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equals("user")){
            username = ConfigurationReader.get("username");
            password = ConfigurationReader.get("password");
        }else if(userType.equals("user1")){
            username = ConfigurationReader.get("username");
            password = ConfigurationReader.get("password");
        }else if(userType.equals("user2")){
            username = ConfigurationReader.get("username");
            password = ConfigurationReader.get("password");
        }
        //send username and password and login
        new LoginPage().login(username,password);
    }

    @And("the user clicks on Online Banking menu")
    public void the_user_clicks_on_Online_Banking_menu() {
        new SafetyPage().backToSafetyButton.click();
        new DashboardPage().onlineBankingMenu.click();

    }

    @And("the user clicks on Account Summary page")
    public void clicks_on_Account_Summary_page() {

        new OnlineBankingPage().accountSummaryLink.click();
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String accountType) {
        new AccountSummaryPage().clickOnAccountType(accountType);

    }


    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertTrue(new AccountActivityPage().showTransactionsHeader.isDisplayed());
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String account) {
        Select accountDropDownOptions = new Select(new AccountActivityPage().accountDropDown);
        String actualOption = accountDropDownOptions.getFirstSelectedOption().getText();
        Assert.assertEquals(account, actualOption);

    }


}
