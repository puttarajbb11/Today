package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

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

import com.crm.Genric_Utility.Excel_Utility;
import com.crm.Genric_Utility.File_Utility;
import com.crm.Genric_Utility.Java_Utility;
import com.crm.Genric_Utility.WebDriver_Utility;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {



	public static void main(String[] args) throws Throwable {
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
		
		String BROWSER=	flib.getPropertyKeyValue("browser");
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


		/*String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);*/

		int ran = jlib.getRandomnum();
	/*	Random ram=new Random();
		int Ramnum=ram.nextInt(1000);*/
		
		String URL = flib.getPropertyKeyValue("Myurl");

		/*FileInputStream f = new FileInputStream("./common_Data.properties");

		Properties p = new Properties();
		p.load(f);
		String url = p.getProperty("Myurl");*/

		driver.manage().window().maximize();
		wlib.WaitUntillToload(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

		driver.findElement(By.id("fromCity")).click();
	String data = elib.getexcelData("MakemyTrip", 1, 2);
		
	/*	FileInputStream f1 = new FileInputStream("./Book2.xlsx");
		Workbook wb = WorkbookFactory.create(f1);
		Sheet sh = wb.getSheet("MakemyTrip");
		Row row =  sh.getRow(1);
		Cell cel=row.getCell(2);
		String data = cel.getStringCellValue();*/

		driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys(data);
		driver.findElement(By.xpath("//p[contains(text(),'"+data+"')]")).click();

		String data1 = elib.getexcelData("MakemyTrip", 1, 3);
	/*	FileInputStream hgs = new FileInputStream("./Book2.xlsx");
		Workbook wb1 = WorkbookFactory.create(hgs);
		Sheet she = wb1.getSheet("MakemyTrip");
		Row ro =  she.getRow(1);
		Cell ce=ro.getCell(3);
		String data1 = ce.getStringCellValue();*/

		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys(data1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'"+data1+"')]")).click();
		// Ticket Booking
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(1000);
		String month= "October 2022";
		String date = "14";
		WebElement selectdate = driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
		selectdate.click();

		// return Ticket

		driver.findElement(By.xpath("//span[text()='RETURN']")).click();

		String Month1="November";
		String Date1="5";
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		Thread.sleep(3000);

		WebElement Return1 = driver.findElement(By.xpath("//div[text()='"+Month1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Date1+"']"));
		Return1.click();

		driver.findElement(By.xpath("//label[@for='travellers']")).click();

		String adult="adults-3";
		String children = "children-2";
		String infant = "infants-2";
		String Class = "travelClass-0";

		driver.findElement(By.xpath("//li[@data-cy='"+adult+"']")).click();
		driver.findElement(By.xpath("//li[@data-cy='"+children+"']")).click();
		driver.findElement(By.xpath("//li[@data-cy='"+infant+"']")).click();
		driver.findElement(By.xpath("//li[@data-cy='"+Class+"']"+"/ancestor::div[@class='travellers gbTravellers']/descendant::button[text()='APPLY']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();

	}

}
