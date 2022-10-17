package com.crm.Genric_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * This method is used to launch browser
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Puttaraja
	 */
	
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fiS=new FileInputStream("./common_Data.properties");
		Properties p=new Properties();
		p.load(fiS);
		String value=p.getProperty(Key);
		
		return value;
	}

}
