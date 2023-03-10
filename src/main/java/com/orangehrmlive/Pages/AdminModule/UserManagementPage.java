package com.orangehrmlive.Pages.AdminModule;

import com.orangehrmlive.Components.PageMenuComponent;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManagementPage extends PageMenuComponent {

    public UserManagementPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //system users web elements
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    private WebElement usernameSearch;
    @FindBy(css = ".oxd-grid-item:nth-child(2) .oxd-select-text")
    private WebElement userRoleSearch;
    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement employeeNameSearch;
    @FindBy(css = ".oxd-grid-item:nth-child(4) .oxd-select-text")
    private WebElement statusSearch;
    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;


    //edit user web elements
    @FindBy(css = ".oxd-table-cell:nth-child(6) .oxd-icon-button:nth-child(2) .oxd-icon.bi-pencil-fill")
    private WebElement firstEditButton;
    @FindBy(css = ".oxd-grid-item:nth-of-type(1) .oxd-select-text")
    private WebElement userRoleEdit;
    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement employeeNameEdit;
    @FindBy(css = "div[role='listbox'] .oxd-autocomplete-option:nth-child(1)")
    private WebElement employeeNameDropdown;
    @FindBy(css = ".oxd-grid-item:nth-of-type(3) .oxd-select-text")
    private WebElement statusEdit;
    @FindBy(css = "input[autocomplete='off']")
    private WebElement usernameEdit;
    @FindBy(css = ".oxd-icon.bi-check.oxd-checkbox-input-icon")
    private WebElement changePasswordCheckbox;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters user-password-cell'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    private WebElement passwordEdit;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    private WebElement confirmPasswordEdit;
    @FindBy(css = ".oxd-button:nth-child(2)")
    private WebElement saveButtonEdit;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement cancelButton;


    //shared elements
    @FindBy(css = "span[class='oxd-text oxd-text--span']")
    private WebElement recordFound;
    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    private WebElement requiredMessage;
    @FindBy(className = "oxd-select-option")
    private List<WebElement> dropdown;


    //shared methods
    public void selectOption(@NotNull List<WebElement> dropdown, String select) {
        Iterator<WebElement> it = dropdown.iterator();
        while (it.hasNext()) {
            WebElement wb = it.next();
            if (wb.getText().equals(select)) {
                wb.click();
                break;
            }
        }
    }

    //system users input methods
    public void searchUsername(String input) {
        usernameSearch.sendKeys(input);
    }

    public void searchUserRole(String input) {
        userRoleSearch.click();
        selectOption(dropdown, input);
    }

    public void searchEmployeeName(String input) {
        employeeNameSearch.sendKeys(input);
    }

    public void searchStatus(String input) {
        statusSearch.click();
        selectOption(dropdown, input);
    }
    public void clickSearchButton() {
        searchButton.click();
    }


    //edit user input methods
    public void clickFirstEditButton() {
        firstEditButton.click();
    }

    public void editUserRole(String input) {
        userRoleEdit.click();
        selectOption(dropdown, input);
    }

    public void editEmployeeName(String input) throws InterruptedException {
        employeeNameEdit.sendKeys(input);
        Thread.sleep(2000);
        employeeNameDropdown.click();

    }

    public void editStatus(String input) {
        statusEdit.click();
        selectOption(dropdown, input);
    }

    public void editUsername(String input) {
        usernameEdit.sendKeys(input);
    }

    public void clickChangePassword() {
        changePasswordCheckbox.click();
    }

    public void editPassword(String input) {
        passwordEdit.sendKeys(input);
    }

    public void editConfirmPassword(String input) {
        confirmPasswordEdit.sendKeys(input);
    }

    public void clickSaveButtonEdit() {
        saveButtonEdit.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }


    //verification methods
    public boolean verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);
    }

    public boolean verifySearchMessage() {
        String actualMessage = getRecordFoundMessage();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(actualMessage);
        return matcher.find();
    }

    public boolean verifyRequiredMessage(String expectedMessage) {
        String actualMessage = getRequiredMessage();
        return actualMessage.equals(expectedMessage);
    }


    //get message methods
    public String getRecordFoundMessage() {
        return recordFound.getText();
    }

    public String getRequiredMessage() {
        return requiredMessage.getText();
    }
}

