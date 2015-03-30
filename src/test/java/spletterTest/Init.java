package spletterTest;


import helper.DataProv;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.ComposePage;
import pages.SignInPage;
import pages.SignUpPage;
import pages.SplashPage;





public class Init {
	
	public AppiumDriver driver;
	private String URL = DataProv.prop("URL");
	private String APK = DataProv.prop("APK");
	
	public SplashPage splash;
	public SignUpPage signUp;
	public ComposePage compose;
	public SignInPage signIn;


	@BeforeClass
	public void setUp() throws Exception {
		
//		File appDir = new File("../WirknTest");
//		File app = new File(appDir, "app-debug.apk");
		
		File appDir = new File(URL);
		File app = new File(appDir, APK);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android"); // 192.168.56.101:5555
		cap.setCapability("deviceName", "192.168.56.102:5555");
//		cap.setCapability("device", "192.168.56.102:5555");
		cap.setCapability("platformVersion", "4.4");
		cap.setCapability("app-package", "com.spletter.spletter");
		cap.setCapability("app", app.getAbsolutePath());
		

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap) {

			public MobileElement scrollToExact(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public MobileElement scrollTo(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			
		};
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		splash = new SplashPage(driver);
		signUp = new SignUpPage(driver);
		signIn = new SignInPage(driver);
		compose = new ComposePage(driver);
	}
	


	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
