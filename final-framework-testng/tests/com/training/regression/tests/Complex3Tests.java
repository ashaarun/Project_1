package com.training.regression.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.training.dataproviders.Complex3DataProviders;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Complex3POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Complex3Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Complex3POM complex3POM;
	ExtentReports extent;//where my report should be
	 ExtentTest logger;//to log my test
	 WebElement faulty1;
	 private int i,j,k;

	 @BeforeTest
		public void logreports()
		{
			
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Complex3.html",true);//user.dir ==>same directory ,create a folder namked ancy.html
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			logger = extent.startTest("Test case 1");
			
		}
	 


	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver); 
	    complex3POM = new Complex3POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws Throwable {
		//loginPOM.sendUserName("admin");
		//loginPOM.sendPassword("admin@123");
		//loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		
	}


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}


	@Test(dataProvider = "excel-inputs", dataProviderClass = Complex3DataProviders.class)
	public void loginDBTest(String userName, String password, String comment) throws InterruptedException {
		//loginPOM.sendUserName(userName);
		//loginPOM.sendPassword(password);
		//loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);
		complex3POM.ClickLogin();
		Thread.sleep(3000);
		complex3POM.sendUserName(userName);
		Thread.sleep(3000);
		complex3POM.sendPassword(password);
		Thread.sleep(3000);
		complex3POM.clickLoginBtn();
		complex3POM.GotoOrders();
		complex3POM.returns(k,j,i,comment);
		i++;
		j++;
		System.out.println("Radio button is this:"+i);
		System.out.println("Orders is this:"+j);
		k++;
		System.out.println("Opened button is"+k);
		if(k>1)
		{
			k=0;
		}
		
	}
}
