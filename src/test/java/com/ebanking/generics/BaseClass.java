package com.ebanking.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.ebanking.pageobjects.AddNew_CustomerPage;
import com.ebanking.pageobjects.DeleteCustomerPage;
import com.ebanking.pageobjects.EditCustomerPage;
import com.ebanking.pageobjects.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class BaseClass 

{
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static SoftAssert sassert =new SoftAssert();
	public static read_common_data rd=new read_common_data();
	public static Logger logger;
	public static loginPage lpage;
	public static AddNew_CustomerPage newcust;
	public EditCustomerPage editcust;
	public DeleteCustomerPage deletecust;
	
	public static List<String> custidlist=new ArrayList<String>();
	
	//custidlist.add("66586");

	@Parameters("browser")
	@BeforeTest(groups="EditTest")
	public void setUP(String type) throws IOException
	{
		custidlist.add("18005");
		custidlist.add("66586");
		logger=Logger.getLogger("Selenium_mini_project_001");
		PropertyConfigurator.configure("log4j.properties");
		if(type.equals("chrome"))
		{
			logger.info("chrome browser started to launch");
			//System.setProperty("webdriver.chrome.driver", rd.getChromepath());
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(type.equals("firefox"))
		{
			logger.info("firefox browser started to launch");
			System.setProperty("webdriver.gecko.driver", rd.getFirefoxpath());
			driver=new FirefoxDriver();

		}
		else if(type.equals("ie"))
		{
			logger.info("IE browser started to launch");
			System.setProperty("webdriver.ie.driver", rd.getIEpath());
			driver=new InternetExplorerDriver();
		}
		else if(type.equals("edge"))
		{
			logger.info("Edge browser started to launch");
			System.setProperty("webdriver.edge.driver", rd.getEdgepath());
			driver=new EdgeDriver();
		}

		logger.info("Opening the url");
		driver.get(rd.getApplicationURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	@AfterTest(groups="EditTest")
	public void tearDown()
	{
		logger.info("Closing the browser");
		driver.close();
	}
	public static boolean isAlertpresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
	public static String getRandom_Email()
	{
		String randomemail=RandomStringUtils.randomAlphabetic(7);
		return (randomemail+"@gmail.com");

	}
	public static String getRandom_Password()
	{
		String password=RandomStringUtils.randomAlphanumeric(7);
		return password;
	}
	public static String getRandom_MobileNumber()
	{
		String mobile=RandomStringUtils.randomNumeric(10);
		return mobile;
	}
	public static String getRandom_Pincode()
	{
	String pin=	RandomStringUtils.randomNumeric(6);
	return pin;
	}

}
