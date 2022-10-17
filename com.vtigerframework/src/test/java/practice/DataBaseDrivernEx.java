package practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import com.mysql.jdbc.Driver;

public class DataBaseDrivernEx {

	public static void main(String[] a) throws EncryptedDocumentException, IOException, SQLException
	{
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);

		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");

		Statement stat = conn.createStatement();

		String selectQuery = "select*from detail";

		ResultSet result = stat.executeQuery(selectQuery);

		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		conn.close();

	}}