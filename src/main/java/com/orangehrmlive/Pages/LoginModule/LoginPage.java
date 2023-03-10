package com.orangehrmlive.Pages.LoginModule;

import com.orangehrmlive.Components.PageMenuComponent;
import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageMenuComponent {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



//web elements
    @FindBy(name = "username")
    private WebElement usernameEl;
    @FindBy(name = "password")
    private WebElement passwordEl;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;
    @FindBy(css = ".oxd-text.oxd-text--p.orangehrm-login-forgot-header")
    private WebElement forgotPassword;
    @FindBy(css = "button[type='submit']")
    private WebElement resetButton;
    @FindBy(css = ".oxd-alert-content.oxd-alert-content--error")
    private WebElement errorMessage;
    @FindBy(css = ".oxd-text.oxd-text--h6.orangehrm-forgot-password-title")
    private WebElement resetPasswordMessage;
    @FindBy(css = ".oxd-form-row:nth-child(2) .oxd-input-group .oxd-text")
    private WebElement usernameRequiredMessage;
    @FindBy(css = ".oxd-form-row:nth-child(3) .oxd-input-group .oxd-text")
    private WebElement passwordRequiredMessage;



//methods
    public void inputUsername(String username) {
        usernameEl.sendKeys(username);
    }
    public void inputPassword(String password) {
        passwordEl.sendKeys(password);
    }
    public void goToForgotPassword() {
        forgotPassword.click();
    }
    public void clickResetButton() {
        resetButton.click();
    }
    public void switchCursor() {
        usernameEl.sendKeys(Keys.TAB);
    }
    public DashboardPage goToDashboard() {
        submitButton.click();
        return new DashboardPage(driver);
    }



//verification methods
    public boolean verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);
    }
    public boolean verifyLoginMessage(String expectedMessage) {
        String actualMessage = getLoginErrorMessage();
        return actualMessage.equals(expectedMessage);
    }
    public boolean verifyResetPasswordMessage(String expectedMessage) {
        String actualMessage = getResetPasswordMessage();
        return actualMessage.equals(expectedMessage);
    }
    public boolean verifyUsernameInputMessage(String expectedMessage) {
        String actualMessage = getInputUsernameErrorMessage();
        return actualMessage.equals(expectedMessage);
    }
    public boolean verifyPasswordInputMessage(String expectedMessage) {
        String actualMessage = getInputPasswordErrorMessage();
        return actualMessage.equals(expectedMessage);
    }
    public boolean isCursorInUsernameField() {
        return usernameEl.equals(driver.switchTo().activeElement());
    }
    public boolean isCursorInPasswordField() {
        return passwordEl.equals(driver.switchTo().activeElement());
    }
    public boolean checkMaskedPassword() {
        return passwordEl.getAttribute("type").equals("password");
    }



//get message methods
    public String getLoginErrorMessage() {
        return errorMessage.getText();
    }
    public String getResetPasswordMessage() {
        return resetPasswordMessage.getText();
    }
    public String getInputUsernameErrorMessage() {
        return usernameRequiredMessage.getText();
    }
    public String getInputPasswordErrorMessage() {
        return passwordRequiredMessage.getText();
    }
}