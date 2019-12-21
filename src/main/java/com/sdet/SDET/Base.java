package com.sdet.SDET;

import java.net.MalformedURLException; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public static WebDriver driver;
	@BeforeMethod()
	public void setUp() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://qainterview.merchante-solutions.com:8080/admin");

	}
	@AfterMethod
	public void closebrowser(){
		driver.close();
		//driver.quit();		
	}

}
