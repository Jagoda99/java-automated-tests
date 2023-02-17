package com.orangehrmlive.Pages.AdminModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobPage extends AbstractComponents {
    public WebDriver driver;

    public JobPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".oxd-icon.bi-pencil-fill")
    WebElement generalEditButton;
    @FindBy(css = "div[class='oxd-grid-2 orangehrm-full-width-grid'] div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement shiftName;
    @FindBy(css = "button[type='submit']")
    WebElement saveButton;

    public void clickGeneralShiftEdit() {
        generalEditButton.click();
    }
    public void changeShiftName() {
        shiftName.sendKeys(Keys.chord(Keys.CONTROL, "a"),"General Shift");
    }
    public void clickSave() {
        saveButton.click();
    }
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']")
    WebElement successfullySaved;
    public void waitUntilElementAppears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")));
    }
    public boolean verifySuccessMessage(String expectedMessage) {
        String actualMessage = getSuccessfullySaved();
        return actualMessage.equals(expectedMessage);
    }
    public String getSuccessfullySaved() {
        return successfullySaved.getText();
    }
}


