package com.crm.Organisation;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Genric_Utility.BaseClass;
import com.crm.Genric_Utility.Excel_Utility;
import com.crm.Genric_Utility.File_Utility;
import com.crm.Genric_Utility.Java_Utility;
import com.crm.Genric_Utility.WebDriver_Utility;
import com.crm.pom.HomePage;
import com.crm.pom.OrganisationPage;
import com.crm.pom.VerificationAndValidation;
@Listeners(com.crm.Genric_Utility.ListenerFeature.class)
public class CreateOrgExTest extends BaseClass {
	
	@Test
public void CreateOrganisation() throws Throwable
{
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
																																	//  Random generic  Method
		int ramnum = jlib.getRandomnum();
																				
		HomePage home=new HomePage(driver);
		home.ClickOnOrg();

		OrganisationPage org=new OrganisationPage(driver);
		org.ClickOnCrecateOrg();
		org.getCreateOrg();
	// excel generic method 
		Excel_Utility h=new Excel_Utility();
		String name = h.getexcelData("Sheet1", 0, 0)+ramnum;
		org.OrgName(name);
		// SoftAssert
		/*SoftAssert soft=new SoftAssert();
		soft.assertEquals("A", "B");*/
		//Assert.fail();
		org.SaveBtx();
		
		VerificationAndValidation Vorg=new VerificationAndValidation( driver);
		Vorg.VerifyAndValidOrgName(driver,  name);
		
		//home.ClickOnAdministraton();

		// clicking on SigOut
		//home.ClickOnSigOut(driver);
		//soft.assertAll();
}
		

	}

