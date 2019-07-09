package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Medium1POM;
import com.training.pom.Medium3POM;
import com.training.pom.Medium4POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium4Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Medium4POM medium4POM;
	ExtentReports extent;//where my report should be
	 ExtentTest logger;//to log my test

	 @BeforeTest
		public void logreports()
		{
			
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Medium4.html",true);//user.dir ==>same directory ,create a folder namked ancy.html
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			logger = extent.startTest("Test case 1");
			
		}
	 

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
	    medium4POM = new Medium4POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws Throwable {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		medium4POM.clickcustomers();
		Thread.sleep(3000);
		String actual1=medium4POM.CustEdit("Ashanew", "560042", "Addrewardnew", "100");
		Thread.sleep(3000);
		
		String expected1="Success: You have modified customers!";
		Assert.assertEquals(expected1, actual1);
		
		logger.log(LogStatus.PASS, "Order and filter");
		String title = driver.getTitle();
		logger.log(LogStatus.PASS, title);
		//driver.close();
		logger.log(LogStatus.PASS, "Browser closed successfully");
		extent.endTest(logger);
		extent.flush();//flush all reports
		extent.close();
		
	}

}

