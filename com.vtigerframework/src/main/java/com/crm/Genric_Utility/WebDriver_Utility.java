package com.crm.Genric_Utility;

import java.security.PublicKey;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

		public class WebDriver_Utility {
	/**
	 * This method is used to wait for page load before identifying any synchronized element in DOM
	 * @param driver
	 * @author Puttaraja
	 */
	
	public void WaitUntillToload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	/**
	 * it is explicitly wait always wait for page to be loaded & available in GUI
	 * @param driver
	 * @author Puttaraja
	 */
	public void WaitExplixtly(WebDriver driver , WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to select the value from the drop down based on value
	 * @param element
	 * @param text
	 * @author Puttaraja
	 */
	
	public void SelectMethodValue(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);

	}
	
	/**
	 * This method is used to select the value from the drop down based on index
	 * @param element
	 * @param index
	 */
	
	public void selectByIndex(WebElement element, int index)
	{
		Select h=new Select(element);
		h.selectByIndex(index);
	}
	
	/**
	 * This method is used to select the value from the drop down based on text
	 * @param element
	 * @param text
	 */
	
	public void selectByValue(WebElement element, String text)
	{
		Select hd=new Select(element);
		hd.selectByValue(text);	
	}

	/**
	 * This method is used to move mouse cursor on specific element
	 * @param driver
	 * @param element
	 * @author Puttaraja 
	 */
	public void MouseOverOnElemenet(WebDriver driver, WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	/**
	 * This method is used to switch to frame based on id or attribute
	 * @param driver
	 * @param id_name_AttributeString
	 * @author Puttaraja
	 */
	public void switchToFrame(WebDriver driver,String id_name_AttributeString)
	{
		driver.switchTo().frame(id_name_AttributeString);
	}
	
	/**
	 * This method is used to switch to alert window & click on ok button
	 * @param driver
	 * @author Puttaraja
	 */
	
	public void SwitchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();	
	}
	/**
	 *  This method is used to switch to alert window & click on cancel button
	 * @param driver
	 */
	public void SwitchToAlertAndDismis(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();	
	}
	
	/**
	 * this method is used to switch to any window based on window title
	 * @param driver
	 * @param partialwindowTitle
	 */
	public void SwitchToWindow(WebDriver driver, String partialwindowTitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();

		while(it.hasNext())
		{
			String di=it.next();
			driver.switchTo().window(di);
			if(driver.getTitle().contains(partialwindowTitle))
			{
				break;
			}
		}

	}
	
	/**
	 * This method is used to do right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method is used Maximize the window
	 * @param driver
	 * @author Puttaraja 
	 */
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	 public void fulentWaitToLoadPage(WebDriver driver, WebElement element, int pollingTime)
	 {
		 FluentWait wait=new FluentWait(driver);
		 wait.pollingEvery(Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 
	 }
}