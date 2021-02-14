package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BasePage{

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "(//div[@id='tabs']//a)[2]")
    public WebElement addNewPayeeTab;

    @FindBy(xpath = "(//div[@id='tabs']//a)[3]")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(css = "#np_new_payee_name")
    public WebElement payeeNameInputBox;

    @FindBy(css = "#np_new_payee_address")
    public WebElement payeeAddressInputBox;

    @FindBy(css = "#np_new_payee_account")
    public WebElement accountInputBox;

    @FindBy(css = "#np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    @FindBy(css = "#add_new_payee")
    public WebElement addButton;

    @FindBy(xpath = "//div[@id='alert_container']/div")
    public WebElement successMessage;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdownMenu;

    @FindBy(id = "pc_amount")
    public WebElement amountInputBox;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dollarRadioBtn;

    @FindBy(id = "pc_inDollars_false")
    public WebElement selectedCurrencyRadioBtn;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsBtn;

}
