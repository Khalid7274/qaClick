package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Log;




public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public void beforesuite() {
		DOMConfigurator.configure("log4j2.xml");
		Log.info("Base Class Loaded");
	}
	
	public WebDriver inicilizeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\configration\\config.properties");
		
		prop.load(fis);
		String browserName=System.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//execute in Chrome driver 
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Browser is: "+prop.getProperty("browser"));
		}else if(browserName.equalsIgnoreCase("firefox")){
			//execute in firefox driver
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 System.out.println("Browser is: "+prop.getProperty("browser"));
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 System.out.println("Browser is: "+prop.getProperty("browser"));
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
	@AfterSuite
	public void afterSuite() {
		Log.info("After test Suite");
	}
}
