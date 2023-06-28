package com.rb.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;

public class CommonUtils {
	
	private static AndroidDriver driver;
	
	private static URL url;
	
	public void captureScreenshot(AndroidDriver driver, String imgName) throws MalformedURLException {		
		System.out.println("Taking Screenshot of  "+imgName+" ");
		
		String imgPath = "C:\\Appium_Screenshots\\"+imgName+".jpg";
		File dest = new File(imgPath);
		File source = driver.getScreenshotAs(OutputType.FILE);
		try {
			Files.move(source, dest);
		} catch (IOException e) {
			System.out.println("Unable to Take Screenshot");
			e.printStackTrace();
		}
		System.out.println("Screenshot Captured Successfully");
		
	}	
	
	public void setDesiredCapabilities(DesiredCapabilities dc, String appPackage, String appActivity) {
		this.setDesiredCapabilities(dc);
		dc.setCapability("appPackage", appPackage);
		dc.setCapability("appActivity", appActivity);
	}
	
	public void setDesiredCapabilities(DesiredCapabilities dc) {
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("platformVersion", "14");
		dc.setCapability("deviceName", "Android Emulator");
	}
	
	public AndroidDriver getAndroidDriver(URL url, DesiredCapabilities dc) {
		if(driver == null) {
			driver = new AndroidDriver(url,dc);
			return driver;
		}
		else {
			return driver;
		}
	}
	public URL getAppiumUrl() {
		if(url == null) {
			try {
				url = new URL("http://127.0.0.1:4723/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return url;
		}
		else {
			return url;
		}
	}

}
