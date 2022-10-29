package com.crm.Genric_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static  WebDriver driver;
	public static WebDriver sDriver;
		
	@BeforeSuite(groups = {"SmockTest","RegrassionTest"})
	public void BeforeSuit() 
	{
		System.out.println("Data Base Connection");
	}

	@org.testng.annotations.BeforeTest (groups = {"SmockTest","RegrassionTest"})
	
	public void BeforeTest() throws Throwable
	{
		System.out.println("Execute in Paralle Mode");
	}
	

	//@Parameters("BROWSER")
	@org.testng.annotations.BeforeClass(groups = {"SmockTest","RegrassionTest"})
	
	//public void BeforeClass(String BROWSER) throws Throwable 
	public void BeforeClass() throws Throwable
	{
		
		
		File_Utility flib=new File_Utility();
		String Browser=	flib.getPropertyKeyValue("browser");

		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}	
		else if(Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		sDriver = driver;
		WebDriver_Utility wlib= new WebDriver_Utility();

		wlib.windowMaximize(driver);

		wlib.WaitUntillToload(driver);
		
		
		System.out.println("Browser Launching");

	}
	@org.testng.annotations.BeforeMethod(groups = {"SmockTest","RegrassionTest"})

	public void BeforeMethod() throws Throwable
	{
		System.out.println("Login to application");
		File_Utility j=new File_Utility();
		String URL = j.getPropertyKeyValue("url");
		String username = j.getPropertyKeyValue("un");
		String password=j.getPropertyKeyValue("pw");
		driver.get(URL);
		LoginPage log= new LoginPage(driver);
		log.Setlog(username, password);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		HomePage home=new HomePage(driver);
		home.ClickOnAdministraton();
		home.ClickOnSigOut(driver);
	}

	@org.testng.annotations.AfterClass(groups = {"SmockTest","RegrassionTest"})
	public void AfterClass()
	{
		System.out.println("close the browser");
		driver.close();
	}
	@org.testng.annotations.AfterTest(groups = {"SmockTest","RegrassionTest"})


	public void AfterTest() 
	{
		System.out.println("Execute test sucessfully");

	}

	@org.testng.annotations.AfterSuite(groups = {"SmockTest","RegrassionTest"})

	public void AfterSuite()
	{
		System.out.println("Data Base closed");

	}
}
