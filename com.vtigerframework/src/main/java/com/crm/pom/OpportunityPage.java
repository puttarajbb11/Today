package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage
{
	
	public  OpportunityPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement clickOnCreateOpportunity;
	
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement OpportunityName;
	
	@FindBy(xpath="//img[@onclick='return window.open(\"index.php?module=\"+ document.EditView.related_to_type.value +\"&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=\",\"test\",\"width=640,height=602,resizable=0,scrollbars=0,top=150,left=200\");']")
	private WebElement RelatedTo;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchId;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNoW;
	
	@FindBy(xpath="//a[text()='UserName3']")
	private WebElement orgSelect;
	
	@FindBy(xpath="//input[@name='amount']")
	private WebElement amountbx;

	@FindBy(xpath="//select[@name='opportunity_type']")
	private WebElement typeDrop;
	
	@FindBy(xpath="//option[@value='New Business']")
	private WebElement valueTxt;
	
	
	
	
	public WebElement getValueTxt() {
		return valueTxt;
	}


	public WebElement getTypeDrop() {
		return typeDrop;
	}


	public WebElement getSearchNoW() {
		return searchNoW;
	}


	public WebElement getAmountbx() {
		return amountbx;
	}


	public WebElement getOpportunityName() {
		return OpportunityName;
	}


	public WebElement getRelatedTo() {
		return RelatedTo;
	}
	
	public WebElement getSearchId() {
		return searchId;
	}

	public WebElement getSearchNoWeb() {
		return searchNoW;
	}



	public WebElement getOrgSelect() {
		return orgSelect;
	}


	public WebElement getClickOnCreateOpportunity()
	{
		return clickOnCreateOpportunity;
	}
	
	
	
	public void clickOnCreateOpportuntiy()
	{
		clickOnCreateOpportunity.click();
	}
	
	public void OppourtinityName(String Name)
	{
		OpportunityName.sendKeys(Name);
		
	}
	
	public void clickOnSelect() 
	{
		RelatedTo.click();
	}
	
	public void searchForOrg(String OrgName)
	{
		searchId.sendKeys(OrgName);
		
	}
	
	public void clickOnSearchNow() 
	{
		searchNoW.click();
	}
	
	public void ClickOnOrg() 
	{
		orgSelect.click();
		
	}
	
	public void amounttxbox(String amount)
	{
		amountbx.sendKeys(amount);
	}
	
	public void clickOnType() 
	{
		typeDrop.click();
	}
	
	public String TypeSelect(String type) 
	{
		valueTxt.sendKeys(type);
		return type;
	}
	
}
