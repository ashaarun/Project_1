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
import com.training.pom.Complex2POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Complex2Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private String baseUrl1;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Complex2POM complex2POM;
	ExtentReports extent;//where my report should be
	 ExtentTest logger;//to log my test
	 private String expected="Your order has been successfully processed!";

	 @BeforeTest
		public void logreports()
		{
			
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Complex2.html",true);//user.dir ==>same directory ,create a folder namked ancy.html
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
	    complex2POM = new Complex2POM(driver);
		baseUrl = properties.getProperty("baseURL");
		baseUrl1=properties.getProperty("baseURL1");
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
		//loginPOM.sendUserName("admin");
		//loginPOM.sendPassword("admin@123");
		//loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		complex2POM.ClickLogin();
		complex2POM.sendUserName("2389asha@gmail.com");
		complex2POM.sendPassword("Asha");
		complex2POM.clickLoginBtn();
		String actual=complex2POM.addprod("New add prod");
		Assert.assertEquals(expected, actual);	
		complex2POM.adminlogin();
		driver.get(baseUrl1);
		
		System.out.println(driver.getCurrentUrl());
		
		complex2POM.sendUserName1("admin");
		complex2POM.sendPassword1("admin@123");
		complex2POM.clickLoginBtn1();
		Thread.sleep(3000);
		complex2POM.orderstatus();
		
		driver.get(baseUrl);
		System.out.println(driver.getCurrentUrl());
		//complex2POM.ClickLogin();
		//complex2POM.sendUserName("2389asha@gmail.com");
		//complex2POM.sendPassword("Asha");
		//complex2POM.clickLoginBtn();
		complex2POM.orderhistory();
		
	}
	
	
}