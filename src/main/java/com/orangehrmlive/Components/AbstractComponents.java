package com.orangehrmlive.Components;

import com.orangehrmlive.Pages.Admin.UserManagement;
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
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Admin'])[1]")
    WebElement adminButton;
    public void goTo(String url) {

        driver.get(url);
        System.out.println("Page is opened.");
    }
    public void selectOption(List<WebElement> dropdown, String select) {
        Iterator<WebElement> it = dropdown.iterator();
        while (it.hasNext()) {
            WebElement wb  = it.next();
            if(wb.getText().equals(select)) {
                wb.click();
                break;
            }
        }
    }
    public UserManagement goToAdminModule() {
        adminButton.click();
        return new UserManagement(driver);
    }
}
