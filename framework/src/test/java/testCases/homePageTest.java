package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.Log;

public class homePageTest extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void mybeforeMethod() throws IOException {
		Log.info("Driver inicilized");
		inicilizeDriver();
	}
	
	@Test(groups={"smoke","sanity","regression"})
	public void titleValidation() {
		Log.startTest("loginTest");
		Log.info("Home Page is Opened");
		HomePage homePage=new HomePage();
		//compare the text from the browser with actual text . -Error
		Log.debug("Featured Course Validation");
		String expected="FEATURED COURSESs";
		String actualText=homePage.getTitle().getText();
		Assert.assertEquals(actualText, expected);
		Log.info("Successfully validated text message");
		Log.endTest("ltitleValidation");
	}
	
	@Test(groups={"smoke","regression"})
	public void validationOfNavbar() {
		HomePage homePage=new HomePage();
		Log.startTest("validationOfNavbar");
		Log.info("Navbar Validation Start");
		Assert.assertTrue(homePage.getNavBar().isDisplayed());
		Log.info("Navigation bar  is present");
		Log.endTest("validationOfNavbar");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
