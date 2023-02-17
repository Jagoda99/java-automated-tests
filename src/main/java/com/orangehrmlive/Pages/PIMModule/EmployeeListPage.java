package com.orangehrmlive.Pages.PIMModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeListPage extends AbstractComponents {
    WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //web elements
    @FindBy(css = ".oxd-grid-item:nth-of-type(1) input[placeholder='Type for hints...']")
    WebElement employeeName;
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement employeeId;
    @FindBy(css =".oxd-grid-item:nth-of-type(3) .oxd-select-text")
    WebElement employmentStatus;
    @FindBy(css=".oxd-grid-item:nth-of-type(4) .oxd-select-text")
    WebElement include;
    @FindBy(css = "oxd-grid-item:nth-of-type(5) input[placeholder='Type for hints...']")
    WebElement supervisorName;
    @FindBy(css =".oxd-grid-item:nth-of-type(6) .oxd-select-text")
    WebElement jobTitle;
    @FindBy(css = ".oxd-grid-item:nth-of-type(7) .oxd-select-text")
    WebElement subUnit;
    @FindBy(css = "button[type='submit']")
    WebElement searchButton;
    @FindBy(css = "button[type='reset']")
    WebElement resetButton;
    @FindBy(css = ".oxd-icon.bi-plus.oxd-button-icon")
    WebElement addButton;
    @FindBy(className = "oxd-select-option")
    List<WebElement> dropdown;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    WebElement recordFound;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement noRecordFoundToaster;




    //input methods
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
    public void inputSupervisorName(String input) {
        supervisorName.sendKeys(input);
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


    // return messages
    public String getRecordFoundMessage() {
        return recordFound.getText();
    }
    public String getNoFoundMessage() {
        return noRecordFoundToaster.getText();
    }
}
