package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.Complex1Bean;
import com.training.bean.LoginBean;
import com.training.dao.Complex1DAO;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class Complex1DataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<Complex1Bean> list = new Complex1DAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(Complex1Bean temp : list){
			Object[]  obj = new Object[5]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getProductName();
			obj[3] = temp.getProdMetatag();
			obj[4] = temp.getModelNum();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/TP_bkup_remaining/New_TP/Selenium Training/testdata1.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
