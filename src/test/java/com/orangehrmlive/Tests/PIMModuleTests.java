package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.Pages.PIMModule.AddEmployeePage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import com.orangehrmlive.Pages.LoginModule.LoginPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.regex.*;
import java.io.IOException;


public class PIMModuleTests extends Initialization {

    @Test
    public void addEmployeeTest() throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");;
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        AddEmployeePage addEmployeePage = employeeListPage.goToAddEmployeePage();
        addEmployeePage.setFirstName("Jane");
        addEmployeePage.setMiddleName("Marie");
        addEmployeePage.setLastName("Doe");
        addEmployeePage.setId("9001");
        addEmployeePage.createLoginDetails();
        addEmployeePage.setUsername("janedoe");
        addEmployeePage.setPassword("User123!");
        addEmployeePage.confirmPassword("User123!");
        addEmployeePage.save();

        addEmployeePage.waitUntilElementAppears();
        String actualMessage = addEmployeePage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }
    @Test
    public void searchEmployeeTest() throws IOException {

        LoginPage loginPage = launchApp();
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

        String actualMessage = employeeListPage.getRecordFoundMessage();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(actualMessage);
        boolean result = matcher.find();
        System.out.println(result);
        Assert.assertTrue(result);
    }
    @Test
    public void negativeSearchEmployeeTest() throws IOException {

        LoginPage loginPage = launchApp();
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

        String actualMessage = employeeListPage.getNoFoundMessage();
        Assert.assertEquals(actualMessage,"No Records Found");
    }

}
