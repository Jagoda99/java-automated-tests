package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.Admin.UserManagement;
import com.orangehrmlive.Pages.LoginPage;
import com.orangehrmlive.Pages.PIMModule.EmployeeList;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminModuleTests extends Initialization {
    @Test(dataProvider = "getData")
    public void addUserTest(String email, String password) throws IOException {

        LoginPage loginPage = launchApp();
        EmployeeList employeeList = loginPage.inputLoginInfo(email, password);
        UserManagement userManagementpage = employeeList.goToAdminModule();
        userManagementpage.addUser();
        userManagementpage.selectUserRole("ESS");
        userManagementpage.setName("Jane Doe");
        userManagementpage.selectStatus("Enabled");
        userManagementpage.setUserName("janedoe");
        userManagementpage.setPassword("User123!");
        userManagementpage.confirmPassword("User123!");
    }
    @DataProvider
    public Object[][] getData() {

        return new Object[][] {{"Admin","admin123"}};
    }
}
