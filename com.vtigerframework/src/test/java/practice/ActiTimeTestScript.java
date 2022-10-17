package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.random.ISAACRandom;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ActiTimeTestScript {

	
	public static void main(String[] args) throws IOException {
	
		String key="webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("./common_Data.properties");
		Properties p = new Properties();
		p.load(fis);
	
		 String url = p.getProperty("ActiURL");
		String userName = p.getProperty("ActiUser");
		String password = p.getProperty("Actipwd");
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.findElement(By.xpath("(//div[@class='popup_menu_icon'])[2]")).click();
		
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		FileInputStream ff = new FileInputStream("./Book2.xlsx");
		 Workbook wb = WorkbookFactory.create(ff);
		 Sheet sh = wb.getSheet("Sheet1");
		Row row =  sh.getRow(5);
		Cell cel=row.getCell(0);
		String name = cel.getStringCellValue();
		System.out.println(name);
		
		driver.findElement(By.xpath("//input[@onchange='nameChanged(this);']")).sendKeys(name);
		driver.findElement(By.xpath("//select[@name='active']")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='active']"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("archived");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		/*WebElement Typework = driver.findElement(By.xpath("//a[text()='Puttaraja Baradeli']"));
		boolean taskname = Typework.isDisplayed();
		if(taskname)
		
			System.out.println("Typework work created");
		
		else 
			
				System.out.println("Typework work is not created");*/
			
		}
		
	}


