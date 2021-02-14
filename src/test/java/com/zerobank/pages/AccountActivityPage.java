package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage {

    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDate;

    @FindBy(css = "#aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findBtn;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody//td[1]")
    public List<WebElement> datesFromTable;

    @FindBy(css = "div#ui-tabs-1 h2")
    public WebElement showTransactionsHeader;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountDropDown;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(id = "aa_type")
    public WebElement typeDropdownElement;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr")
    public List<WebElement> rows;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr/td[3]")
    public List<WebElement> depositValue;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr/td[4]")
    public List<WebElement> withdrawalValue;


    public void enterDateRange(String from, String to) {
        fromDate.sendKeys(from);
        toDate.sendKeys(to);
        //findBtn.click();
    }

}
