package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



	public class Complex3POM {
		
		private WebDriver driver; 
		private int i;
		
		public Complex3POM(WebDriver driver) {

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
		
		@FindBy(linkText="MY ORDERS")
		private WebElement myorders;
		
		
		@FindBy(xpath="//*[@class='btn btn-danger tb_no_text']")
		private WebElement return1;
		
		@FindBy(id="input-product")
		private WebElement prodname;
		
		@FindBy(id="input-model")
		private WebElement prodcode;
		
		@FindBy(xpath="//tbody/tr/td[7]/a")
		private List<WebElement> orders;
		
		
		@FindBy(xpath="//input[@name='return_reason_id']")
		private List<WebElement> radio;
				
		
		@FindBy(xpath="//input[@name='opened']")
		private List<WebElement> opened;
		
		
		@FindBy(id="input-comment")
		private WebElement comment;
		
		@FindBy(xpath="//*[@type='submit']")
		private WebElement submit;
		
		@FindBy(linkText="Continue")
		private WebElement next;
		
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
		
		public void GotoOrders()
		{
			Actions action=new Actions(driver);
			action.moveToElement(account).build().perform();
			this.myorders.click();
	
			
		}
		
		public void returns(int k,int j,int i, String comment)
		{
			
		
			this.orders.get(j).click();
			this.return1.click();
			this.radio.get(i).click();
			this.opened.get(k).click();
			this.comment.sendKeys(comment);
			this.submit.click();
			this.next.click();
			
		}
	
		
		
}