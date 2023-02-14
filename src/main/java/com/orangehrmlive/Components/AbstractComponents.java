package com.orangehrmlive.Components;

import com.orangehrmlive.Pages.AdminModule.UserManagementPage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class AbstractComponents {
    WebDriver driver;
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //abstract methods
    public void goTo(String url) {
        driver.get(url);
    }

    public void selectOption(@NotNull List<WebElement> dropdown, String select) {
        Iterator<WebElement> it = dropdown.iterator();
        while (it.hasNext()) {
            WebElement wb  = it.next();
            if(wb.getText().equals(select)) {
                wb.click();
                break;
            }
        }
    }



    //navbar items
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Admin'])[1]")
    WebElement adminButton;
    public UserManagementPage goToAdminModule() {
        adminButton.click();
        return new UserManagementPage(driver);
    }
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM'])")
    WebElement PIMButton;
    public EmployeeListPage goToPIMModule() {
            PIMButton.click();
        return new EmployeeListPage(driver);
    }



    //abstract buttons
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    public void submit() {
        submitButton.click();
    }
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;
    public void save() {
        saveButton.click();
    }
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;
    public void cancel() {
        cancelButton.click();
    }



}
