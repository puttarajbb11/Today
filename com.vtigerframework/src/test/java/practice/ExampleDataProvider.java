package practice;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleDataProvider 
{
	@Test(dataProvider = "data_Provider")
	public void TicketBooking(String src,String dest)
	{
		System.out.println("Booking from "+src+"TO"+dest);
	}
		@DataProvider
		public Object [][] data_Provider()
		{
			Object [][] obja = new Object [3][2];
			
			obja [0][0]="Banglore";
			obja [0][1]="Hubli";
			//obja [0][2]="8867728615";
			
			obja [1][0]="Banglore";
			obja [1][1]="Dharwad";
			//obja [1][2]="8867728617";
			
			obja [2][0]="Banglore";
			obja [2][1]="Hulkoti";
			//obja [2][2]="9900456851";
			
			return obja;
		}
}
