package com.orangehrmlive.Pages.PIMModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee extends AbstractComponents {
    public static WebDriver driver;

    public AddEmployee(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middleNameInput;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameInput;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement idInput;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    WebElement detailsButton;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    WebElement usernameInput;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordInput;



    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }
    public void setMiddleName(String middleName) {
        middleNameInput.sendKeys(middleName);
    }
    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }
    public void setId(String id) {
        idInput.sendKeys(Keys.chord(Keys.CONTROL, "a"),id);
        //idInput.sendKeys(id);
    }
    public void save() {
        saveButton.click();
    }
    public void cancel() {
        cancelButton.click();
    }
    public void createLoginDetails() {
        detailsButton.click();
    }
    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void confirmPassword(String password) {
        confirmPasswordInput.sendKeys(password);
    }
}
