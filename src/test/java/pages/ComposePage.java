package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposePage {
	
	private static WebDriver driver;
	
	public ComposePage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.spletter.spletter:id/menu_icon") 
	public WebElement menu_icon;
	
	@FindBy(id = "com.spletter.spletter:id/dollars_count") 
	public WebElement dollars_count;
	
	@FindBy(id = "com.spletter.spletter:id/gallery_icon") 
	public WebElement gallery_icon;
	
	@FindBy(xpath = "//android.widget.ImageView[3]") 
	public WebElement arrow_button;
	
	@FindBy(className = "android.widget.EditText") 
	public WebElement text_fields;
	
	@FindBy(id = "com.spletter.spletter:id/view_pager") 
	public WebElement view_pager;

}
