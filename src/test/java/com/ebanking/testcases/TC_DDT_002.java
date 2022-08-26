package com.ebanking.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.generics.BaseClass;
import com.ebanking.pageobjects.loginPage;
import com.ebanking.utilities.Utility_Xlsx_for_DDT;

public class TC_DDT_002 extends BaseClass
{
	@DataProvider(name="DDT_data")
	public String [][] testdata() throws IOException
	{
		String filepath="./src/test/resources/testdata/DDT_Data.xlsx";
		int rows=Utility_Xlsx_for_DDT.getRowcount(filepath,"Sheet1");
		int cols=Utility_Xlsx_for_DDT.getColumncount(filepath, "Sheet1");
		String DDTdata[][]=Utility_Xlsx_for_DDT.getExceldata(filepath,"Sheet1",rows,cols);
		return DDTdata;
	}
	@Test(dataProvider="DDT_data")
	public void DDT_on_login(String username,String password) throws InterruptedException
	{
		lpage=new loginPage(driver);
		
		logger.info("user Entering the username");
		
		lpage.setUidtxt(username);
		
		Thread.sleep(1000);
		
		logger.info("user entering the password");
		
		lpage.setPwdtxt(password);
		Thread.sleep(1000);
		
		logger.info("user clicking the login button");
		
		lpage.setLoginbtn();
		Thread.sleep(1000);
		
		if(isAlertpresent()==true)
		{
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
		}
		else 
		{
			logger.info("user clicking the logout button");
			lpage.clickLogoutbtn();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
		}
	}
	

}
