package com.orangehrmlive.Pages.AdminModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement saveButton;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']")
    WebElement successfullySaved;



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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='option'])[2]")));
        employeeNameXpath.sendKeys(Keys.DOWN, Keys.DOWN, Keys.RETURN);
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
    public void clickSaveButton() {
        saveButton.click();
    }

    //return messages
    public void waitUntilElementAppears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")));
    }
    public String getSuccessfullySaved() {
        return successfullySaved.getText();

    }
}

