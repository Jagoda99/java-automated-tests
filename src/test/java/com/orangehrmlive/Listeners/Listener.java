package com.orangehrmlive.Listeners;

import com.orangehrmlive.Logs.Log;
import com.orangehrmlive.TestComponents.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener extends BaseTest implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }
    @Override
    public void onTestStart(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is starting.");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is succeed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is failed.");

        Object currentTestClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentTestClass).getDriver();

       // Allure screenshot
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + result.getMethod().getConstructorOrMethod().getName());
            saveScreenshotPNG(driver);
        }
        saveTextLog(result.getMethod().getConstructorOrMethod().getName() + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is skipped.");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("I am in onFinish method " + context.getName());
    }
}
