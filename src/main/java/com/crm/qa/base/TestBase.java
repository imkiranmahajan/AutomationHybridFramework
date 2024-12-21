package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	/*
	 * This is why we declare the WebDriver and Properties globally, so that we can
	 * use anywhere.
	 */

	public static Properties prop;
	public static WebDriver driver;

	// This is the constructor where we declare location of properties file.
	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Kmali\\eclipse-workspace\\HybridFramework\\"
				+ "src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);
	}

	// This is the initialization method where we have declare the all browsers.
	public void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));
	}

	public String getScreenshot(String testCaseName) throws IOException { // Let's assume this driver is coming from Listener level.
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE); // this will capture the Screenshot.
		String destinationFile = System.getProperty("user.dir") + "\\ExtentReport.Screenshots\\" + testCaseName + ".png"; // this is the location of captured screenshot.
		File file = new File(destinationFile); // here we have converted path String format to File format
		FileUtils.copyFile(sourceFile, file); // this expects locations in file format, not in String format.
		
		return destinationFile;
	}

}






















