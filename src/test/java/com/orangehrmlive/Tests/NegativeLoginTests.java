package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends Initialization {

    @Test
    public void invalidUsernameLoginTest() {

        loginPage.inputUsername("username");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyLoginMessage("Invalid credentials"));
    }
    @Test
    public void invalidPasswordLoginTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("password");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyLoginMessage("Invalid credentials"));
    }
    @Test
    public void blankUsernameLoginTest() {

        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyUsernameInputMessage("Required"));

    }

    @Test
    public void blankPasswordLoginTest() {

        loginPage.inputUsername("Admin");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyPasswordInputMessage("Required"));

    }

    @Test
    public void blankFieldsLoginTest() {

        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyUsernameInputMessage("Required"));
        Assert.assertTrue(loginPage.verifyPasswordInputMessage("Required"));
    }

}
