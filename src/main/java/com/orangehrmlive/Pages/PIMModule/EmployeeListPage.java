package com.orangehrmlive.Pages.PIMModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
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
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)")
    WebElement employeeName;
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement employeeId;
    @FindBy(css="body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    WebElement include;
    @FindBy(css ="body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")
    WebElement employmentStatus;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)")
    WebElement supervisorName;
    @FindBy(css ="body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    WebElement jobTitle;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
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
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(50) > div:nth-child(1) > div:nth-child(9) > div:nth-child(1) > button:nth-child(1) > i:nth-child(1)")
    WebElement deleteButton;
    @FindBy(className = "oxd-table-card")
    List <WebElement> table;



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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
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
