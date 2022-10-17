package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
	// // Initialization 
	
	public  ProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Declaration

	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProduct;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButtonElement;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement verifyProductName;

	
	// GETTER METHOD 
	
	public WebElement getCreateProduct()
	{
		return createProduct;
	}

	public WebElement getProductName() 
	{
		return productName;
	}

	public WebElement getSaveButtonElement() 
	{
		return saveButtonElement;
	}
	
	public WebElement getVerifyProductName()
	{
		return verifyProductName;
	}
	
	// Business Logic

	public void ClickOnCreateProduct()
	{
		createProduct.click();
		
	}
	
	public void productName(String ProName) 
	{
		productName.sendKeys(ProName);
		
	}
	
	public void clickOnSave()
	{
		saveButtonElement.click();
	}
	
	public  String  VerifyProductName() 
	{
		return verifyProductName.getText();
		
	}
}
