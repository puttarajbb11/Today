package practice;

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
import org.apache.xmlbeans.impl.soap.Text;
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
import com.crm.pom.ContactPage;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg extends BaseClass {

		
	@Test
	public void createContact() throws Throwable
	{
		
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
		
		int ramnum=	jlib.getRandomnum();

		HomePage home=new HomePage(driver);
		home.ClickOnContact();
		
		ContactPage cont=new ContactPage(driver);
		cont.clickOncreateContact();
																	
			String data = elib.getexcelData("Sheet1", 0, 1);
			cont.ContactLastName(data);
			cont.ClickOnOrg();
			


		String contact = elib.getexcelData("Sheet1", 0, 0);
		
		wlib.SwitchToWindow(driver, "Accounts&action");
		cont.searchForproduct(contact);
		cont.ClickOnSeacrhButtuon();
		cont.ClickOnSearchedproName();
		
		
																		
		wlib.SwitchToWindow(driver, "Contacts&action");
		
		cont.ClickOnContactSave();
		
		
	String text = cont.validateContactPage();
		
		if(text.contains(data))
		{
			System.out.println("Contact created");
		}
		else 
			{
				System.out.println("Contact not created ");
			}
		
		home.ClickOnAdministraton();
		home.ClickOnSigOut(driver);
		
		}
	}



