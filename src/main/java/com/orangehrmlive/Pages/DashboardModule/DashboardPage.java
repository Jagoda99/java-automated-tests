package com.orangehrmlive.Pages.DashboardModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends AbstractComponents {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
