package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class HomePage extends BaseClass{

	@FindBy (css="a[href*='sign_in']")
	WebElement clickLogin;
	
	@FindBy (css="div[class='text-center'] h2")
	WebElement title;
	
	@FindBy (css="nav[class='navbar-collapse collapse'] ul ")
	WebElement navbar;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage getLogin() {
		clickLogin.click();
		return new LoginPage();
	}
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getNavBar() {
		return navbar;
	}
}
