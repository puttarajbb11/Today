package com.crm.pom;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage
{
	// Initialization 
	public  OrganisationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration 

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrg;

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNam;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyOrgNam;
	
	// getter method
	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getOrgNam() {
		return orgNam;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	

	public WebElement getVerifyOrgNam() {
		return verifyOrgNam;
	}

	public void setVerifyOrgNam(WebElement verifyOrgNam) {
		this.verifyOrgNam = verifyOrgNam;
	}

	//Business logic 
	public void ClickOnCrecateOrg()
	{
		createOrg.click();
	}

	public void OrgName(String name)

	{
		orgNam.sendKeys(name);
		
	}
	public void SaveBtx()
	{
		saveButton.click();
	}
	
	public String  VerifyOrgName()
	{
		return verifyOrgNam.getText();
	}

}

