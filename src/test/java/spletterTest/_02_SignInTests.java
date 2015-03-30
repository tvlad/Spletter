package spletterTest;

import io.appium.java_client.android.AndroidKeyCode;
import helper.DataProv;
import helper.Help;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_SignInTests extends Init{
	
	public static String Email = DataProv.prop("Email");
	public static String Password = DataProv.prop("Password");

	@Test(groups = "SignIn")
	public void _01_T_SignIn() throws InterruptedException {

		splash.signInButton.click();
		Assert.assertEquals(signIn.title_view.getText(), "Sign In");
		Thread.sleep(2000);

	}
	
	@Test(groups = "SignIn")
	public void _02_T_SignIn() throws InterruptedException {

		Assert.assertTrue(signIn.email_address.isDisplayed());

	}

	@Test(groups = "SignIn")
	public void _03_T_SignIn() throws InterruptedException {

		Assert.assertTrue(signIn.password.isDisplayed());

	}

	@Test(groups = "SignIn")
	public void _04_T_SignIn() throws InterruptedException {

		Assert.assertEquals(signIn.forgot_password.getText(), "Forgot your password?");
	}
	
	@Test(groups = "SignIn")
	public void _05_T_SignIn() throws InterruptedException {

		signIn.password.click();
		Help.tapOnDone(driver, signIn.title_view);
		Assert.assertEquals(signIn.alertTitle.getText(), "Oops!");
		Assert.assertEquals(signUp.message.getText(),
				"Email cannot be blank.\nPassword cannot be blank.");
		
	}
	
	@Test(groups = "SignIn")
	public void _06_T_SignUp() throws InterruptedException {
		
		signIn.okButton.click();
		signIn.email_address.sendKeys("qq@qq");
		signIn.password.sendKeys("");
		Help.tapOnDone(driver, signIn.title_view);
		Assert.assertEquals(signIn.alertTitle.getText(), "Oops!");
		Assert.assertEquals(signIn.message.getText(),
				"Password cannot be blank.\nEmail is not a valid email address.");
		
	}
	
	@Test(groups = "SignIn")
	public void _07_T_SignUp() throws InterruptedException {
		
		signIn.okButton.click();
		signIn.email_address.sendKeys("qq@qq.dfdd");
		signIn.password.sendKeys("12345");
		Help.tapOnDone(driver, signIn.title_view);
		Assert.assertEquals(signIn.alertTitle.getText(), "Oops!");
		Assert.assertEquals(signIn.message.getText(),
				"Incorrect email or password.");
		
	}
	
	@Test(groups = "SignIn")
	public void _08_T_SignUp() throws InterruptedException {
		
		signIn.okButton.click();
		driver.hideKeyboard();
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		Assert.assertEquals(splash.signInButton.getText(),
				"Sign In");
		
	}
	
	@Test(groups = "SignIn")
	public void _09_T_SignUp() throws InterruptedException {
		
		signIn.okButton.click();
		driver.hideKeyboard();
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		Assert.assertEquals(splash.signInButton.getText(),
				"Sign In");
		
	}
	
	@Test(groups = "SignIn")
	public void _10_T_SignUp() throws InterruptedException {
		
		splash.signInButton.click();
		signIn.signIn(Email, Password);
		Assert.assertTrue(compose.gallery_icon.isDisplayed());
	}


}
