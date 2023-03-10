package com.orangehrmlive.Pages.DashboardModule;

import com.orangehrmlive.Components.PageMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends PageMenuComponent {
    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
