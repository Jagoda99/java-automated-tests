package com.orangehrmlive.Tests;

import com.orangehrmlive.Listeners.Listener;
import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.Pages.PIMModule.AddEmployeePage;
import com.orangehrmlive.Pages.PIMModule.EmployeeListPage;
import com.orangehrmlive.TestComponents.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({Listener.class})
@Epic("PIM Module")
@Feature("PIM Tests")
public class PIMModuleTests extends BaseTest {


    @Test
    public void pimPageTest(){
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();

        Assert.assertTrue(employeeListPage.verifyUrl("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList"));
    }
    @Test
    public void searchEmployeeNameTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.inputEmployeeName("Alice Duval");
        employeeListPage.searchEmployee();

        Assert.assertTrue(employeeListPage.verifySearchMessage());
    }
    @Test
    public void searchEmployeeIdTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.inputEmployeeId("0221");
        employeeListPage.searchEmployee();

        Assert.assertTrue(employeeListPage.verifySearchMessage());
    }
    @Test
    public void searchEmploymentStatusTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.selectEmploymentStatus("Full-Time Contract");
        employeeListPage.searchEmployee();

        Assert.assertTrue(employeeListPage.verifySearchMessage());
    }
    @Test
    public void searchIncludeTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.selectInclude("Current And Past Employees");
        employeeListPage.searchEmployee();

        Assert.assertTrue(employeeListPage.verifySearchMessage());
    }
    @Test
    public void searchSupervisorNameTest() throws InterruptedException {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.inputSupervisorName("Odis Adalwin");
        employeeListPage.searchEmployee();

        Assert.assertTrue(employeeListPage.verifySearchMessage());
    }
    @Test
    public void searchJobTitleTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        employeeListPage.selectJobTitle("Account Assistant");

        Assert.assertTrue(employeeListPage.verifySearchMessage());
    }
    @Test
    public void searchSubUnitTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
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
    @Test
    public void addEmployeeWithBlandFieldsTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        AddEmployeePage addEmployeePage = employeeListPage.goToAddEmployeePage();
        addEmployeePage.clickSaveButton();

        Assert.assertTrue(addEmployeePage.verifyFirstRequiredMessage("Required"));
        Assert.assertTrue(addEmployeePage.verifyLastRequiredMessage("Required"));
    }
    @Test
    public void addEmployeeWithFullNameTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        AddEmployeePage addEmployeePage = employeeListPage.goToAddEmployeePage();
        addEmployeePage.setFirstName("Jane");
        addEmployeePage.setLastName("Doe");
        addEmployeePage.clickSaveButton();

        addEmployeePage.waitUntilElementAppears();

        Assert.assertTrue(addEmployeePage.verifySuccessfullySavedMessage("Success"));
    }
    @Test
    public void addEmployeeWithIdTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();
        EmployeeListPage employeeListPage = dashboardPage.goToPIMModule();
        AddEmployeePage addEmployeePage = employeeListPage.goToAddEmployeePage();
        addEmployeePage.setFirstName("Jane");
        addEmployeePage.setLastName("Doe");
        addEmployeePage.setId("9000");
        addEmployeePage.clickSaveButton();

        addEmployeePage.waitUntilElementAppears();

        Assert.assertTrue(addEmployeePage.verifySuccessfullySavedMessage("Success"));
    }
    @Test
    public void addEmployeeWithLoginDetailsTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
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
        addEmployeePage.clickSaveButton();

        addEmployeePage.waitUntilElementAppears();

        Assert.assertTrue(addEmployeePage.verifySuccessfullySavedMessage("Success"));
    }
}
