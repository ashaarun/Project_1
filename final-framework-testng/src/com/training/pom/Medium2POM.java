package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Medium2POM {

private WebDriver driver; 
	
	public Medium2POM(WebDriver driver) {

		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-catalog")
	private WebElement catalog; 
	
	@FindBy(linkText="Categories")
	private WebElement Categories; 
	
	@FindBy(linkText="Products")
	private WebElement Products;
	
	@FindBy(xpath="//*[@class='btn btn-primary' and @data-original-title='Add New']")
	private WebElement Addnew; 
	
	@FindBy(xpath="//*[@id='input-name1' and @class='form-control']")
	private WebElement Categoryname; 
	
	@FindBy(xpath="//*[@class='note-editable panel-body']")
	private WebElement Description;
	
	@FindBy(xpath="//*[@id='input-meta-title1' and @class='form-control']")
	private WebElement Metatag;
	
	@FindBy(xpath="//*[@id='input-meta-description1' and @class='form-control']")
	private WebElement Metatagdesc;
	
	@FindBy(linkText="Data")
	private WebElement Data;
	
	@FindBy(linkText="Design")
	private WebElement Design;
	
	@FindBy(xpath="//*[@data-original-title='Save']")
	private WebElement Save;
	
	@FindBy(xpath="//*[@class='btn btn-primary' and @data-original-title='Add New']")
	private WebElement ProdAddnew; 
	
	@FindBy(xpath="//*[@id='input-name1' and @class='form-control']")
	private WebElement ProdCategoryname;
	
	@FindBy(xpath="//*[@id='input-meta-title1' and @class='form-control']")
	private WebElement Prodmetatag;
	
	@FindBy(linkText="Links")
	private WebElement Links;
	
	@FindBy(name="category")
	private WebElement linkcategory;
	
	@FindBy(linkText="ORNAMENTS")
	private WebElement linkornaments;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(linkText="Attribute")
	private WebElement Attribute;
	@FindBy(linkText="Option")
	private WebElement Option;
	@FindBy(linkText="Recurring")
	private WebElement Recurring;
	@FindBy(linkText="Discount")
	private WebElement Discount;
	@FindBy(linkText="Special")
	private WebElement Special;
	@FindBy(linkText="Image")
	private WebElement Image;
	@FindBy(linkText="Reward Points")
	private WebElement Reward;
	@FindBy(linkText="Design")
	private WebElement ProdDesign;
	@FindBy(xpath="//*[@class='alert alert-success']")
	private WebElement success;
	
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
	
	public void Categoryname(String categoryname) {
		this.Categoryname.clear();
		this.Categoryname.sendKeys(categoryname);
	}
	
	public void Description(String desc) {
		this.Description.clear();
		this.Description.sendKeys(desc);
	}
	
	public void Metatag(String meta1) {
		this.Metatag.clear();
		this.Metatag.sendKeys(meta1);
	}
	
	public void Metadesc(String meta2) {
		this.Metatagdesc.clear();
		this.Metatagdesc.sendKeys(meta2);
	}
	
	public void Productname(String prodname) {
		this.ProdCategoryname.clear();
		this.ProdCategoryname.sendKeys(prodname);
	}
	
	public void ProdMetatag(String prodmeta) {
		this.Prodmetatag.clear();
		this.Prodmetatag.sendKeys(prodmeta);
	}
	
	public void modelnum(String model)
	{
		this.Data.click();
		this.model.sendKeys(model);
	}
	public void clickCategories() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(catalog).build().perform();
		Thread.sleep(2000);
		this.Categories.click();
		Thread.sleep(2000);
		
		this.Addnew.click();
		
		
	}
	
	public void clickProducts() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(catalog).build().perform();
		Thread.sleep(2000);
		this.Products.click();
		Thread.sleep(2000);
		
		this.ProdAddnew.click();
		
		
	}
	
	public void AddItem() throws Throwable 
	{
		/*this.Categoryname.sendKeys("ORNAMENTS");
		this.Description.sendKeys("Ornaments for Ladies");
		this.Metatag.sendKeys("ORNAMENTS");
		this.Metatagdesc.sendKeys("Ornaments for Ladies");*/
		this.Data.click();
		Thread.sleep(3000);
		this.Design.click();
		this.Save.click();
	}
	
	public void AddProdItem() throws InterruptedException
	{
		this.Links.click();
		Thread.sleep(3000);
		this.linkcategory.click();
		this.linkornaments.click();
		this.Attribute.click();
		this.Option.click();
		this.Recurring.click();
		this.Discount.click();
		this.Special.click();
		this.Image.click();
		this.Reward.click();
		this.Design.click();
		this.Save.click();
		Thread.sleep(3000);
		String expected="Success: You have modified products!";
		String actual=this.success.getText().substring(0,36);
		//String actual=this.success.getText().replace("\n", "");
		//actual=actual.replace("x", "");
		Assert.assertEquals(expected, actual);
				
	}
	
}
