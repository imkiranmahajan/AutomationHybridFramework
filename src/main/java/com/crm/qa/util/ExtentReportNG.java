package com.crm.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getExtentReport() {
		String path = System.getProperty("user.dir")+"\\Extend Report\\index.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("CRM Test Result");
		extentSparkReporter.config().setDocumentTitle("CRM Extent Report");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Kiran Mahajan");
		return extentReports;
	}
}