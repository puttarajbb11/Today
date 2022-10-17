package practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.math3.random.ValueServer;
import org.apache.poi.EncryptedDocumentException;

import com.mysql.jdbc.Driver;

public class DataBackToDataBase {
	

	public static void main(String[] a) throws EncryptedDocumentException, IOException, SQLException
	{
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);

		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");

		Statement stat = conn.createStatement();
		
		
		String query ="insert into detail(first_name,address,Email)values('Annapurna','INDIA','anu@gmail.com')";
		
					int results = stat.executeUpdate(query);
		
		
		if(results==1)
		{
			System.out.println("User Created");
		}
		else {
			System.out.println("User not created ");
		}
		conn.close();

}
}