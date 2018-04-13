package com.soprasteria.mobilecenter;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TestOSEMobile {

	public static final String MC_SERVER = "http://ec2-34-242-36-143.eu-west-1.compute.amazonaws.com:8080";
	public static final String MC_SERVER_USER = "admin@default.com";
	public static final String MC_SERVER_PASSWORD = "password";

	@Test
	public void testLogin() throws Exception {

		AndroidDriver wd = null;

		try {

			// Set Capabilities instance
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// Set device capabilities
			capabilities.setCapability("platformName", "Android");
			// Application capabilities
			capabilities.setCapability("name", "AppiumTestApp");
			capabilities.setCapability("appPackage", "com.soprasteria.appiumtestapp");
			capabilities.setCapability("appActivity", "com.soprasteria.appiumtestapp.LoginActivity");
			// Set MC Server credentials (could be skipped if "Anonymous access" is enabled
			// for Appium scripts in the Administration settings).
			capabilities.setCapability("userName", MC_SERVER_USER);
			capabilities.setCapability("password", MC_SERVER_PASSWORD);
			// Create a session to the MC server
			
			System.out.println("Create Web driver");
			wd = new AndroidDriver(new URL(MC_SERVER + "/wd/hub"), capabilities);
			
			System.out.println("MC session was successfully created [Android Device]");
			// Create a wait object instance in order to verify expected conditions.
			
			System.out.println("Create web driver controller");
			WebDriverWait waitController = new WebDriverWait(wd, 60);
			// Create an implicitly wait instance to define the timeout for 'findElement'
			// commands
			wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						
			/**
			 * 
			 */
			WebElement email = wd.findElementById("email");
			email.sendKeys("lmichenaud@gmail.com");
			
			wd.findElement(By.id("email_sign_in_button")).click();
			System.out.println("Login Completed!");
			//
			//
			
			// Log in
			/*
			wd.findElement(By.id("loginButton")).click();
			System.out.println("Login Completed!");
			WebElement menu = wd.findElement(By.id("up"));
			menu.click(); // Expand menu
			Thread.sleep(1000);
			menu.click(); // Collapse menu
			Thread.sleep(1000);
			menu.click(); // Expand menu again
			System.out.println("Transfer Money - start transaction...");
			waitController.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.TextView[@text='MONEY TRANSFER']")));

			WebElement Transfer = wd.findElementByXPath("//android.widget.TextView[@text='MONEY TRANSFER']");
			Transfer.click();
			WebElement amount = wd.findElementByClassName("android.widget.EditText");
			amount.sendKeys("5");
			wd.navigate().back();
			// Transfer money
			waitController.until(ExpectedConditions.elementToBeClickable(By.id("transferButton")));
			wd.findElementById("transferButton").click();
			Thread.sleep(10000);
			// Confirm failed transaction
			waitController.until(ExpectedConditions.elementToBeClickable(By.id("button1")));
			System.out.println("Transfer Money - completed.");
			WebElement message = wd.findElementByClassName("android.widget.TextView");
			System.out.println("Status: " + message.getAttribute("text"));
			wd.findElementById("button1").click();
			wd.findElementById("up").click(); // Expand menu
			// Logout
			waitController.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='LOGOUT']")));
			WebElement logout = wd.findElementByXPath("//android.widget.TextView[@text='LOGOUT']");
			logout.click();
			// Cancel LogOut
			waitController.until(ExpectedConditions.elementToBeClickable(By.id("button2")));
			wd.findElementById("button2").click();
			*/
			
			System.out.println("Test completed.");
		}
		finally {
			// Release lock in all cases
			if (wd != null) {
				System.out.println("MC session closed.");
				wd.quit();
			}
		}
	}
}
