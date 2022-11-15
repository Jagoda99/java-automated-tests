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

    @Test(dataProvider = "getData")
    public void searchEmployeeTest(String email, String password) throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputLoginInfo(email, password);
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
    @Test(dataProvider = "getData")
    public void negativeSearchEmployeeTest(String email, String password) throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputLoginInfo(email, password);
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
    @Test(dataProvider = "getData")
    public void addEmployeeTest(String email, String password) throws IOException {
        LoginPage loginPage = launchApp();
        loginPage.inputLoginInfo(email, password);
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        AddEmployeePage addEmployeePage = employeeListPage.goToAddEmployeePage();
        addEmployeePage.setFirstName("Jane");
        addEmployeePage.setMiddleName("Marie");
        addEmployeePage.setLastName("Doe");
        addEmployeePage.setId("53455544");
        addEmployeePage.createLoginDetails();
        addEmployeePage.setUsername("janedoe45");
        addEmployeePage.setPassword("User123!");
        addEmployeePage.confirmPassword("User123!");
        addEmployeePage.save();

        addEmployeePage.waitUntilElementAppears();
        String actualMessage = addEmployeePage.getSuccessfullySaved();
        Assert.assertEquals(actualMessage,"Success");
    }

    @DataProvider
    public Object[][] getData() {

        return new Object[][] {{"Admin","admin123"}};
    }
}
