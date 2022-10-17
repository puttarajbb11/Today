package practice;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx 
{
@Test
public void createCustomer()
{
	System.out.println("Step1");
	System.out.println("Step2");
	Assert.assertEquals("B", "B");
	System.out.println("Step3");
	System.out.println("Step4");
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
