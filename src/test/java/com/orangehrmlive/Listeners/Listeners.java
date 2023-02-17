package com.orangehrmlive.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangehrmlive.Logs.Log;
import com.orangehrmlive.TestComponents.Initialization;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static com.orangehrmlive.ExtentReports.ExtentReporterNG.getExtentReports;

public class Listeners extends Initialization implements ITestListener {

    ExtentReports extent = getExtentReports();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
    ExtentTest test;
    public String getScreenshot(String testCase, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//extent-reports//" + testCase + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//extent-reports//" + testCase + ".png";
    }
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
        iTestContext.setAttribute("WebDriver", this.driver);
    }
    @Override
    public void onTestStart(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is starting.");
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        extentTest.get().log(Status.INFO, "Starting " + result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is succeed.");
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is failed.");
       extentTest.get().fail(result.getThrowable());
       extentTest.get().fail("Test failed");

        Object testClass = result.getInstance();
        WebDriver driver = Initialization.getDriver();

       // Allure screenshot
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + result.getMethod().getConstructorOrMethod().getName());
            saveScreenshotPNG(driver);
        }
        saveTextLog(result.getMethod().getConstructorOrMethod().getName() + " failed and screenshot taken!");

        //ExtentReports screenshot
        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info(result.getMethod().getConstructorOrMethod().getName() + " test is skipped.");
        extentTest.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        Log.info("I am in onFinish method " + context.getName());
    }
}
