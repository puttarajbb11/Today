package com.crm.Genric_Utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Table.Cell;

public class Excel_Utility {
	/**
	 * this method is used for getting data from excel
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @author Puttaraja 
	 */
	
	public String getexcelData(String SheetName, int rownum, int cellnum) throws Throwable {
		
		FileInputStream fg=new FileInputStream("./Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fg);
		Sheet sh = wb.getSheet(SheetName);
		Row row=sh.getRow(rownum);
	 org.apache.poi.ss.usermodel.Cell ce = row.getCell(cellnum);
	String text = ce.getStringCellValue();
	return text;
		
	}

}
