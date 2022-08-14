package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy (id="user_email")
	WebElement email;
	
	@FindBy (id="user_password")
	WebElement typePass;
	
	@FindBy (css="input[name='commit']")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage getSignIn(String em, String pass) {
		email.sendKeys(em);
		typePass.sendKeys(pass);
		loginButton.click();
		return new HomePage();
	}
	
	public WebElement clickOnLoginButton() {
		return loginButton;
	}
}
