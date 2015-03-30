package pages;

import io.appium.java_client.AppiumDriver;
import helper.Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
	
private static WebDriver driver;
	
	public SignInPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Sign In") 
	public WebElement title_view;
	
	@FindBy(id = "com.spletter.spletter:id/email_address_edittext") 
	public WebElement email_address;
	
	@FindBy(id = "com.spletter.spletter:id/password_edittext") 
	public WebElement password;
	
	@FindBy(id = "com.spletter.spletter:id/forgot_password_text") 
	public WebElement forgot_password;
	
	@FindBy(id = "android:id/alertTitle") 
	public WebElement alertTitle;
	
	@FindBy(id = "android:id/message") 
	public WebElement message;
	
	@FindBy(id = "android:id/button1") 
	public WebElement okButton;
	
		
	public void signIn(String email, String password_) throws InterruptedException{
						
		email_address.sendKeys(email);
		password.sendKeys(password_);
		Help.tapOnDone((AppiumDriver) driver, title_view);
	}

}
