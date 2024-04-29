package com.inetbanking_utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Helper {

	// by using this utility method we can perform all bellow method-->

	// switch to tab or window
	// switch to alert
	// switch to frame
	// handle Drop Down
	// capture screenshot
	// generate reports and so on...
	// by using utility method we can create next level frame

	public static void handleAlert(WebDriver driver) {

		if (isAlertPresent(driver)) {

			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// handle Select DropDown.//and this method is also known as Compile Time
	// PolyMorphism

	public static void selectDropdownByUsingIndex(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);
	}

	public static void selectDropdownByUsingVisibleText(WebElement ele, String visibleTxt) {
		new Select(ele).selectByVisibleText(visibleTxt);
	}

	public static void selectDropdownByUsingValue(String value, WebElement ele) {
		new Select(ele).selectByValue(value);
	}

	// Handle Frames

	public static void switchToFrame(WebDriver driver, int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebDriver driver, String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebDriver driver, WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToDefaultContain(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Handle Multiple Tab or Window.

	public static void handleTabOrWindow(WebDriver driver) {
		try {
			// to fetch all the window Id use below code.
			String parentWin = driver.getWindowHandle();
			Set<String> winids = driver.getWindowHandles();
			for (String win : winids) {

				if (win != parentWin) {
					driver.switchTo().window(win);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Capture the ScreenShort of OutPut.

	public static void captureScreenshot(WebDriver driver) {

		String screenshotpath = "./Screenshot/inetBanking_" + getCurrentDateAndTime() + ".png";
		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(screenshotpath));
			System.out.println("Screenshot is captured");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentDateAndTime() {
		return new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date());
	}

}

