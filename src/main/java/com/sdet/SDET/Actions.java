package com.sdet.SDET;

import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Actions extends Base {

	// Click on button or link 
	public static void click(By locator, String locatorName)	throws Throwable {
		try {
			if(driver.findElements(locator).size()!=0){
				if(driver.findElement(locator).isEnabled()){
					Thread.sleep(1000);
					driver.findElement(locator).click();}}
		} catch (NoSuchElementException e) {
			System.out.println(e.toString());
			Assert.fail();
		}
	}

	// Enter the text in the text field.
	public static void enter(By locator, String value,String locatorName) throws Throwable {
		try {
			if(driver.findElements(locator).size()!=0)
			{
				if(driver.findElement(locator).isEnabled()){
					Thread.sleep(1000);
					driver.findElement(locator).clear();
					driver.findElement(locator).click();
					Thread.sleep(1000);
					driver.findElement(locator).sendKeys(value);
				System.out.println("Enter Value at : "+locatorName+"  : Value as "+value);	
				}
			}
		} catch (NoSuchElementException e) 
		{
			System.out.println(e.toString());
			Assert.fail();
		}
	}



	public static void waitForVisibilityOfElement(By locator , String locatorName) throws Throwable{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Expection : "+locatorName+"   :   "+e.toString());
		}

	}

	// Random Number Generate Method	
	public static int randomNumberGenerator()throws Throwable	
	{
		int range =  getRandomInteger(501, 2);
		//int range = getRandom(7);
		Random rand = new Random(System.currentTimeMillis());
		int PhNumber = rand.nextInt(range);
		System.out.println("Randome Phone number"+PhNumber);
		return PhNumber;
	}

	/*
	 * returns random integer between minimum and maximum range
	 */
	public static int getRandomInteger(int maximum, int minimum){
		return ((int) (Math.random()*(maximum - minimum))) + minimum;
	}



}
