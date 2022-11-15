package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.AdminModule.UserManagementPage;
import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.Pages.LoginModule.LoginPage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminModuleTests extends Initialization {
    @Test(dataProvider = "getData")
    public void addUserTest(String email, String password) throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputLoginInfo(email, password);
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        UserManagementPage userManagementPage = employeeListPage.goToAdminModule();
        userManagementPage.addUser();
        userManagementPage.selectUserRole("ESS");
        userManagementPage.setName("Jane Marie Doe");
        userManagementPage.selectStatus("Enabled");
        userManagementPage.setUserName("janed");
        userManagementPage.setPassword("User123!");
        userManagementPage.confirmPassword("User123!");
        userManagementPage.save();
    }
    @DataProvider
    public Object[][] getData() {

        return new Object[][] {{"Admin","admin123"}};
    }
}
