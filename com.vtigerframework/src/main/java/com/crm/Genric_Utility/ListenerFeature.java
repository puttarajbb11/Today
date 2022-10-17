package com.crm.Genric_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerFeature implements ITestListener
{

	public void onTestFailure(ITestResult result) {
	
	String data = result.getMethod().getMethodName();
	System.out.println("==Executed ");
	
	EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sDriver);
	File src=eDriver.getScreenshotAs(OutputType.FILE);
	
	try {
		File desFile=new File("./com.vtigerframework/ScreenShoot/"+data+".png");
		FileUtils.copyFile(src, desFile);
	} 
	catch (Exception e)
	{
	e.printStackTrace();	
	}
	}

}
