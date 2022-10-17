package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Initialization 
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Declaration 
	
	@FindBy(xpath="//input[@name='user_name']" )
	private WebElement usernametext;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passtex;
	
	@FindBy(id="submitButton")
	private WebElement loginbut;
	
	// Getter Method 
	
	/**
	 * This method is used to login the application
	 * @return
	 * @author Puttaraja
	 */

	public WebElement getUsernametext()
	{
		return usernametext;
	}

	public WebElement getPasstex() 
	{
		return passtex;
	}

	public WebElement getLogbut()
	{
		return loginbut;
	}
	
	
	public  void  Setlog(String username, String password)
	{
		usernametext.sendKeys(username);
		passtex.sendKeys(password);
		loginbut.click();
	}

}
