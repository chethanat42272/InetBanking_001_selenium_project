package com.ebanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.generics.BaseClass;
import com.ebanking.generics.read_common_data;
import com.ebanking.pageobjects.loginPage;

public class TC_logintestcase_001 extends BaseClass 
{
     @Test
	public void logintest() throws IOException, InterruptedException
	{
    	String userid=rd.getUserID();
    	String pwd=rd.getPassword();
    	lpage=new loginPage(driver);
    	
    	logger.info("Entering the uesrid");
    	lpage.setUidtxt(userid);
    	
    	logger.info("Entering the password");
    	lpage.setPwdtxt(pwd);

    	logger.info("Clicking the login button");
    	lpage.setLoginbtn();
    	 
    	Thread.sleep(3000);
    	if(driver.getTitle().equals(" Guru99 Bank Manager HomePage "))
    	{
    		Assert.assertTrue(true);
    		logger.info("testcase passed");
    	}
    	else
    	{
    		Assert.assertFalse(false);
    		logger.info("testcase failed");
    	}
    	
		
	}
     
}
