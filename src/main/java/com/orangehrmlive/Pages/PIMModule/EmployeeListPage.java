package com.orangehrmlive.Pages.PIMModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class EmployeeListPage extends AbstractComponents {
    WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //web elements
    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    WebElement employeeNameXpath;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement employeeIdXpath;
    @FindBy(xpath="(//div[contains(text(),'Current Employees Only')])[1]")
    WebElement includeXpath;
    @FindBy(xpath ="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement employmentStatusXpath;
    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
    WebElement supervisorNameXpath;
    @FindBy(xpath ="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement jobTitleXpath;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement subUnitXpath;
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//button[@type='reset']")
    WebElement resetButton;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;
    @FindBy(className = "oxd-select-option")
    List<WebElement> dropdown;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    WebElement recordFoundXpath;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement noRecordFoundToaster;


    //input methods
    public void inputEmployeeName(String input) {
        employeeNameXpath.sendKeys(input);
    }
    public void inputEmployeeId(String input) {
        employeeIdXpath.sendKeys(input);
    }
    public void selectInclude(String input) {
        includeXpath.click();
        selectOption(dropdown, input);
    }
    public void selectEmploymentStatus(String input) {
        employmentStatusXpath.click();
        selectOption(dropdown, input);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    public void inputSupervisorName(String input) {
        supervisorNameXpath.sendKeys(input);
    }
    public void selectJobTitle(String input) {
        jobTitleXpath.click();
        selectOption(dropdown, input);
    }
    public void selectSubUnit(String input) {
        subUnitXpath.click();
        selectOption(dropdown, input);
    }
    public void searchEmployee() {
        searchButton.click();
    }
    public AddEmployeePage goToAddEmployeePage() {
        addButton.click();
        return new AddEmployeePage(driver);
    }




    // return messages
    public String getRecordFoundMessage() {
        return recordFoundXpath.getText();
    }
    public String getNoFoundMessage() {
        return noRecordFoundToaster.getText();
    }
}
