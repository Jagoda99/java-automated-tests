package com.orangehrmlive.Pages.PIMModule;

import com.orangehrmlive.Components.PageMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage extends PageMenuComponent {
    public AddEmployeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


//web elements
    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameInput;
    @FindBy(css = "input[placeholder='Middle Name']")
    private WebElement middleNameInput;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameInput;
    @FindBy(css = ".oxd-form-row:nth-child(1) .oxd-grid-2 .oxd-input")
    private WebElement idInput;
    @FindBy(css = ".oxd-switch-input.oxd-switch-input--active.--label-right")
    private WebElement detailsButton;
    @FindBy(css = ".oxd-form-row:nth-child(4) .oxd-input")
    private WebElement usernameInput;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters user-password-cell'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    private WebElement passwordInput;
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    private WebElement confirmPasswordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text")
    private WebElement successfullySaved;
    @FindBy(css = ".oxd-input-group.oxd-input-field-bottom-space:nth-child(1) .oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    private WebElement firstRequiredMessage;
    @FindBy(css = ".oxd-input-group.oxd-input-field-bottom-space:nth-child(3) .oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    private WebElement lastRequiredMessage;


    //input methods
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
    public void clickSaveButton() {
        saveButton.click();
    }



//verification methods
    public boolean verifySuccessfullySavedMessage(String expectedMessage) {
        String actualMessage = getSuccessfullySaved();
        return actualMessage.equals(expectedMessage);
    }
    public boolean verifyFirstRequiredMessage(String expectedMessage) {
        String firstMessage = getRequiredMessage(firstRequiredMessage);
        return firstMessage.equals(expectedMessage);
    }
    public boolean verifyLastRequiredMessage(String expectedMessage){
        String lastMessage = getRequiredMessage(lastRequiredMessage);
        return lastMessage.equals(expectedMessage);
    }



//get message methods
    public void waitUntilElementAppears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-toast.oxd-toast--success.oxd-toast-container--toast")));
    }
    public String getSuccessfullySaved() {
        return successfullySaved.getText();
    }
    public String getRequiredMessage(WebElement message) {return message.getText();}
}
