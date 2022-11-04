package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.PIMModule.AddEmployee;
import com.orangehrmlive.Pages.PIMModule.EmployeeList;
import com.orangehrmlive.Pages.LoginPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class PIMModuleTests extends Initialization {

    @Test(dataProvider = "getData")
    public void searchEmployeeTest(String email, String password) throws IOException {

        LoginPage loginPage = launchApp();
        EmployeeList employeeList = loginPage.inputLoginInfo(email, password);
        employeeList.inputEmployeeName("Alice Duval");
        employeeList.inputEmployeeId("0221");
        employeeList.selectEmploymentStatus("Full-Time Contract");
        employeeList.inputSupervisorName("Kevin Mathews");
        employeeList.selectJobTitle("Account Assistant");
        employeeList.selectSubUnit("Finance");
        employeeList.searchEmployee();
    }
    @Test(dataProvider = "getData")
    public void addEmployeeTest(String email, String password) throws IOException {
        LoginPage loginPage = launchApp();
        EmployeeList employeeList = loginPage.inputLoginInfo(email, password);
        AddEmployee addEmployeePage = employeeList.goToAddEmployeePage();
        addEmployeePage.setFirstName("Jane");
        addEmployeePage.setMiddleName("Marie");
        addEmployeePage.setLastName("Doe");
        addEmployeePage.setId("2100");
        addEmployeePage.createLoginDetails();
        addEmployeePage.setUsername("janedoe");
        addEmployeePage.setPassword("User123!");
        addEmployeePage.confirmPassword("User123!");
    }
    @DataProvider
    public Object[][] getData() {

        return new Object[][] {{"Admin","admin123"}};
    }
}
