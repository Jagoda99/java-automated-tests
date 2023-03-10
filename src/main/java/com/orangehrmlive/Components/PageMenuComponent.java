package com.orangehrmlive.Components;

import com.orangehrmlive.Pages.AdminModule.UserManagementPage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMenuComponent {
    public WebDriver driver;

    public PageMenuComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".oxd-main-menu-item-wrapper:nth-child(1) .oxd-text")
    private WebElement adminButton;
    @FindBy(css = ".oxd-main-menu-item-wrapper:nth-child(2) .oxd-text")
    private WebElement PIMButton;

    public UserManagementPage goToAdminModule() {
        adminButton.click();
        return new UserManagementPage(driver);
    }

    public EmployeeListPage goToPIMModule() {
        PIMButton.click();
        return new EmployeeListPage(driver);
    }
}
