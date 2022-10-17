package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest 

{
	@Test
	
	public void CreateCustomer()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals("A", "B");
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}
	
	@Test
	public void modifyCustomer()
	{
		System.out.println("====Script Two=====");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
	}
	

}
