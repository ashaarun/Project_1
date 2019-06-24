package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Medium1POM {
	
	private WebDriver driver; 
	
	public Medium1POM(WebDriver driver) {

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
	
	@FindBy(linkText="Orders")
	private WebElement orders; 
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	@FindBy(id="input-order-id")
	private WebElement orderid; 
	
	@FindBy(id="input-order-status")
	private WebElement orderstatus;
	
	@FindBy(id="input-date-added")
	private WebElement dateadded;
	
	@FindBy(xpath="//label[@for='input-date-added']//following-sibling::div//following-sibling::span//following-sibling::button")
	private WebElement caldateadded;
	
	@FindBy(id="input-customer")
	private WebElement cust;
	
	@FindBy(xpath="//*[@class='dropdown-menu']/li[5]/a")
	private WebElement asha; 

	@FindBy(id="input-total")
	private WebElement total;
	
	@FindBy(id="input-date-modified")
	private WebElement datemodified;
	
	@FindBy(xpath="//label[@for='input-date-modified']//following-sibling::div//following-sibling::span//following-sibling::button")
	private WebElement caldatemodified;
	
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
	
	public void clickOrders() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(sales).build().perform();
		Thread.sleep(2000);
		this.orders.click();
		Thread.sleep(2000);	
		
	}
	
	public void orderid(String ordid) {
		this.orderid.clear(); 
		this.orderid.sendKeys(ordid); 
		this.filter.click();
	}
	
	public void orderstatus()
	{
		this.orderstatus.click();
		Select sel= new Select(orderstatus);
		sel.selectByVisibleText("Pending");
		this.filter.click();
	}
	
	public void dateadded() {
		this.dateadded.click(); 
		this.caldateadded.click();
		this.caldateadded.click();
		this.filter.click();
	}
	
	public void customer() throws InterruptedException
	{
		this.cust.click();
		Thread.sleep(3000);
		this.asha.click();
		this.filter.click();
	}
	
	public void sendtotal(String total)
	{
		this.total.sendKeys(total);
		this.filter.click();
	}
	
	public void datemodified() {
		this.datemodified.click(); 
		this.caldatemodified.click();
		this.caldatemodified.click();
		this.filter.click();
	}
	
	
	
}
