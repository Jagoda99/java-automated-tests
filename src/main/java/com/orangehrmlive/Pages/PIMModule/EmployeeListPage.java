package com.orangehrmlive.Pages.PIMModule;

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

public class EmployeeListPage extends PageMenuComponent {
    public EmployeeListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //web elements
    @FindBy(css = ".oxd-grid-item:nth-of-type(1) input[placeholder='Type for hints...']")
    private WebElement employeeName;
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    private WebElement employeeId;
    @FindBy(css =".oxd-grid-item:nth-of-type(3) .oxd-select-text")
    private WebElement employmentStatus;
    @FindBy(css=".oxd-grid-item:nth-of-type(4) .oxd-select-text")
    private WebElement include;
    @FindBy(css = ".oxd-grid-item:nth-of-type(5) input[placeholder='Type for hints...']")
    private WebElement supervisorName;
    @FindBy(css = "div[role='listbox'] .oxd-autocomplete-option:nth-child(1)")
    private WebElement supervisorNameDropdown;
    @FindBy(css =".oxd-grid-item:nth-of-type(6) .oxd-select-text")
    private WebElement jobTitle;
    @FindBy(css = ".oxd-grid-item:nth-of-type(7) .oxd-select-text")
    private WebElement subUnit;
    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;
    @FindBy(css = "button[type='reset']")
    private WebElement resetButton;
    @FindBy(css = ".oxd-icon.bi-plus.oxd-button-icon")
    private WebElement addButton;
    @FindBy(className = "oxd-select-option")
    private List<WebElement> dropdown;
    @FindBy(css = ".orangehrm-horizontal-padding .oxd-text")
    private WebElement recordFound;
    @FindBy(css = ".oxd-text .oxd-text--p .oxd-text--toast-message .oxd-toast-content-text")
    private WebElement noRecordFoundToaster;




    //input methods
    public void selectOption(@NotNull List<WebElement> dropdown, String select) {
        Iterator<WebElement> it = dropdown.iterator();
        while (it.hasNext()) {
            WebElement wb  = it.next();
            if(wb.getText().equals(select)) {
                wb.click();
                break;
            }
        }
    }
    public void inputEmployeeName(String input) {
        employeeName.sendKeys(input);
    }
    public void inputEmployeeId(String input) {
        employeeId.sendKeys(input);
    }
    public void selectInclude(String input) {
        include.click();
        selectOption(dropdown, input);
    }
    public void selectEmploymentStatus(String input) {
        employmentStatus.click();
        selectOption(dropdown, input);
    }
    public void inputSupervisorName(String input) throws InterruptedException {
        supervisorName.sendKeys(input);
        Thread.sleep(2000);
        supervisorNameDropdown.click();
    }
    public void selectJobTitle(String input) {
        jobTitle.click();
        selectOption(dropdown, input);
    }
    public void selectSubUnit(String input) {
        subUnit.click();
        selectOption(dropdown, input);
    }
    public void searchEmployee() {
        searchButton.click();
    }
    public AddEmployeePage goToAddEmployeePage() {
        addButton.click();
        return new AddEmployeePage(driver);
    }
    public void clickReset() {
        resetButton.click();
    }



    //verification methods
    public boolean isFieldEmpty() {
        String nameInput = employeeName.getText();
        String idInput = employeeId.getText();
        return nameInput.isEmpty() && idInput.isEmpty();
    }
    public boolean verifySearchMessage() {
        String actualMessage = getRecordFoundMessage();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(actualMessage);
        boolean result = matcher.find();
        return result;
    }
    public boolean verifyNoFoundMessage(String expectedMessage) {
        String actualMessage = getNoFoundMessage();
        return actualMessage.equals(expectedMessage);
    }
    public boolean verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);
    }


    //get message methods
    public String getRecordFoundMessage() {
        return recordFound.getText();
    }
    public String getNoFoundMessage() {
        return noRecordFoundToaster.getText();
    }
}
