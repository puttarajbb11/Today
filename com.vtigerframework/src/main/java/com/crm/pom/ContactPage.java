package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContact;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;

	@FindBy(xpath="//img[@alt='Select']")
	private WebElement selectorg;

	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement clickOnSearchpro;

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbutton;

	@FindBy(xpath="//a[text()='CaplIndia']")
	private WebElement clickonSearchedContact;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement validateContatcPag;

	// getter method 

	public WebElement getCreateContact()
	{
		return createContact;
	}

	public WebElement getLastname() {
		return lastname;
	}



	public WebElement getSelectorg() {
		return selectorg;
	}


	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getClickOnSearchpro() {
		return clickOnSearchpro;
	}




	public WebElement getClickonSearchedContact() {
		return clickonSearchedContact;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getValidateContatcPag() {
		return validateContatcPag;
	}





	// Business Logic 

	public void clickOncreateContact() 
	{
		createContact.click();
	}

	public void ContactLastName(String name)
	{
		lastname.sendKeys(name);
	}

	public void ClickOnOrg() 
	{
		selectorg.click();

	}

	public String  searchForproduct(String OrgName)
	{
		clickOnSearchpro.sendKeys(OrgName);
		return OrgName;
	}

	public void ClickOnSeacrhButtuon()
	{
		searchbutton.click();

	}

	public void ClickOnSearchedproName()
	{
		clickonSearchedContact.click();	
	}
	
	public void ClickOnContactSave() 
	{
		savebutton.click();
	}
	
	public  String  validateContactPage() 
	{
		return validateContatcPag.getText();
	}
}
