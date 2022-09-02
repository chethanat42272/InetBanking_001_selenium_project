package com.ebanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.utilities.Waithelper;

public class DeleteCustomerPage {

	@FindBy(linkText="Delete Customer")
	WebElement deletecustlink;
	@FindBy(how=How.XPATH,using="//input[@name='cusid']")
	WebElement custid;
	@FindBy(name="AccSubmit")
	WebElement submit;
	
	WebDriver driver;
	Waithelper helper;
	public DeleteCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helper=new Waithelper(driver);
	}
	
	public void clickDeletecustomerlink()
	{
		deletecustlink.click();
	}
	public void enterUserID(String uid)
	{
		helper.waitForElementVisible(custid, 5);
		custid.sendKeys(uid);
	}
	public void clickSubmit()
	{
		submit.click();
	}
}
