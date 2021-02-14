package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#user_login")
    public WebElement usernameInput;

    @FindBy(css = "#user_password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signInButton;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void loginAsAnyUser(){

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }


}
