package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;

public class ExtentReportListener implements ITestListener {

    private static com.aventstack.extentreports.ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(reporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("✅ Test Passed Successfully!");

        String screenshotPath = Screenshot.takeScreenshot(
                BaseTest.getDriver(),
                result.getName() + "_PASSED"
        );

        test.get().addScreenCaptureFromPath(screenshotPath, "Screenshot on Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("❌ Test Failed: " + result.getThrowable());

        String screenshotPath = Screenshot.takeScreenshot(
                BaseTest.getDriver(),
                result.getName() + "_FAILED"
        );

        test.get().addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("⚠ Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
