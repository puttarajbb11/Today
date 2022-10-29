package com.crm.Product;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.soap.Text;
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

import com.crm.Genric_Utility.BaseClass;
import com.crm.Genric_Utility.Excel_Utility;
import com.crm.Genric_Utility.File_Utility;
import com.crm.Genric_Utility.Java_Utility;
import com.crm.Genric_Utility.WebDriver_Utility;
import com.crm.pom.CampaignsPage;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;
import com.crm.pom.VerificationAndValidation;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners
public class CreateCampaignTest extends BaseClass 
{
	@Test(groups = {"RegrassionTest"})
	public void CreateCampaign() throws Throwable
	{
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
		// Random number
		int randomnum = jlib.getRandomnum();
		// Home Page
		//Assert.fail();
		HomePage home=new HomePage(driver);
		home.ClickOnMore(driver);
		home.ClickOnCampaign();
		// Campaign Page
		CampaignsPage camp=new CampaignsPage(driver);
		camp.ClickonCreatCam();
		// Data Driven from Excel for campaign Name
		Excel_Utility ex=new Excel_Utility();
		String excelData = ex.getexcelData("Sheet1", 0, 1)+randomnum;
		camp.ClickCampaignName(excelData);
		camp.ClickonSavebtx();
		String Text = camp.VerifyCampaignName();
		// Verification and Validation for Campaign Name 
		VerificationAndValidation camName=new VerificationAndValidation(driver);
		camName.VarifyAndValidateCamName(driver, Text);
		// Click On SigOut
		//home.ClickOnAdministraton();
		//home.ClickOnSigOut(driver);
	}
}
