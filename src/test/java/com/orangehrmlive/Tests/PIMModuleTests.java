package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.Pages.PIMModule.AddEmployeePage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import com.orangehrmlive.TestComponents.Initialization;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({com.orangehrmlive.Listeners.Listeners.class})
@Epic("PIM Module")
@Feature("PIM Tests")
public class PIMModuleTests extends Initialization {

    @Test
    public void addEmployeeTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");;
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        AddEmployeePage addEmployeePage = employeeListPage.goToAddEmployeePage();
        addEmployeePage.setFirstName("Jane");
        addEmployeePage.setMiddleName("Marie");
        addEmployeePage.setLastName("Doe");
        addEmployeePage.setId("9000");
        addEmployeePage.createLoginDetails();
        addEmployeePage.setUsername("janedoe1");
        addEmployeePage.setPassword("User123!");
        addEmployeePage.confirmPassword("User123!");
        addEmployeePage.save();

        addEmployeePage.waitUntilElementAppears();
        String actualMessage = addEmployeePage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"SuccessSuccessfully Saved ×");
    }
    @Test
    public void searchEmployeeTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.inputEmployeeName("Alice Duval");
        employeeListPage.inputEmployeeId("0221");
        employeeListPage.selectEmploymentStatus("Full-Time Contract");
        employeeListPage.selectJobTitle("Account Assistant");
        employeeListPage.selectSubUnit("Finance");
        employeeListPage.searchEmployee();

        Assert.assertTrue(employeeListPage.verifySearchMessage());
    }
    @Test
    public void negativeSearchEmployeeTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.inputEmployeeName("Alice Duval");
        employeeListPage.inputEmployeeId("0000");
        employeeListPage.selectEmploymentStatus("Full-Time Contract");
        employeeListPage.selectJobTitle("Account Assistant");
        employeeListPage.selectSubUnit("Finance");
        employeeListPage.searchEmployee();

        Assert.assertTrue(employeeListPage.verifyNoFoundMessage("No Records Found"));
    }

    @Test
    public void resetSearchTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.inputEmployeeName("Alice Duval");
        employeeListPage.inputEmployeeId("0221");
        employeeListPage.clickReset();

        Assert.assertTrue(employeeListPage.isFieldEmpty());
    }
}
