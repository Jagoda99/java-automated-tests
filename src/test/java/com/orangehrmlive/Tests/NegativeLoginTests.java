package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.TestComponents.Initialization;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({com.orangehrmlive.Listeners.Listeners.class})
@Epic("Login Module")
@Feature("Negative Login Tests")
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
