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

	public static void handleAlert(WebDriver driver) {
		if (IsAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	static boolean IsAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Handle Select drop down
	public static void handleSelectDropdown(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);
	}

	public static void handleSelectDropdown(WebElement ele, String visibleTxt) {
		new Select(ele).selectByVisibleText(visibleTxt);
	}

	public static void handleSelectDropdown(String value, WebElement ele) {
		new Select(ele).selectByValue(value);
	}

	// handle Frames
	public static void switchToFrame(WebDriver driver, int index) {
		try {
			driver.switchTo().frame(index);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebDriver driver, String nameorId) {
		try {
			driver.switchTo().frame(nameorId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebDriver driver, WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToDefaultContent(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// handle Multiple Tab or Window

	public static void handleTabOrWindow(WebDriver driver) {
		try {
			String parentwin = driver.getWindowHandle();
			Set<String> winids = driver.getWindowHandles();
			for (String win : winids) {
				if (win != parentwin) {
					driver.switchTo().window(win);
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// capture Screenshot
	public static void captureScreenshot(WebDriver driver) {
		String screenshotpath = "./screenshot/inetBanking " + getCurrentDateAndTime() + ".png";
		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(screenshotpath));

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentDateAndTime() {
		return new SimpleDateFormat("MM_dd_YYYY_HH_mm_ss").format(new Date());
	}

}
