package com.orangehrmlive.Pages.AdminModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManagementPage extends AbstractComponents {
    public WebDriver driver;

    public UserManagementPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


//shared elements
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    WebElement recordFound;
    @FindBy(css = ".oxd-toast.oxd-toast--success.oxd-toast-container--toast")
    WebElement successfullySaved;
    @FindBy(className = "oxd-select-option")
    List<WebElement> dropdown;
    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    WebElement requiredMessage;



//system users web elements
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement usernameSearch;
    @FindBy(css = ".oxd-grid-item:nth-child(2) .oxd-select-text")
    WebElement userRoleSearch;
    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement employeeNameSearch;
    @FindBy(css = ".oxd-grid-item:nth-child(4) .oxd-select-text")
    WebElement statusSearch;
    @FindBy(css = "button[type='submit']")
    WebElement searchButton;



//edit user web elements
    @FindBy(css = "oxd-icon-button:nth-of-type(1) .oxd-icon.bi-pencil-fill")
    WebElement firstEditButton;
    @FindBy(css = ".oxd-grid-item:nth-of-type(1) .oxd-select-text")
    WebElement userRoleEdit;
    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement employeeNameEdit;
    @FindBy(css = ".oxd-grid-item:nth-of-type(3) .oxd-select-text")
     WebElement statusEdit;
    @FindBy(css = "input[autocomplete='off']")
    WebElement usernameEdit;
    @FindBy(css = ".oxd-icon.bi-check.oxd-checkbox-input-icon")
    WebElement changePasswordCheckbox;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters user-password-cell'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    WebElement passwordEdit;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    WebElement confirmPasswordEdit;
    @FindBy(css = "button[type='submit']")
    WebElement saveButtonEdit;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--ghost']")
    WebElement cancelButton;


//add employee web elements
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;
    @FindBy(css = ".oxd-grid-item:nth-of-type(1) .oxd-select-text")
    WebElement userRoleAdd;
    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement employeeNameAdd;
    @FindBy(css = ".oxd-grid-item:nth-of-type(3) .oxd-select-text")
    WebElement statusAdd;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement usernameAdd;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters user-password-cell'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    WebElement passwordAdd;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    WebElement confirmPasswordAdd;
    @FindBy(css = "button[type='submit']")
    WebElement saveButtonAdd;
    @FindBy (css = "header[class='oxd-topbar'] li:nth-child(2) span:nth-child(1)")
    WebElement jobButton;
    @FindBy(css = "li[class='--active oxd-topbar-body-nav-tab --parent'] li:nth-child(5) a:nth-child(1)")
    WebElement workShiftButton;



//system users input methods
    public void searchUsername(String input) {
        usernameSearch.sendKeys(input);
    }
    public void searchUserRole(String input) {
        userRoleSearch.click();
        selectOption(dropdown,input);
    }
    public void searchEmployeeName(String  input) {
        employeeNameSearch.sendKeys(input);
    }
    public void searchStatus(String input) {
        statusSearch.click();
        selectOption(dropdown,input);
    }
    public void clickSearchButton() {
        searchButton.click();
    }


//edit user input methods
    public void clickFirstEditButton() {
        firstEditButton.click();
    }
    public void editUserRole (String input) {
        userRoleEdit.click();
        selectOption(dropdown,input);
    }
    public void editEmployeeName (String input) {
        employeeNameEdit.sendKeys(input);
    }
    public void editStatus (String input) {
        statusEdit.click();
        selectOption(dropdown,input);
    }
    public void editUsername (String input) {
        usernameEdit.sendKeys(input);
    }
    public void clickChangePassword () {
        changePasswordCheckbox.click();
    }
    public void editPassword (String input) {
        passwordEdit.sendKeys(input);
    }
    public void editConfirmPassword (String input) {
        confirmPasswordEdit.sendKeys(input);
    }
    public void clickSaveButtonEdit() {
        saveButtonEdit.click();
    }
    public void clickCancelButton() {
        cancelButton.click();
    }
    public void deleteEmployeeNameInput() {
        employeeNameEdit.sendKeys(Keys.chord(Keys.CONTROL, "a"),(Keys.DELETE));
    }
    public void deleteUsernameInput() {
        employeeNameEdit.sendKeys(Keys.chord(Keys.CONTROL, "a"),(Keys.DELETE));
    }



//add employee input methods
    public void clickAddUser() {
        addButton.click();
    }
    public void addUserRole(String input) {
        userRoleAdd.click();
        selectOption(dropdown, input);
    }
    public void addEmployeeName(String name) {
        employeeNameAdd.sendKeys(name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='option'])[2]")));
        employeeNameAdd.sendKeys(Keys.DOWN, Keys.DOWN, Keys.RETURN);
    }
    public void addStatus(String input) {
        statusAdd.click();
        selectOption(dropdown, input);
    }
    public void addUsername(String name) {
        usernameAdd.sendKeys(name);
    }
    public void addPassword(String passwordAdd) {
        this.passwordAdd.sendKeys(passwordAdd);
    }
    public void addConfirmPassword(String password) {
        confirmPasswordAdd.sendKeys(password);
    }
    public void clickSaveButtonAdd() {
        saveButtonAdd.click();
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
        boolean result = matcher.find();
        return result;
    }

//return messages
    public void waitUntilElementAppears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")));
    }
    public String getSuccessfullySaved() {
        return successfullySaved.getText();
    }
    public String getRecordFoundMessage() {
        return recordFound.getText();
    }


//go to methods
    public JobPage goToWorkShiftList() {
        jobButton.click();
        workShiftButton.click();
        return new JobPage(driver);
    }
}

