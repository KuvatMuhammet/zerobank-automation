package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "primary-button")
    public WebElement backToSafetyButton;

    @FindBy(xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenu;

    @FindBy(xpath = "//a[contains(text(),'Zero Bank')]")
    public WebElement dashboardTitle;

    @FindBy(xpath = "//form[@id='login_form']/div[1]")
    public WebElement errorMessage;


    public void clickOnAccountSummary(String link){

        Driver.get().findElement(By.xpath("//span[contains(text(),'" + link + "')]")).click();

    }

    public void clickOnAccountType(String accountType){
        Driver.get().findElement(By.xpath("//a[contains(text(),'" + accountType + "')]")).click();

    }

}