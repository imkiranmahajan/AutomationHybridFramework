package com.crm.qa.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;

public class Listeners extends TestBase implements ITestListener {

	public Listeners() throws IOException {
		super();
	}
	
	ExtentReports extent = ExtentReportNG.getExtentReport(); // here we have called getExtentReport method into the Listeners.
	ExtentTest test;
	private static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName()); // here you will get the method and method name.
		threadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadLocal.get().log(Status.PASS, "Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadLocal.get().fail(result.getThrowable()); // this will print you the error massage in the report, if test case failed.
		try {
			threadLocal.get().addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
