package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Complex2POM {

private WebDriver driver; 
	
	public Complex2POM(WebDriver driver) {

		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://retail.upskills.in/account/account']/span/span/i")
	private WebElement account; 
	
	@FindBy(linkText="LOGIN / REGISTER")
	private WebElement login;
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary' and @value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='http://retail.upskills.in']")
	private WebElement home;
	
	@FindBy(linkText="Nam sed")
	private WebElement namsed;
	
	@FindBy(id="button-cart")
	private WebElement addtocart;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement carticon;
	
	@FindBy(linkText="View Cart")
	private WebElement viewcart;
	
	@FindBy(linkText="Checkout")
	private WebElement checkout;
	
	@FindBy(id="button-payment-address")
	private WebElement continue1;
	
	@FindBy(id="button-shipping-address")
	private WebElement continue2;
	
	@FindBy(xpath="//*[@name='comment']")
	private WebElement comment;
	
	@FindBy(id="button-shipping-method")
	private WebElement continue3;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree' and @value='1']")
	private WebElement Iagree;
	
	@FindBy(id="button-payment-method")
	private WebElement continue4;
	
	@FindBy(id="button-confirm")
	private WebElement confirm;
	
	@FindBy(xpath="//div[@class='tb_text_wrap tb_sep']/p[1]")
	private WebElement success;
	
	@FindBy(id="input-username")
	private WebElement userName1; 
	
	@FindBy(id="input-password")
	private WebElement password1;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn1; 
	
	@FindBy(id="menu-sale")
	private WebElement sales; 
	
	@FindBy(linkText="Orders")
	private WebElement orders; 
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']/thead/following-sibling::tbody/tr/td//input[@value='199']//parent::td/following-sibling::td[7]/a[1]")
	private WebElement view;
	
	@FindBy(id="input-order-status")
	private WebElement orderstatus;
	
	@FindBy(id="button-history")
	private WebElement addhistory;
	
	@FindBy(linkText="View your order history")
	private WebElement vieworderhistory; 
	
	@FindBy(linkText="MY ACCOUNT")
	private WebElement myaccount;
	
	public void ClickLogin()
	{
		Actions action=new Actions(driver);
		action.moveToElement(account).build().perform();
		this.login.click();
	}
	
	
	public void sendUserName(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public String addprod(String comment) throws InterruptedException
	{
		Actions action=new Actions(driver);
		this.home.click();
		this.namsed.click();
		Thread.sleep(3000);
		this.addtocart.click();
		
		action.moveToElement(carticon).build().perform();
		Thread.sleep(1000);
		this.viewcart.click();
		this.checkout.click();
		this.continue1.click();
		Thread.sleep(1000);
		this.continue2.click();
		Thread.sleep(2000);
		this.comment.sendKeys(comment);
		this.continue3.click();
		Thread.sleep(2000);
		this.Iagree.click();
		this.continue4.click();
		this.confirm.click();
		String actual=this.success.getText();
		return actual;
		
	}
	
	public void adminlogin() throws Throwable
	{
		Actions act=new Actions(driver);
		act.contextClick(home).build().perform();
		String winHandleBefore = driver.getWindowHandle();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
	
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		}

		
	}
	
	public void sendUserName1(String userName) {
		this.userName1.clear();
		this.userName1.sendKeys(userName);
	}
	
	public void sendPassword1(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void clickLoginBtn1() {
		this.loginBtn1.click(); 
	}
	
	public void orderstatus() throws InterruptedException, Throwable
	{
		Robot robot=new Robot();
		Actions action=new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(sales).build().perform();
		this.orders.click();
		this.view.click();
		Thread.sleep(2000);
		Select sel= new Select(orderstatus);
		sel.selectByValue("5");
		this.addhistory.click();
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		
		ArrayList<String> newtab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(newtab.get(2));
	}
	
	public void orderhistory()
	{
		Actions action=new Actions(driver);
		action.moveToElement(account).build().perform();
		this.myaccount.click();
		this.vieworderhistory.click();
	}
	
	
	
}
