package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseClass.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
	
	ExtentReports extent=ExtentManager.setExtent();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	DateFormat dateFormat=new  SimpleDateFormat("yy-MM-dd");
	Date date=new Date();
	String currentDate=dateFormat.format(date);

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getName());
		 extentTest.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		 extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 extentTest.get().fail(result.getThrowable());
		String distinationFile= System.getProperty("user.dir")+"\\reports\\"+currentDate+" - "+result.getName()+".png";
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//for jenkins part
		String imagePath="http://localhost:9595/job/FrameWorkProject/ws/framework/reports/"+currentDate+" - "+result.getName()+".png";
		try {
			FileUtils.copyFile(src, new File(distinationFile));
			//extentTest.get().addScreenCaptureFromPath(distinationFile, result.getName());
			extentTest.get().fail(result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}


	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	
}
