package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationAndValidation
{
	// Verification And Validation for Organization
	
	// initialization
	public   VerificationAndValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//  Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyOrgName;
	
	
	// Getter Method
	public WebElement getVerifyOrgName() 
	{
		return verifyOrgName;
	}
	
	// Business Logic
	public void VerifyAndValidOrgName(WebDriver driver, String data)
	{
	String actualData=verifyOrgName.getText();
	if(actualData.contains(data))
	{
		System.out.println("Organisation is created And Test is ------>Passed");
	}
	else
	{
		System.out.println("Organisation is not created And Test is ------>Failed");
	}
		
	}
//===============================================================================================
	
	
	// Verification And Validation for CreateCampaign
	
	
	// Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyCampaignName;


	
	// Getter Method 

	public WebElement getVerifyCampaignName()
	{
		return verifyCampaignName;
	}
	
	// Business Logic 
	
	public void VarifyAndValidateCamName(WebDriver driver, String name) 
	{
		String campName=verifyCampaignName.getText();
		
		if(campName.contains(name))
		{
			System.out.println("Campaign is created And Test is ------>Passed");
		}
		else
		{
			System.out.println("Campaign is not created And Test is ------>Failed");
		}
	}
	
//===========================================================================================
	
	
	
	
	
}



