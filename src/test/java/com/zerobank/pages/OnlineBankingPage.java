package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineBankingPage extends BasePage{

    public OnlineBankingPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[@id='account_summary_link']")
    public WebElement accountSummaryLink;

    @FindBy(css = "#account_activity_link")
    public WebElement accountActivityLink;

    @FindBy(css = "#pay_bills_link")
    public WebElement payBillsLink;




}
