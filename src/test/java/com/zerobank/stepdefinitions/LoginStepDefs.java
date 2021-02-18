package com.zerobank.stepdefinitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.SafetyPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String user, String pass) {

        new LoginPage().login(user,pass);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        new SafetyPage().backToSafetyButton.click();
    }

    @Then("the title contains {string}")
    public void the_title_contains(String title) {

        Assert.assertEquals(title, new DashboardPage().dashboardTitle.getText());
    }

    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String string) {

        Assert.assertTrue(new DashboardPage().errorMessage.isDisplayed());
    }

}
