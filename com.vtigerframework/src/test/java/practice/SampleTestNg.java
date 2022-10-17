package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestNg 
{
	
	@Test(invocationCount = 2)
	public void createCustomerTest()
	{
		System.out.println("Customer details created");
		
	}
	@Test(dependsOnMethods ="createCustomerTest" )
	public void createModifyTest()
	{
		System.out.println("Customer details Modifyed");
	}
	@Test(dependsOnMethods ="createCustomerTest" )
	public void createDeleteTest()
	{
		System.out.println("Customer details deleted ");
	}
}
