package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;

public class DataProviderTest {
	@Test(dataProvider = "dataProvider_test")
	public void BookTicket(String src, String dst)
	{
		System.out.println("Booking ticket from "+src+" To "+dst+"");
	}
	@DataProvider
	public Object [][] dataProvider_test()
	{
		
		Object[][] objArr=new Object[5][2];
		
		objArr[0][0]="Bangaluru";
		objArr[0][1]="Hubli";
		
		objArr[1][0]="Bangaluru";
		objArr[1][1]="Mysore";
		
		objArr[2][0]="Bangaluru";
		objArr[2][1]="Goa";
		
		objArr[3][0]="Bangaluru";
		objArr[3][1]="Dehli";
		
		objArr[4][0]="Bangaluru";
		objArr[4][1]="Gadag";
		
		return objArr;
	}

}
