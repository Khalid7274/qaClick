package testCases;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginWithParamater extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void mybeforeMethod() throws IOException {
		inicilizeDriver();
	}
	
	@Test(groups="smoke",dataProvider="getData")
	public void loginTest(String name, String pass, String text) {
		HomePage homePage=new HomePage();
		loginPage=homePage.getLogin();
		loginPage.getSignIn(name, pass);
		System.out.println(text);
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object [][] data=new Object[2][3];
		
		//First Set Data
				data[0][0]="Admin";
				data[0][1]="admin123";
				data[0][2]="Admin test";
				
				//First Set Data
				data[1][0]="administrator";
				data[1][1]="khan";
				data[1][2]="Administrator test";
				
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
