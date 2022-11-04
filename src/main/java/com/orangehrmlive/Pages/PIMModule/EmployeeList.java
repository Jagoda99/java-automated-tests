package com.orangehrmlive.Pages.PIMModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class EmployeeList extends AbstractComponents {
    WebDriver driver;

    public EmployeeList(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    WebElement employeeNameXpath;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement employeeIdXpath;
    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
    WebElement supervisorNameXpath;
    @FindBy(xpath="(//div[contains(text(),'Current Employees Only')])[1]")
   WebElement includeXpath;
    @FindBy(xpath ="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement employmentStatusXpath;
    @FindBy(xpath ="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement jobTitleXpath;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement subUnitXpath;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;
    @FindBy(xpath = "//button[@type='reset']")
    WebElement resetButton;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;
    @FindBy(className = "oxd-select-option")
    List<WebElement> dropdown;


    public void inputEmployeeName(String name) {
        employeeNameXpath.sendKeys(name);
    }
    public void inputEmployeeId(String id) {
        employeeIdXpath.sendKeys(id);
    }
    public void selectInclude(String include) {
        includeXpath.click();
        selectOption(dropdown, include);
    }
    public void selectEmploymentStatus(String status) {
        employmentStatusXpath.click();
        selectOption(dropdown, status);
    }
    public void inputSupervisorName(String supervisorName) {
        supervisorNameXpath.sendKeys(supervisorName);
    }
    public void selectJobTitle(String jobTitle) {
        jobTitleXpath.click();
        selectOption(dropdown, jobTitle);
    }
    public void selectSubUnit(String subUnit) {
        subUnitXpath.click();
        selectOption(dropdown, subUnit);
    }
    public void searchEmployee() {
        searchButton.click();
    }
    public AddEmployee goToAddEmployeePage() {
        addButton.click();
        return new AddEmployee(driver);
    }
}
