package com.sdet.SDET;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Filters extends Actions {
	
	@Test
	public void Filterstest() throws Throwable{

		/**
		 * @author 
		 * Navigate to the application 
		 * click on the User Button in menu tab 
		 * 
		 */	
		String Url  = driver.getCurrentUrl();
		if(Url.equals("http://qainterview.merchante-solutions.com:8080/admin")){
			System.out.println("Given url is matching with launched Url  : "+Url);
			// click on the User link 
			if(driver.findElements(By.xpath("//*[@id='users']/a")).size()!=0){
				click(By.xpath("//*[@id='users']/a"),"click on the users button");
				waitForVisibilityOfElement(By.xpath("//*[@id='q_username']"),"Enter Username");
				enter(By.xpath("//*[@id='q_username']"), "Mallikarjun", "Enter Username");
				enter(By.xpath("//*[@id='q_email']"), "Mallikarjun", "Enter Email");
				click(By.xpath("//*[@value='Filter']"), "click on the Filter Button");
				Thread.sleep(15000);
				List<WebElement> productTitle = driver.findElements(By.xpath("//*[@class='col col-username']"));
				for(int i =0; i<=productTitle.size(); i++){
					String username = productTitle.get(i).getText();
					if(username.contains("Mallikarjun")){
						System.out.println("Username is dispalyed List");
					 break;
					}else{
						System.out.println("Username not displayed in List");
					}
				}
				
			}else{
				System.out.println("Users Button is not Displayed ");
			}
		}else{
			System.out.println("Given url is not matching with launched Url  : "+Url);
		}
	
		
	}

}
