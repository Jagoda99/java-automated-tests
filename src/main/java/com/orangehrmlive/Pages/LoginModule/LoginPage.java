package com.orangehrmlive.Pages.LoginModule;

import com.orangehrmlive.Components.AbstractComponents;
import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement usernameEl;
    @FindBy(name = "password")
    WebElement passwordEl;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    WebElement forgotPasswordXpath;
    @FindBy(xpath = "//button[normalize-space()='Reset Password']")
    WebElement resetButton;
    @FindBy(xpath = "//div[@class='oxd-alert-content oxd-alert-content--error']")
    WebElement errorMessage;
    @FindBy(xpath = "//h6[normalize-space()='Reset Password link sent successfully']")
    WebElement resetPasswordMessage;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(2) > div:nth-child(1) > span:nth-child(3)")
    WebElement inputUsernameErrorMessage;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(3)")
    WebElement inputPasswordErrorMessage;

    public void inputUsername(String username) {
        usernameEl.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordEl.sendKeys(password);
    }

    public void goToForgotPassword() {
        forgotPasswordXpath.click();
    }

    public void clickResetButton() {
        resetButton.click();
    }

    public void switchCursor() {
        usernameEl.sendKeys(Keys.TAB);
    }
    public void copyElement() {
        passwordEl.sendKeys(Keys.chord(Keys.CONTROL, "a"),(Keys.chord(Keys.CONTROL, "c")));
    }
    public DashboardPage goToDashboard() {
        submitButton.click();
        return new DashboardPage(driver);
    }


    //verify methods
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

    public String getLoginErrorMessage() {
        return errorMessage.getText();
    }

    public String getResetPasswordMessage() {
        return resetPasswordMessage.getText();
    }

    public String getInputUsernameErrorMessage() {
        return inputUsernameErrorMessage.getText();
    }

    public String getInputPasswordErrorMessage() {
        return inputPasswordErrorMessage.getText();
    }

    public boolean checkMaskedPassword() {
        return passwordEl.getAttribute("type").equals("password");
    }
}