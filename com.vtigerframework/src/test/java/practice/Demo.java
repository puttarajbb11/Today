package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveWideningDelegate;

public class Demo {

	static {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	}
	public static void main(String[] args) throws IOException {
	/*	String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);*/
		FileInputStream f = new FileInputStream("./common_Data.properties");

		Properties p = new Properties();
		p.load(f);
		String url = p.getProperty("url");
		String username = p.getProperty("un");
		String passwordtext = p.getProperty("pw");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(passwordtext);
		driver.findElement(By.id("submitButton")).click();
		
		
		//------------------------------------------------------------------
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		FileInputStream f1 = new FileInputStream("./Book2.xlsx");
		 Workbook wb = WorkbookFactory.create(f1);
		 Sheet sh = wb.getSheet("Sheet1");
		Row row =  sh.getRow(0);
		Cell cel=row.getCell(0);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
	}
	
	
	

}
