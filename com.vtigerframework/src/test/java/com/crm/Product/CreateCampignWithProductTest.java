package com.crm.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
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
import com.crm.pom.CampaignsPage;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;
import com.crm.pom.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampignWithProductTest extends BaseClass{

	// public static void main(String[] args) throws IOException, Throwable {
	
	@Test(groups = {"SmockTest","RegrassionTest"})
	
	public void CreateCampaignAndproduct() throws Throwable
	{
		
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();

		/*String BROWSER=	flib.getPropertyKeyValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}	
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}

		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		 */
		
		int	Ramnum	=jlib.getRandomnum();

		/*String URL=flib.getPropertyKeyValue("url");
		String username=	flib.getPropertyKeyValue("un");
		String password = flib.getPropertyKeyValue("pw");*/

		/*FileInputStream f = new FileInputStream("./common_Data.properties");

		Properties p = new Properties();
		p.load(f);
		String url = p.getProperty("url");
		String username = p.getProperty("un");
		String passwordtext = p.getProperty("pw");*/

		

	/*	driver.get(URL);
		LoginPage log=new LoginPage(driver);
		log.Setlog(username, password);*/

		HomePage home=new HomePage(driver);
		home.ClickOnProduct();

		ProductPage prodpage=new ProductPage(driver);
		prodpage.ClickOnCreateProduct();
		String data = elib.getexcelData("Sheet1", 0, 1)+Ramnum;
		System.out.println(data);
		prodpage.productName(data);
		prodpage.clickOnSave();



																	/*	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
																	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
																	driver.findElement(By.id("submitButton")).click();
															
																	driver.findElement(By.xpath("//a[text()='Products']")).click();
																	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();*/
															
																	// String data = elib.getexcelData("Sheet1", 0, 1)+Ramnum;
															
																	/*	FileInputStream f1 = new FileInputStream("./Book2.xlsx");
																	Workbook wb = WorkbookFactory.create(f1);
																	Sheet sh = wb.getSheet("Sheet1");
																	Row row =  sh.getRow(0);
																	Cell cel=row.getCell(1);
																	String data = cel.getStringCellValue();
																	System.out.println(data);*/
															
																	/*driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
																	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
															
																	WebElement more1 = driver.findElement(By.xpath("//a[text()='More']"));
															
															
																	/*Actions a=new Actions(driver);
																	a.moveToElement(more1).perform();*/
		home.ClickOnMore(driver);
		CampaignsPage camp=new CampaignsPage(driver);
		home.ClickOnCampaign();
		camp.ClickonCreatCam();
		String data1 = elib.getexcelData("Sheet1", 0, 2);
		camp.ClickCampaignName(data1);
		camp.productSelect();

																/*wlib.MouseOverOnElemenet(driver, more1);
																driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
																driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
														
														
																String data1 = elib.getexcelData("Sheet1", 0, 2);
														
																/*FileInputStream ff = new FileInputStream("./Book2.xlsx");
																Workbook wb1 = WorkbookFactory.create(ff);
																Sheet sh1 = wb.getSheet("Sheet1");
																Row row1 =  sh.getRow(0);
																Cell cel1=row.getCell(2);
																String data1 = cel.getStringCellValue();
																System.out.println(data1);
														
																driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(data1);
																driver.findElement(By.xpath("//img[@alt='Select']")).click();*/
		wlib.SwitchToWindow(driver, "Products&action");

																/*Set<String> allwin = driver.getWindowHandles();
																Iterator<String> it=allwin.iterator();
														
																while(it.hasNext())
																{
																	String wid=it.next();
																	driver.switchTo().window(wid);
														
																	if(driver.getTitle().contains("Products&action"))
																	{
																		break;
																	}
																}*/
		
		camp.SearchProduct(data);
		camp.ClickOnSearchNow();
		camp.VerifyData();
		
																		/*driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(data);
																		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
																		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();*/

		wlib.SwitchToWindow(driver, "Campaigns&action");

																		/*Set<String> allwin1 = driver.getWindowHandles();
																		Iterator<String> wis=allwin1.iterator();
																
																		while(wis.hasNext())
																		{
																			String w=wis.next();
																			driver.switchTo().window(w);
																			if(driver.getTitle().contains("Campaigns&action"))
																			{
																				break;
																			}}*/
		
		camp.ClickonSavebtx();
																	//	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
														//String tex= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 String text = camp.campHeader();
		
		if(text.contains(data))
		{
			System.out.println("Campaign created");
		}
		else
		{
			System.out.println("Campaign not created");	
		}
		
		//home.ClickOnAdministraton();
		//home.ClickOnSigOut(driver);
															/*driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
															driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
	}

}
