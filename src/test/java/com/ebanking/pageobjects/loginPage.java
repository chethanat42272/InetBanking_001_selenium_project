package com.ebanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
@FindBy(how = How.NAME,using="uid")
@CacheLookup
WebElement uidtxt;

@FindBy(how=How.XPATH,using="//input[@type='password']")
@CacheLookup
WebElement pwdtxt;

@FindBy(name="btnLogin")
@CacheLookup
WebElement loginbtn;

@FindBy(xpath="//a[text()='Log out']")
@CacheLookup
WebElement logoutbtn;

WebDriver driver;
public loginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void setUidtxt(String uname) {
	uidtxt.sendKeys(uname);
}

public void setPwdtxt(String PWD) {
	pwdtxt.sendKeys(PWD);
}

public void setLoginbtn() {
	loginbtn.click();
}
public void clickLogoutbtn()
{
	logoutbtn.click();
}


	
}
