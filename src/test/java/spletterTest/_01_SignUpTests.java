package spletterTest;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import helper.DataProv;
import helper.Help;

public class _01_SignUpTests extends Init {

	public static String Email = DataProv.prop("Email");
	public static String Password = DataProv.prop("Password");

	@Test(groups = "SignUp")
	public void _01_T_SignUp() throws InterruptedException {

		splash.signUpButton.click();
		Assert.assertEquals(signUp.su_title.getText(), "Sign Up");
		Thread.sleep(2000);

	}

	@Test(groups = "SignUp")
	public void _02_T_SignUp() throws InterruptedException {

		Assert.assertTrue(signUp.email_TxField.isDisplayed());

	}

	@Test(groups = "SignUp")
	public void _03_T_SignUp() throws InterruptedException {

		Assert.assertTrue(signUp.password_TxField.isDisplayed());

	}

	@Test(groups = "SignUp")
	public void _04_T_SignUp() throws InterruptedException {

		Assert.assertEquals(
				signUp.agreement_Text.getText(),
				"By creating an account, you agree to the Terms of Use and you acknowledge that you have read the Privacy Policy");

	}

	@Test(groups = "SignUp")
	public void _05_T_SignUp() throws InterruptedException {

		signUp.password_TxField.click();
		Help.tapOnDone(driver, signUp.su_title);
		Assert.assertEquals(signUp.alertTitle.getText(), "Oops!");
		Assert.assertEquals(signUp.message.getText(),
				"Email cannot be blank.\nPassword cannot be blank.");
		signUp.okButton.click();
			}

	@Test(groups = "SignUp")
	public void _06_T_SignUp() throws InterruptedException {

//		driver.hideKeyboard();
//		driver.sendKeyEvent(AndroidKeyCode.BACK);
//		splash.signUpButton.click();
		signUp.email_TxField.sendKeys("qq@qq");
		signUp.password_TxField.sendKeys("");
		
		Help.tapOnDone(driver, signUp.su_title);
		
		Assert.assertEquals(signUp.message.getText(),
				"Email is not a valid email address.\nPassword cannot be blank.");
		signUp.okButton.click();
	}

	@Test(groups = "SignUp")
	public void _07_T_SignUp() throws InterruptedException {

		signUp.password_TxField.sendKeys("12345");

		Help.tapOnDone(driver, signUp.su_title);
		
		if (signUp.message.getText() == "Something got wrong. Please try again later."){
			driver.tap(1, signUp.okButton, 1);
			
		}
		else{
			Assert.assertEquals(signUp.alertTitle.getText(), "Oops!");
			Assert.assertEquals(
					signUp.message.getText(),
					"Email is not a valid email address.\nPassword should contain at least 6 characters.");
			signUp.okButton.click();
		}
		
	}
	
	@Test(groups = "SignUp")
	public void _08_T_SignUp() throws InterruptedException {

		driver.hideKeyboard();
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		Assert.assertEquals(splash.signInButton.getText(),
				"Sign In");
	}
	
	@Test(groups = "SignUp")
	public void _09_T_SignUp() throws InterruptedException {

		splash.signUpButton.click();
		signUp.email_TxField.sendKeys(Email);
		signUp.password_TxField.sendKeys(Password);
		Help.tapOnDone(driver, signUp.su_title);
		Thread.sleep(1000);
		Assert.assertEquals(
				signUp.message.getText(),
				"This email address has already been taken.");
	}
	
	@Test(groups = "SignUp")
	public void _10_T_SignUp() throws InterruptedException {

		signUp.okButton.click();
		String email = Help.randomEmail(3, 5);
		System.out.println("email - " + email);
		signUp.email_TxField.sendKeys(email);
		signUp.password_TxField.sendKeys(Password);
		Help.tapOnDone(driver, signUp.su_title);
		Assert.assertTrue(compose.gallery_icon.isDisplayed());
	}

}
