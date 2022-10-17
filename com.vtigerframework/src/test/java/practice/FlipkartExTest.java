package practice;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartExTest 
{

	@Test
	
		public void flipkartxpath() throws Throwable
		{
		
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("iphone"+Keys.ENTER);
		// xpath
	String price = driver.findElement(By.xpath("//div[text()='APPLE iPhone 11 (White, 64 GB)']/../../div/div/div/div[1]")).getText();
		
	System.out.println("Price of the Iphone by xpath is ------>"+price);
	
	// axes xpath
String IphonePeice = driver.findElement(By.xpath("(//child::div[text()='APPLE iPhone 11 (White, 64 GB)']//ancestor::div//child::div[text()='₹35,990'])[1]")).getText();
		System.out.println("Price of Iphone by axes is ---->" +IphonePeice);
		
		
		driver.quit();
		}
}
