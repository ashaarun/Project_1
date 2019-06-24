package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Medium3POM {
	
	private WebDriver driver; 
	
	public Medium3POM(WebDriver driver) {

		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-sale")
	private WebElement sales; 
	
	@FindBy(linkText="Returns")
	private WebElement returns; 
	
	@FindBy(xpath="//*[@class='btn btn-primary' and @data-original-title='Add New']")
	private WebElement Addnew;
	
	@FindBy(id="input-order-id")
	private WebElement ordid;
	
	@FindBy(id="input-customer")
	private WebElement custname;
	
	@FindBy(xpath="//*[@id='input-customer']//following-sibling::ul/li[6]/a")
	private WebElement asha;
	
	@FindBy(id="input-product")
	private WebElement product;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement save;
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	private WebElement success;
	
	@FindBy(xpath="//*[@type='checkbox' and @name='selected[]']")
	private WebElement checkbox;
	
	@FindBy(xpath="//*[@class='btn btn-danger']")
	private WebElement delete;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickSales() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(sales).build().perform();
		Thread.sleep(2000);
		this.returns.click();
		Thread.sleep(2000);	
		this.Addnew.click();
	}
	
	public void sendOrderId(String ordid) {
		this.ordid.clear();
		this.ordid.sendKeys(ordid);
	}
	
	public void clickAsha() throws InterruptedException {
		this.custname.click();
		this.asha.click();
		Thread.sleep(3000);
	}
	
	public void sendProduct(String product , String model) {
		this.product.sendKeys(product);
		this.model.sendKeys(model);
		this.save.click();
		String expected="Success: You have modified returns!";
		//String actual=this.success.getText().replace("\n", "");
		String actual=this.success.getText().substring(0,35);
		//String actual=this.success.getText().trim().replace("x", "");
		//actual=actual.replace("x", "");
		Assert.assertEquals(expected, actual);
	}	
	
	public void delete()
	{
		this.checkbox.click();
		this.delete.click();
		Alert alert= driver.switchTo().alert();
		alert.accept();
		String expected="Success: You have modified returns!";
		
		this.success.getText().trim();
		String actual=this.success.getText().substring(0,35);
		//String actual=this.success.getText().replace("\n", "");
		//String actual=this.success.getText().trim().replace("x", "");
		//actual=actual.replace("x", "");
		Assert.assertEquals(expected, actual);
		
	}
	
	
	
	
}