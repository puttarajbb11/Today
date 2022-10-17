package practice;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ExcelSample  {

	public static void main(String[] a) throws EncryptedDocumentException, IOException
	{


		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		
		//WebDriver driver=new ChromeDriver();
		FileInputStream f1 = new FileInputStream("./Book2.xlsx");
		 Workbook wb = WorkbookFactory.create(f1);
		 Sheet sh = wb.getSheet("Sheet1");
		Row row =  sh.getRow(0);
		Cell cel=row.getCell(0);
		String text = cel.getStringCellValue();
		System.out.println(text);




	}
}