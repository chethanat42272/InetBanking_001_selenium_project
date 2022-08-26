package com.ebanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.utilities.Waithelper;

public class New_CustomerPage 
{
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")
	@CacheLookup
	WebElement addnewcust;
	@FindBy(how=How.XPATH,using="//input[@name='name']")
	@CacheLookup
	WebElement nametext;
	@FindBy(xpath="//*[@id=\"dismiss-button\"]/div/span")
	@CacheLookup
	WebElement popup;
	@FindBy(xpath="//input[@value='m']")
	@CacheLookup
	WebElement male;
	@FindBy(xpath="//input[@value='f']")
	@CacheLookup
	WebElement female;
	@FindBy(how=How.ID,using="dob")
	@CacheLookup
	WebElement dob;
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement address;
	@FindBy(name="city")
	@CacheLookup
	WebElement City;
	@FindBy(name="state")
	@CacheLookup
	WebElement state;
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pincode;
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement mob;
	@FindBy(name="emailid")
	@CacheLookup
	WebElement Email;
	@FindBy(name="password")
	@CacheLookup
	WebElement pwd;
	@FindBy(name="sub")
	@CacheLookup
	WebElement submit;
	@FindBy(xpath="//p[text()='Customer Registered Successfully!!!']")
	@CacheLookup
	static WebElement successmsg;
	@FindBy(xpath="//table[@id='customer']/tbody")
	@CacheLookup
	static WebElement resulttable;

	WebDriver driver;
	static Waithelper helper;
	public New_CustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helper=new Waithelper(driver);
	}
	public void click_new_customer_link()
	{
		helper.waitForElementVisible(addnewcust, 10);
		addnewcust.click();
	}
	public void handlePopup()
	{
		popup.clear();
	}
	public void setCustomerName(String custname)
	{
		helper.waitForElementVisible(nametext, 10);
		nametext.sendKeys(custname);
	}
	public void setGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			male.click();
		}
		else if(gender.equalsIgnoreCase("Female"))
		{
			female.click();
		}
	}
	public void setDate_of_birth(String month,String day,String year)
	{
		dob.sendKeys(month);
		dob.sendKeys(day);
		dob.sendKeys(year);
	}

	public void setAddress(String addr)
	{
		address.sendKeys(addr);
	}
	public void setCity(String city)
	{
		City.sendKeys(city);
	}
	public void setState(String State)
	{
		state.sendKeys(State);
	}
	public void setPIN_Code(String pin)
	{
		pincode.sendKeys(pin);
	}
	public void setMobile_number(String mobile)
	{
		mob.sendKeys(mobile);
	}
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	public void setPassword(String password)
	{
		pwd.sendKeys(password);
	}
	public void click_Submit()
	{
		submit.click();
	}
	public static String getSuccessmessage()
	{
		helper.waitForElementVisible(successmsg, 5);
		return (successmsg.getText());
	}
	public static String getAddedcustomer_details()
	{
		return (resulttable.getText());
	}
}
