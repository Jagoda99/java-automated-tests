package com.orangehrmlive.Pages.AdminModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage extends AbstractComponents {
    public WebDriver driver;

    public UserManagementPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //web elements
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement userRoleXpath;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameXpath;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement statusXpath;
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement usernameXpath;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement passwordXpath;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordXpath;
    @FindBy(className = "oxd-select-option")
    List<WebElement> dropdown;


    //input methods
    public void addUser() {
        addButton.click();
    }
    public void selectUserRole(String input) {
        userRoleXpath.click();
        selectOption(dropdown, input);
    }
    public void setName(String name) {
        employeeNameXpath.sendKeys(name);
    }
    public void selectStatus(String input) {
        statusXpath.click();
        selectOption(dropdown, input);
    }
    public void setUserName(String name) {
        usernameXpath.sendKeys(name);
    }
    public void setPassword(String password) {
        passwordXpath.sendKeys(password);
    }
    public void confirmPassword(String password) {
        confirmPasswordXpath.sendKeys(password);
    }



}
