package helper;

import io.appium.java_client.AppiumDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class Help {

//	@SuppressWarnings("unused")
//	private static WebDriver driver;

	public static String randomEmail(int min, int max) {

		String allowedChars = "abcdefghiklmnopqrstuvwxyz";
		String randommail = "";
		int num = (int) (Math.floor(Math.random() * (max - min)) + min);

		for (int i = 0; i < num; i++) {
			int rnum = (int) Math.floor(Math.random() * allowedChars.length());
			randommail = randommail + allowedChars.subSequence(rnum, rnum + 1);
		}

		randommail += "@test.com";
		// System.out.println(randomstring);
		return randommail;

	}

	public static String randomLogin(int min, int max) {

		String randomstring = "";
		String allowedChars1 = "bcdfghklmnpqrstvwxz";
		String allowedChars2 = "aeiouy";
		int num = (int) (Math.floor(Math.random() * (max - min)) + min);

		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				int rnum2 = (int) Math.floor(Math.random()
						* allowedChars1.length());
				randomstring += allowedChars1.substring(rnum2, rnum2 + 1);
			}

			else {
				int rnum = (int) Math.floor(Math.random()
						* allowedChars2.length());
				randomstring += allowedChars2.substring(rnum, rnum + 1);
			}
		}
		randomstring = randomstring.toUpperCase().substring(0, 1)
				+ randomstring.substring(1);

		return randomstring;
	}

	public static String CurDateString() {
		Calendar now = Calendar.getInstance();
		String curDate = now.get(Calendar.DATE) + "-"
				+ (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.YEAR);
		return curDate;
	}



	public static String CurDate() {
		Calendar now = Calendar.getInstance();
		String months[] = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };

		String CurDate = months[now.get(Calendar.MONTH)].substring(0, 3) + ". "
				+ now.get(Calendar.DATE) + ", " + now.get(Calendar.YEAR);
		return CurDate;
	}

	public static String[] splitStr(String s, String _chr) {
		String[] splits = s.split("[" + _chr + "]+"); // "[-,. ]+"
		return splits;
	}
	

	public static String dateTitle() {

		Date date = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 6);
		Date date2 = c.getTime();

		SimpleDateFormat ft_1 = new SimpleDateFormat("MMM. dd - ", Locale.CANADA);
		SimpleDateFormat ft_2 = new SimpleDateFormat("MMM. dd, YYYY", Locale.CANADA);

		String CurDate = ft_1.format(date) + ft_2.format(date2);

		return CurDate;

	}
	
	public static boolean isElementPresent(WebDriver driver, By locator) {
		  return driver.findElements(locator).size() > 0;
		}
	
	
	public static void elListener(WebDriver driver, By locator)
			throws InterruptedException {

		for (int i = 0; i < 30;) {
			if (isElementPresent(driver, locator) == true) {
				Thread.sleep(1000);
				i++;
			} else {
				break;
			}
		}
	}
	
	
	public static void leftSwipe(AppiumDriver driver, WebElement el) {
		
		Point sd = el.getLocation();
		driver.swipe(500, sd.y, 100, sd.y, 350);

	}
	
	public static void tapOnDone(AppiumDriver driver, WebElement el) {
		
		if (el.getLocation().x > 290) {
			driver.tap(1, 1070, 1765, 1);
		}
		if (el.getLocation().x <= 280) {
			driver.tap(1, 700, 1270, 1);
		}

	}
}
