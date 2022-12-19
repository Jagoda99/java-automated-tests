package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.AdminModule.UserManagementPage;
import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.Pages.LoginModule.LoginPage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminModuleTests extends Initialization {
    @Test
    public void adminPageTest() throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

    }
    @Test
    public void searchUsernameTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchUsername("Alice.Duval");
        userManagementPage.clickSearchButton();

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void searchUserRoleTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchUserRole("Admin");
        userManagementPage.clickSearchButton();

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void searchEmployeeNameTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchEmployeeName("Alice Duval");

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void searchStatusTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchStatus("Enabled");

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void editUserRoleTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editUserRole("Admin");
        userManagementPage.clickSaveButtonEdit();

        userManagementPage.waitUntilElementAppears();
        String actualMessage = userManagementPage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");


    }
    @Test
    public void editEmployeeNameTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editEmployeeName("Jane Doe");
        userManagementPage.clickSaveButtonEdit();

        userManagementPage.waitUntilElementAppears();
        String actualMessage = userManagementPage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }
    @Test
    public void editUsernameTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editUsername("admin");
        userManagementPage.clickSaveButtonEdit();

        userManagementPage.waitUntilElementAppears();
        String actualMessage = userManagementPage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }
    @Test
    public void editStatusTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editStatus("Disabled");
        userManagementPage.clickSaveButtonEdit();

        userManagementPage.waitUntilElementAppears();
        String actualMessage = userManagementPage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }
    @Test
    public void changePasswordTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.clickChangePassword();
        userManagementPage.editPassword("User123!");
        userManagementPage.editConfirmPassword("User123!");
        userManagementPage.clickSaveButtonEdit();

        userManagementPage.waitUntilElementAppears();
        String actualMessage = userManagementPage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }
    @Test
    public void cancelEditTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.clickCancelButton();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
    }
    @Test
    public void UserRoleBlankSpaceTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();

    }
    @Test
    public void addUserTest() throws IOException, InterruptedException {

        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        UserManagementPage userManagementPage = employeeListPage.goToAdminModule();
        userManagementPage.clickAddUser();
        userManagementPage.addUserRole("ESS");
        userManagementPage.addEmployeeName("Jane Marie Doe");
        userManagementPage.addStatus("Enabled");
        userManagementPage.addUsername("janedoe23");
        userManagementPage.addPassword("User123!");
        userManagementPage.addConfirmPassword("User123!");
        Thread.sleep(2000);
        userManagementPage.clickSaveButtonAdd();

        userManagementPage.waitUntilElementAppears();
        String actualMessage = userManagementPage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }
}
