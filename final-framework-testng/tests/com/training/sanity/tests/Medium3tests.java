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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium3tests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Medium3POM medium3POM;
	ExtentReports extent;//where my report should be
	 ExtentTest logger;//to log my test

	 @BeforeTest
		public void logreports()
		{
			
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Medium3.html",true);//user.dir ==>same directory ,create a folder namked ancy.html
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
	    medium3POM = new Medium3POM(driver);
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
		medium3POM.clickSales();
		Thread.sleep(3000);
		medium3POM.sendOrderId("170");
		Thread.sleep(3000);
		medium3POM.clickAsha();
		Thread.sleep(3000);
		medium3POM.sendProduct("Integer vitae iaculis massa","SKU-003");
		Thread.sleep(3000);
		String actual=medium3POM.delete();
		Thread.sleep(3000);
		/*medium1POM.sendtotal("0");
		Thread.sleep(3000);
		medium1POM.datemodified();*/
		
		String expected="Success: You have modified returns!";
		Assert.assertEquals(expected, actual);
		
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
