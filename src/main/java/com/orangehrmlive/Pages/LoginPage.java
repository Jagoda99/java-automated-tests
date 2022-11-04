package com.orangehrmlive.Pages;

import com.orangehrmlive.Components.AbstractComponents;
import com.orangehrmlive.Pages.PIMModule.EmployeeList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {
    public static WebDriver driver;

    public LoginPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement passwordEl;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//div[@class='oxd-alert-content oxd-alert-content--error']")
    WebElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }
    public EmployeeList inputLoginInfo(String email, String password) {

        username.sendKeys(email);
        passwordEl.sendKeys(password);
        submit.click();
        return new EmployeeList(driver);

    }
}