package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.Complex1DataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.Complex1POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Complex1DBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	private Complex1POM complex1POM;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		complex1POM = new Complex1POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = Complex1DataProviders.class)
	public void loginDBTest(String userName, String password , String productname , String prodmetatag , String modelnum) throws Throwable {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		complex1POM.sendUserName(userName);
		
		complex1POM.sendPassword(password);
		complex1POM.clickLoginBtn();
		
		complex1POM.clickProducts();
		Thread.sleep(3000);
		complex1POM.Productname(productname);
		Thread.sleep(3000);
		complex1POM.ProdMetatag(prodmetatag);
		complex1POM.modelnum(modelnum);
		complex1POM.AddProdItem();
		
		//mplex1POM.clickProducts();
		//mplex1POM.Categoryname(categoryname);
		
		screenShot.captureScreenShot(userName);

	}

}