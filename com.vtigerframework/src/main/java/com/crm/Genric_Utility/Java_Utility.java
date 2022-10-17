package com.crm.Genric_Utility;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used to get random number
	 * @return
	 * @author Puttaraja
	 */
	public int getRandomnum()
	{
		Random ran=new Random();
		int kk = ran.nextInt(1000);
		return kk;
	}

}
