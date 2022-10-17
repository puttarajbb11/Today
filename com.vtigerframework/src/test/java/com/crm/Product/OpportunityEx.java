package com.crm.Product;

import org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTGapAmount;
import org.testng.annotations.Test;

import com.crm.Genric_Utility.BaseClass;
import com.crm.Genric_Utility.Excel_Utility;
import com.crm.Genric_Utility.File_Utility;
import com.crm.Genric_Utility.Java_Utility;
import com.crm.Genric_Utility.WebDriver_Utility;
import com.crm.pom.HomePage;
import com.crm.pom.OpportunityPage;


public class OpportunityEx  extends BaseClass
{

	@Test

	public void CreateOpportunity() throws Throwable 
	{
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();

		// Random Class
		int RandomNum =jlib.getRandomnum();

		HomePage home=new HomePage(driver);
		home.clickOnOpportunity();

		OpportunityPage oPage=new OpportunityPage(driver);
		oPage.clickOnCreateOpportuntiy();

		String OPPName = elib.getexcelData("Opportunity", 1, 1);
		oPage.OppourtinityName(OPPName);
		oPage.clickOnSelect();
		
		wlib.SwitchToWindow(driver, "Accounts&action");
		
		String SearchOrg = elib.getexcelData("Opportunity", 1, 2);
		
		oPage.searchForOrg(SearchOrg);
		oPage.ClickOnOrg();
		
		wlib.SwitchToWindow(driver, "Potentials&action");
		
		String Amount = elib.getexcelData("Opportunity", 1, 3);
		oPage.amounttxbox(Amount);
		
		
		
		
		Thread.sleep(5000);


	}
}
