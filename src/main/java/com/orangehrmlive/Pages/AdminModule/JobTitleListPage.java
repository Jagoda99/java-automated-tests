package com.orangehrmlive.Pages.AdminModule;

import com.orangehrmlive.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JobTitleListPage extends AbstractComponents {
    public WebDriver driver;

    public JobTitleListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
