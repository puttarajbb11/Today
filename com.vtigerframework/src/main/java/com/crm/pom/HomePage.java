package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Genric_Utility.WebDriver_Utility;
import com.mysql.jdbc.Driver;

public class HomePage {
	
	// initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//  Declaration
	
	@FindBy(linkText="Organizations")//
	private WebElement orgButton;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productButton;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactButton;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreButton;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement sigoutbutton;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement OpportunityBtn;
	
	// getter Method

	public WebElement getOrgButton() {
		return orgButton;
	}

	public WebElement getProductButton() {
		return productButton;
	}

	public WebElement getContactButton() {
		return contactButton;
	}

	public WebElement getMoreButton() {
		return moreButton;
	}

	
	public WebElement getCampaignButton() {
		return campaignButton;
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSigoutbutton() {
		return sigoutbutton;
	}
	
	public WebElement getOpportunity() 
	{
		return OpportunityBtn;
	}
	
	
	
	
	
	
	
	
	
	
	// Business logic 
	
	

	/**
	 * This method is used to click on organization
	 * @author Puttaraja
	 */
	
	public void ClickOnOrg()
	{
		orgButton.click();
	}
	/**
	 * This method is used to click on product
	 * @author Puttaraja
	 */
	public void ClickOnProduct() 
	{
		productButton.click();
	}
	
	public void ClickOnContact() 
	{
		contactButton.click();
	}
	
	
	public void clickOnOpportunity()
	
	{
		OpportunityBtn.click();
	}
	public void ClickOnMore(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.MouseOverOnElemenet(driver, administrator);
		moreButton.click();
	}
	/**
	 * * This method is used to click on campaign
	 * @author Puttaraja
	 */
	public void ClickOnCampaign()
	{
	
	campaignButton.click();
	}
	/**
	 * * This method is used to click on administration
	 * @author Puttaraja
	 */
	public void ClickOnAdministraton()
	{
		administrator.click();
	}
	
	/**
	 * * This method is used to click on SigOut
	 * @author Puttaraja
	 */
	
	public void ClickOnSigOut(WebDriver driver )
	{
		Actions a=new Actions(driver);
		a.moveToElement(administrator).perform();
		sigoutbutton.click();	
	}
}
