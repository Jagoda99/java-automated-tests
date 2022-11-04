package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.LoginPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends Initialization{

        @Test(dataProvider = "getData")
        public void loginTest(String email, String password) throws IOException {

            LoginPage loginPage = launchApp();
            loginPage.inputLoginInfo(email, password);
           // EmployeeList employeeList = loginPage.goToPIM();

            String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

        }
        @DataProvider
        public Object[][] getData() {

            return new Object[][] {{"Admin","admin123"}};
        }

    }


