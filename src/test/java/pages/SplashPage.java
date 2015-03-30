package pages;


//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import spletterTest.Init;

public class SplashPage extends Init {
	

	private static WebDriver driver;
	
	public SplashPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.spletter.spletter:id/connectWithFacebookButton") //com.wirkn.wirkn.debug:id/bt_sign_in
	public WebElement fb_button;
	
	@FindBy(id = "com.spletter.spletter:id/signInButton")
	public WebElement signInButton;
	
	@FindBy(id = "com.spletter.spletter:id/signUpButton")
	public WebElement signUpButton;
	

}
