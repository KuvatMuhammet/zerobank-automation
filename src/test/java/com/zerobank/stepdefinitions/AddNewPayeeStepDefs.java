package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().loginAsAnyUser();
        new SafetyPage().backToSafetyButton.click();
        new DashboardPage().onlineBankingMenu.click();
        new OnlineBankingPage().payBillsLink.click();
        new PayBillsPage().addNewPayeeTab.click();

    }

    @And("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> newPayeeInfo) {

        new PayBillsPage().payeeNameInputBox.sendKeys(newPayeeInfo.get("Payee Name"));
        new PayBillsPage().payeeAddressInputBox.sendKeys(newPayeeInfo.get("Payee Address"));
        new PayBillsPage().accountInputBox.sendKeys(newPayeeInfo.get("Account"));
        new PayBillsPage().payeeDetailsInputBox.sendKeys(newPayeeInfo.get("Payee details"));
        new PayBillsPage().addButton.click();
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        Assert.assertTrue(new PayBillsPage().successMessage.isDisplayed());
        System.out.println("successMessage = " + new PayBillsPage().successMessage.getText());
    }

}
