package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Medium4POM {
	
private WebDriver driver; 
	
	public Medium4POM(WebDriver driver) {

		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-customer")
	private WebElement customer; 
	
	@FindBy(linkText="Customers")
	private WebElement customers; 
	
	//input[@type='checkbox' and @name='selected[]'and @value='115']//parent::td//following-sibling::td[7]//*[@class='btn btn-primary' and @data-original-title='Edit']
	@FindBy(xpath="//input[@type='checkbox' and @name='selected[]'and @value='115']//parent::td//following-sibling::td[7]//*[@class='btn btn-primary' and @data-original-title='Edit']")
	private WebElement edit;
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(xpath="//a[@href='#tab-address1']")
	private WebElement address1; 
	
	@FindBy(id="input-postcode1")
	private WebElement postcode; 
	
	@FindBy(linkText="Reward Points")
	private WebElement reward; 
	
	@FindBy(id="input-reward-description")
	private WebElement rewarddesc;
	
	@FindBy(id="input-points")
	private WebElement addpoints;
	
	@FindBy(id="button-reward")
	private WebElement addbutton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success;
	
	@FindBy(xpath="//*[@class='btn btn-primary' and @data-original-title='Save']")
	private WebElement save;
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
	
	public void clickcustomers() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(customer).build().perform();
		Thread.sleep(2000);
		this.customers.click();
		Thread.sleep(2000);	
		this.edit.click();
	}
	
	public String CustEdit(String firstname, String postcode, String rewarddesc, String addpoints) throws InterruptedException
	{
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
		this.address1.click();
		this.postcode.click();
		this.postcode.sendKeys(postcode);
		this.reward.click();
		Thread.sleep(3000);
		this.rewarddesc.click();
		this.rewarddesc.sendKeys(rewarddesc);
		this.addpoints.click();
		this.addpoints.sendKeys(addpoints);
		this.addbutton.click();
		Thread.sleep(3000);
		String expected="Success: You have modified customers!";
		String actual=this.success.getText().substring(0,37);
		Assert.assertEquals(expected, actual);
		
		this.save.click();
		
		
		String actual1=this.success.getText().substring(0,37);
		return actual1;
		
	}
	
	

}
