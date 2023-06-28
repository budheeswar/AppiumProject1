package com.rb;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallAPKExecutor {

	public static void main(String[] args) throws MalformedURLException {
		String apkPath = "C:\\Users\\BuddeesR\\Downloads\\SampleAPKs\\API Demos_4.0_apkcombo.com.apk";
		String apkInfoAppPath = "C:\\Users\\BuddeesR\\Downloads\\SampleAPKs\\apk-info.apk";
		
		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("platformVersion", "14");
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("app", apkInfoAppPath);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,dc);
		System.out.println("App Installed Successfully");
		
		driver.quit();
		

	}

}
