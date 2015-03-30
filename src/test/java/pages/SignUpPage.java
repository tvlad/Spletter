package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
private static WebDriver driver;
	
	public SignUpPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Sign Up") 
	public WebElement su_title;
	
	@FindBy(id = "com.spletter.spletter:id/email_address_edittext")
	public WebElement email_TxField;
	
	@FindBy(id = "com.spletter.spletter:id/new_password_edittext")
	public WebElement password_TxField;
	
	@FindBy(id = "com.spletter.spletter:id/agreementTextView")
	public WebElement agreement_Text;
	
	@FindBy(className = "android.widget.FrameLayout")
	public WebElement all;
	
//	
	@FindBy(id = "android:id/alertTitle")
	public WebElement alertTitle;
	
	@FindBy(id = "android:id/message")
	public WebElement message;
	
	@FindBy(id = "android:id/button1")
	public WebElement okButton;
	
	
	
	

}


