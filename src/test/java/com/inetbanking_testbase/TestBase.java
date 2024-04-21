package com.inetbanking_testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
  
	@BeforeSuite
	public void init() {
	
	}
	
	@BeforeClass
	public void initWebObject()  
	{
		
    }
	
	@BeforeMethod
	public void setUp() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void teardown() {
	driver.quit();
	}
}
