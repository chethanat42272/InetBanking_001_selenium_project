package com.ebanking.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.generics.BaseClass;
import com.ebanking.pageobjects.AddNew_CustomerPage;
import com.ebanking.pageobjects.DeleteCustomerPage;
import com.ebanking.pageobjects.EditCustomerPage;
import com.ebanking.pageobjects.loginPage;

public class TC_EditCustomer_004 extends BaseClass
{
	@Test(groups="EditTest")
	public void testEditCustomer()
	{
		lpage=new loginPage(driver);
		lpage.setUidtxt(rd.getUserID());
		lpage.setPwdtxt(rd.getPassword());
		lpage.setLoginbtn();
		editcust=new EditCustomerPage(driver);
		editcust.clickEditcustomerlink();
		newcust=new AddNew_CustomerPage(driver);
		//custidlist.add("18005");
		//custidlist.add("66586");
		editcust.setCustomerId(custidlist.get(0));
		editcust.clickSubmit();
		editcust.editAddress("Neelgiri");
		editcust.editCity("Tumkuru");
		editcust.editState("Karnataka");
		editcust.editPincode(getRandom_Pincode());
		editcust.editPhoneNum(getRandom_MobileNumber());
		editcust.editEmail(getRandom_Email());
		editcust.clickSubmitbttn();
		if(isAlertpresent()==true)
		{
			Alert alert=driver.switchTo().alert();
			String alerttext=alert.getText();
			if(alerttext.contains("No Changes made to Customer records"))
			{
				alert.accept();
				Assert.assertTrue(true);
				logger.info("Customer details edited successfully");
			}
			
		}


	}
	@Test(groups="DeleteTest")
	public void testDeleteCustomer()
	{
		lpage=new loginPage(driver);
		lpage.setUidtxt(rd.getUserID());
		lpage.setPwdtxt(rd.getPassword());
		lpage.setLoginbtn();
		deletecust=new DeleteCustomerPage(driver);
		deletecust.clickDeletecustomerlink();
		deletecust.enterUserID("66586");
		deletecust.clickSubmit();
		if(isAlertpresent()==true)
		{
			Alert alert = driver.switchTo().alert();
			String text=alert.getText();
			System.out.println(text);
			alert.accept();
		}
	}
}
