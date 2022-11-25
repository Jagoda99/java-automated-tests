package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.Pages.LoginModule.LoginPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NegativeLoginTests extends Initialization {

    @Test
    public void invalidUsernameLoginTest() throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputUsername("username");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyLoginMessage("Invalid credentials"));
    }
    @Test
    public void invalidPasswordLoginTest() throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("password");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyLoginMessage("Invalid credentials"));
    }
    @Test
    public void blankUsernameLoginTest() throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyUsernameInputMessage("Required"));

    }

    @Test
    public void blankPasswordLoginTest() throws IOException {

        LoginPage loginPage = launchApp();
        loginPage.inputUsername("Admin");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyPasswordInputMessage("Required"));

    }

    @Test
    public void blankFieldsLoginTest() throws IOException {
        LoginPage loginPage = launchApp();
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyUsernameInputMessage("Required"));
        Assert.assertTrue(loginPage.verifyPasswordInputMessage("Required"));
    }

}
