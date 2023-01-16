package com.orangehrmlive.Tests;

import com.orangehrmlive.Pages.DashboardModule.DashboardPage;
import com.orangehrmlive.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends Initialization {

    @Test
    public void loginPageTest() {

        Assert.assertTrue(loginPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

    }
    @Test
    public void usernameCursorTest() throws InterruptedException {

        Thread.sleep(2000);

        Assert.assertTrue(loginPage.isCursorInUsernameField());

    }
    @Test
    public void switchCursorTest() {

        loginPage.switchCursor();

        Assert.assertTrue(loginPage.isCursorInPasswordField());

    }

    @Test
    public void loginTest() {

        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        DashboardPage dashboardPage = loginPage.goToDashboard();

        Assert.assertTrue(loginPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

    }

    @Test
    public void forgotPasswordTest(){

        loginPage.goToForgotPassword();
        loginPage.inputUsername("Admin");
        loginPage.clickResetButton();

        Assert.assertTrue(loginPage.verifyResetPasswordMessage("Reset Password link sent successfully"));

        Assert.assertTrue(loginPage.verifyUrl( "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset"));

    }

    @Test
    public void maskedPasswordTest() {

        loginPage.inputPassword("admin123");
        loginPage.checkMaskedPassword();
        Assert.assertTrue(loginPage.checkMaskedPassword());
    }


}


