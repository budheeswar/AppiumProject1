package com.rb;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.rb.util.CommonUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;

public class AutomateClock {
    
	CommonUtils utils = new CommonUtils();
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AutomateClock obj = new AutomateClock();
		//obj.performAutomateClock();
		
	}

	public void performAutomateClock(AndroidDriver driver) throws InterruptedException, MalformedURLException {
		String appPackage = "com.google.android.deskclock";
		String appActivity = "com.android.deskclock.DeskClock";
		
		DesiredCapabilities dc = new DesiredCapabilities();
		utils.setDesiredCapabilities(dc,appPackage ,appActivity );
		
		URL url = utils.getAppiumUrl();

		//AndroidDriver driver = utils.getAndroidDriver(url, dc);
		driver = utils.getAndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Clock App launched");
		
		Thread.sleep(4000);
		
		// Taking Screenshot
		utils.captureScreenshot(driver, "ClockApp");
		
		// get the current day and date		
		String date = driver.findElement(By.id("date_and_next_alarm")).getText();
		System.out.println(date);
		
		// click the Alarm Button
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Alarm\"]")).click();
		Thread.sleep(2000);
		
		// Click new Button
		driver.findElement(By.id("fab")).click();
		Thread.sleep(1500);
		
		
		driver.findElement(By.id("material_timepicker_mode_button")).click();
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).clear();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).sendKeys("10");
        utils.captureScreenshot(driver, "AlarmTime");
		
        //select AM 
        Assert.isTrue(driver.findElement(By.id("material_clock_period_am_button")).isDisplayed(), date);
        
		driver.findElement(By.id("material_clock_period_am_button")).click();
		
		driver.findElement(By.id("material_timepicker_ok_button")).click();
        utils.captureScreenshot(driver, "AlarmSetted");
        
        driver.quit();
        
	}
}

