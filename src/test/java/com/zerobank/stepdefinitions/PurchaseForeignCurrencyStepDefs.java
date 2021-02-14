package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseForeignCurrencyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().loginAsAnyUser();
        new SafetyPage().backToSafetyButton.click();
        new DashboardPage().onlineBankingMenu.click();
        new OnlineBankingPage().payBillsLink.click();
        new PayBillsPage().purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {

        Select currencyDropdown = new Select(new PayBillsPage().currencyDropdownMenu);
        List<String> currencyOptions =currencyDropdown.getOptions().stream().map(element->element.getText()).collect(Collectors.toList());

        System.out.println("currencies = " + currencies);
        System.out.println("currencyOptions = " + currencyOptions);

        Assert.assertTrue(currencyOptions.containsAll(currencies));

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        new PayBillsPage().amountInputBox.sendKeys("100");
        new PayBillsPage().selectedCurrencyRadioBtn.click();
        new PayBillsPage().calculateCostsBtn.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText()+" Alert is Displayed");
        alert.accept();

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        Select currencyDropdown = new Select(new PayBillsPage().currencyDropdownMenu);
        currencyDropdown.selectByIndex(7);
        new PayBillsPage().selectedCurrencyRadioBtn.click();
        new PayBillsPage().calculateCostsBtn.click();
    }

}
