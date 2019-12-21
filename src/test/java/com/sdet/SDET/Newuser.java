package com.sdet.SDET;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Newuser extends Actions {
	

	@Test
	public void newusertest() throws Throwable{
		/**
		 * @author 
		 * Navigate to the application 
		 * click on the User Button in menu tab 
		 * 
		 */
		int value = randomNumberGenerator();
		String Firstname = "Mallikarjun"+value;
		System.out.println("Firstname : "+Firstname);
		System.out.println("Password : Mallikarjun");
		System.out.println("Email :  "+Firstname+"@gmail.com");
		
		String Url  = driver.getCurrentUrl();
		if(Url.equals("http://qainterview.merchante-solutions.com:8080/admin")){
			System.out.println("Given url is matching with launched Url  : "+Url);
			// click on the User link 
			if(driver.findElements(By.xpath("//*[@id='users']/a")).size()!=0){
				driver.findElement(By.xpath("//*[@id='users']/a")).click();
				waitForVisibilityOfElement(By.xpath("//*[@id='titlebar_right']/div/span/a"),"New User Button");
			if(driver.findElements(By.xpath("//*[@id='titlebar_right']/div/span/a")).size()!=0){
				click(By.xpath("//*[@id='titlebar_right']/div/span/a"), "click on the New User Button");
				if(driver.findElements(By.xpath("//*[@id='user_username']")).size()!=0){
					enter(By.xpath("//*[@id='user_username']"), Firstname, "username");
					enter(By.xpath("//*[@id='user_password']"), "Mallikarjun", "Password");
					enter(By.xpath("//*[@id='user_email']"), Firstname+"@gmail.com", "Email");
					click(By.xpath("//*[@id='user_submit_action']/input"), "Click on the Create User");					
					waitForVisibilityOfElement(By.xpath("//*[@class='flash flash_notice']"),"User was successfully created.");
					if(driver.findElements(By.xpath("//*[@class='flash flash_notice']")).size()!=0){
					String Text = driver.findElement(By.xpath("//*[@class='flash flash_notice']")).getText();
					if(Text.equals("User was successfully created.")){
						System.out.println("Pass:  "+Text);
					}else{
						System.out.println("Not Matching the test with  : "+Text);
					}
					}else{
						System.out.println("Fail : Not Displayed User was successfully created.");
					}
				}else{
					System.out.println("username filed is not Displayed ");
				}
			}else{
				System.out.println("New User Button is missing the application ");
			}
			}else{
				System.out.println("User Button is not Displayed ");
			}
		}else{
			System.out.println("Given url is not matching with launched Url  : "+Url);
		}
	}

}
