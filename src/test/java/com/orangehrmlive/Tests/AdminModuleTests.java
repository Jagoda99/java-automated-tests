package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.AdminModule.UserManagementPage;
import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.Pages.LoginModule.LoginPage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminModuleTests extends Initialization {
    @Test
    public void addUserTest() throws IOException, InterruptedException {

        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        UserManagementPage userManagementPage = employeeListPage.goToAdminModule();
        userManagementPage.addUser();
        userManagementPage.selectUserRole("ESS");
        userManagementPage.setName("Jane Marie Doe");
        userManagementPage.selectStatus("Enabled");
        userManagementPage.setUserName("janedoe23");
        userManagementPage.setPassword("User123!");
        userManagementPage.confirmPassword("User123!");
        Thread.sleep(2000);
        userManagementPage.clickSaveButton();

        userManagementPage.waitUntilElementAppears();
        String actualMessage = userManagementPage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }
}
