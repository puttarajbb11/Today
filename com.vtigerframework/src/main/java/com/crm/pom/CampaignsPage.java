package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage 
{
	// Initialization 

	public  CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement clickOnCreateCampaign;

	@FindBy(name="campaignname")
	private WebElement campainamtxt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSaveBtx;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyCampaignNam;

	@FindBy(xpath="//img[@alt='Select']")
	private WebElement productSelect;
	
	
	
	// product search
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement productSearch;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement SearchNow;

	@FindBy(xpath="//*[@id=\"1\"]")
	private WebElement verifyProduct;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement CampHeader;
	
	
	
	
	// getter method
	
	

	public WebElement getVerifyProduct() {
		return verifyProduct;
	}



	public WebElement getCampHeader() {
		return CampHeader;
	}



	public WebElement getClickOnCreateCampaign()
	{
		return clickOnCreateCampaign;
	}
	
	

	public WebElement getProductSearch() {
		return productSearch;
	}



	public WebElement getSearchNow() {
		return SearchNow;
	}



	public WebElement getProductSelect() {
		return productSelect;
	}

	public WebElement getCampainamtxt() {
		return campainamtxt;
	}

	public WebElement getClickOnSaveBtx() {
		return clickOnSaveBtx;
	}



	// Business logic  

	public WebElement getVerifyCampaignNam() {
		return verifyCampaignNam;
	}

	// Business logic  
	public void ClickonCreatCam()
	{
		clickOnCreateCampaign.click();
	}

	public void ClickCampaignName(String name)
	{
		campainamtxt.sendKeys(name);

	}

	public void ClickonSavebtx()
	{
		clickOnSaveBtx.click();

	}

	public String VerifyCampaignName()
	{
		return verifyCampaignNam.getText();

	}

	public void productSelect() 
	{
		productSelect.click();
	}
	
	public void SearchProduct(String name)
	{
		productSearch.sendKeys(name);
		
	}
	
	public  void ClickOnSearchNow() 
	{
		SearchNow.click();
		
	}
	
	public void VerifyData()
	{
		verifyProduct.click();
	}
	
	public String campHeader() 
	{
		return CampHeader.getText();
	}
	

}
