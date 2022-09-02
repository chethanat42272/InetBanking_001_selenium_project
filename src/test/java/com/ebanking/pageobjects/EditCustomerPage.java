package com.ebanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.utilities.Waithelper;

public class EditCustomerPage {

	@FindBy(how=How.XPATH,using="//a[text()='Edit Customer']")
	WebElement editcust;
	@FindBy(xpath="//input[@name='cusid']")
	WebElement custid;
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitbttn;
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	@FindBy(xpath="//input[@name='city']")
	WebElement editcity;
	@FindBy(xpath="//input[@name='state']")
	WebElement editstate;
	@FindBy(xpath="//input[@name='pinno']")
	WebElement editpincode;
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement editphone;
	@FindBy(xpath="//input[@name='emailid']")
	WebElement editEmail;
	@FindBy(xpath="//input[@name='sub']")
	WebElement submit;

	WebDriver driver;
	Waithelper helper;
	public EditCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		helper=new Waithelper(driver);
	}
	public void clickEditcustomerlink()
	{
		editcust.click();
	}
	public void setCustomerId(String id)
	{
		helper.waitForElementVisible(custid, 5);
		custid.sendKeys(id);
	}
	public void clickSubmit()
	{
		submitbttn.click();
	}
	public void editAddress(String add)
	{
		helper.waitForElementVisible(address, 4);
		address.clear();
		address.sendKeys(add);
	}
	public void editCity(String city)
	{
		editcity.clear();
          editcity.sendKeys(city);
	}
	public void editState(String state)
	{
		editstate.clear();
		editstate.sendKeys(state);
	}
	public void editPincode(String pin)
	{
		editpincode.clear();
		editpincode.sendKeys(pin);
	}
	public void editPhoneNum(String phn)
	{
		editphone.clear();
		editphone.sendKeys(phn);
	}
	public void editEmail(String mailid)
	{
		editEmail.clear();
		editEmail.sendKeys(mailid);
	}
	public void clickSubmitbttn()
	{
		submit.click();
	}
}
