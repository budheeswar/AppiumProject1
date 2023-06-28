package com.rb.realdevice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.rb.util.CommonUtils;

import io.appium.java_client.android.AndroidDriver;

public class Automate_RealDevice_Calculator {
	static CommonUtils utils;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String appPackage = "com.miui.calculator";
		String appActivity = "com.miui.calculator.cal.CalculatorActivity";
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "12");
		dc.setCapability("deviceName", "ce2b5d44");
		dc.setCapability("appPackage", appPackage);
		dc.setCapability("appActivity", appActivity);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,dc);
		
		//WebElement seven = driver.findElement(By.id("btn_7_s"));
		//seven.click();
		Thread.sleep(5000);
		driver.quit();

	}

}
