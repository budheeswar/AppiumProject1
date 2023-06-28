package com.rb;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.rb.util.CommonUtils;

import io.appium.java_client.android.AndroidDriver;

public class AutomateAddContact {

	CommonUtils utils = new CommonUtils();
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AutomateAddContact obj = new AutomateAddContact();
		//obj.addContactMethod();
	}
	
	public void addContactMethod(AndroidDriver driver) throws MalformedURLException, InterruptedException {
		String appPackage = "com.google.android.dialer";
		String appActivity = "com.android.dialer.main.impl.MainActivity";
		
		DesiredCapabilities dc = new DesiredCapabilities();
		utils.setDesiredCapabilities(dc,appPackage ,appActivity );

		URL url = utils.getAppiumUrl();
		
		// Get the Driver Instance
		//AndroidDriver driver = utils.getAndroidDriver(url, dc);
		driver = utils.getAndroidDriver(url, dc);
		System.out.println("Phone Dial App launched");
		utils.captureScreenshot(driver, "ContactAppLaunched");
		
		Thread.sleep(2000);
		//Click Recent Call List Button
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Recents\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
		driver.quit();
		
	}

}
