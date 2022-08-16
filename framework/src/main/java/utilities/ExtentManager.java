package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	
	
	public static ExtentReports setExtent() {
		
		 htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+"indexReport.html");
		 htmlReporter.config().setReportName("Web Automation Result");
		 htmlReporter.config().setDocumentTitle("Test Result");
	
		 
		 
		 extent=new ExtentReports();
		 
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Project Name", "OWDN");
		 extent.setSystemInfo("OS", "Windows");
		 extent.setSystemInfo("Tester", "Nematullah Khalid");
		 extent.setSystemInfo("Browser", "Chrome");
		 
		 return extent;
	}



}
