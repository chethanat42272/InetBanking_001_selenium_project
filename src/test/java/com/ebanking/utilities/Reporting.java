package com.ebanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ebanking.generics.BaseClass;

public class Reporting extends BaseClass implements ITestListener
{
public ExtentHtmlReporter htmlreporter;
public ExtentTest test;
public ExtentReports extent;
@Override
public void onTestSuccess(ITestResult tr) {
	test=extent.createTest(tr.getName());
	test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
}
@Override
public void onTestFailure(ITestResult tr) {
	test=extent.createTest(tr.getName());
	test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	String screenshotpath="./Screenshot/"+tr.getName()+".png";
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);//taking the Screenshot
	
	
	File dest=new File("./Screenshot/"+tr.getName()+".png");//creating the Screenshotfolder and storing the screenshot with a name of current testmethodName with .png extension 
	
		try {
			FileUtils.copyFile(src, dest);
			test.fail("Screenshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}
@Override
public void onTestSkipped(ITestResult tr) {
	test=extent.createTest(tr.getName());
	test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
}
@Override
public void onStart(ITestContext testContext) 
{
String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
String repname="test-Report-"+timestamp+".html";
htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repname);
htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

extent=new ExtentReports();
extent.attachReporter(htmlreporter);
extent.setSystemInfo("Host name","localhost");
extent.setSystemInfo("Environment","QA");
extent.setSystemInfo("user", "Chethan");

htmlreporter.config().setDocumentTitle("InetBanking Test Project");//title of the report
htmlreporter.config().setReportName("Functional Test Report");//name of the report
htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
htmlreporter.config().setTheme(Theme.DARK);

}
@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}
@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}
@Override
public void onFinish(ITestContext context) {
	extent.flush();
	
}



}
