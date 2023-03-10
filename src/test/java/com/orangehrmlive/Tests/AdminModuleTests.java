package com.orangehrmlive.Tests;

import com.orangehrmlive.Listeners.Listener;
import com.orangehrmlive.Pages.AdminModule.UserManagementPage;
import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.TestComponents.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
@Epic("Admin Module")
@Feature("Admin Tests")
public class AdminModuleTests extends BaseTest {
    @Test
    public void adminPageTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

    }
    @Test
    public void searchUsernameTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchUsername("Alice.Duval");
        userManagementPage.clickSearchButton();

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void searchUserRoleTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchUserRole("Admin");
        userManagementPage.clickSearchButton();

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void searchEmployeeNameTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchEmployeeName("Alice Duval");

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void searchStatusTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.searchStatus("Enabled");

        Assert.assertTrue(userManagementPage.verifySearchMessage());
    }
    @Test
    public void editUserRoleTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editUserRole("Admin");
        userManagementPage.clickSaveButtonEdit();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

    }
    @Test
    public void editEmployeeNameTest() throws InterruptedException {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editEmployeeName("Jane Doe");
        userManagementPage.clickSaveButtonEdit();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

    }
    @Test
    public void editUsernameTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editUsername("admin");
        userManagementPage.clickSaveButtonEdit();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

    }
    @Test
    public void editStatusTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editStatus("Disabled");
        userManagementPage.clickSaveButtonEdit();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
    }
    @Test
    public void changePasswordTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.clickChangePassword();
        userManagementPage.editPassword("User123!");
        userManagementPage.editConfirmPassword("User123!");
        userManagementPage.clickSaveButtonEdit();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

    }
    @Test
    public void userRoleBlankSpaceTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.editUserRole("-- Select --");

        Assert.assertTrue(userManagementPage.verifyRequiredMessage("Required"));

    }
    @Test
    public void cancelEditTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        UserManagementPage userManagementPage = dashboardPage.goToAdminModule();
        userManagementPage.clickFirstEditButton();
        userManagementPage.clickCancelButton();

        Assert.assertTrue(userManagementPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
    }

}
