package com.ebanking.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waithelper 
{
	WebDriver driver;
	public Waithelper(WebDriver driver)
	{
		this.driver=driver;
		
	}
public void waitForElementVisible(WebElement ele,long time)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
	wait.until(ExpectedConditions.visibilityOf(ele));
}
	
}
