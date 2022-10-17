package com.crm.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Genric_Utility.BaseClass;
import com.crm.Genric_Utility.Excel_Utility;
import com.crm.Genric_Utility.File_Utility;
import com.crm.Genric_Utility.Java_Utility;
import com.crm.Genric_Utility.WebDriver_Utility;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;
import com.crm.pom.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass{

	// public static void main(String[] args) throws Throwable {
	@Test(groups = {"SmockTest","RegrassionTest"})
	
	public void CreateProduct() throws Throwable
	{

		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
		
		
		HomePage home=new HomePage(driver);
		home.ClickOnProduct();
		String data = elib.getexcelData("Sheet1", 0, 1);
		ProductPage propage=new ProductPage(driver);
		propage.ClickOnCreateProduct();
		propage.productName(data);
		propage.clickOnSave();


		String proName =	propage.VerifyProductName();

		if(proName.contains(data))
		{
			System.out.println("Product is created And Test is-----> Passed");
		}
		else 
		{
			System.out.println("Product is not created And Test is ----> Failed");
		}
		
		//home.ClickOnAdministraton();
		//home.ClickOnSigOut(driver);

	}
}
