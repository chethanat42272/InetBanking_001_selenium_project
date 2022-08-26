package com.ebanking.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ebanking.generics.BaseClass;
import com.ebanking.pageobjects.New_CustomerPage;
import com.ebanking.pageobjects.loginPage;

public class TC_addnewcustomer_003 extends BaseClass
{
	
	@Test
	public void createNewCustomer() throws InterruptedException
	{
		lpage=new loginPage(driver);
		logger.info("User entering the userID");
		lpage.setUidtxt(rd.getUserID());
		logger.info("user entering the password");
		lpage.setPwdtxt(rd.getPassword());
		logger.info("user clicking the login button");
		lpage.setLoginbtn();
		Thread.sleep(4000);
		newcust=new New_CustomerPage(driver);
		newcust.click_new_customer_link();
		Thread.sleep(4000);
		try {
		newcust.handlePopup();
		}
		catch(Exception e)
		{
			
		}
		newcust.setCustomerName("Raj");
		newcust.setGender("male");
		newcust.setDate_of_birth("05", "12", "2000");
		Thread.sleep(4000);
		newcust.setAddress("Basavanagudi");
		newcust.setCity("Bengalure");
		newcust.setState("Karnataka");
		newcust.setPIN_Code("560091");
		newcust.setMobile_number(getRandom_MobileNumber());
		newcust.setEmail(getRandom_Email());
		newcust.setPassword(getRandom_Password());
		newcust.click_Submit();
		Thread.sleep(4000);
		String msg=newcust.getSuccessmessage();
		Reporter.log(msg,true);
		Reporter.log(newcust.getAddedcustomer_details(),true);
		if( driver.getPageSource().contains("Customer Registered Successfully!!")==true)
		{
			Assert.assertTrue(true);
			
		}
		else 
		{
			Assert.assertFalse(false);
		}
		
	}

}
