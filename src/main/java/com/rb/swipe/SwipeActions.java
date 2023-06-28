package com.rb.swipe;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeActions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String appPackage = "com.hmh.api";
		String appActivity = "com.hmh.api.ApiDemos";

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "12");
		dc.setCapability("deviceName", "ce2b5d44");
		dc.setCapability("appPackage", appPackage);
		dc.setCapability("appActivity", appActivity);

		dc.setCapability("autoGrantPermissions", "true");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, dc);

		Thread.sleep(5000);
		driver.findElement(AppiumBy.id("android:id/button1")).click();

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[11]"))
				.click();

		// Normal Down Swipe
		SwipeActions sa= new SwipeActions();
		sa.performSwipeAction("DOWN", driver);
		
		sa.performSwipeAction("UP", driver);

		// LEFT Swipe by holding element
		// driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[12]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[12]")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[1]"))
				.click();

		// BEFORE SWIPE
		WebElement firstImg = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]"));
		String focus = firstImg.getAttribute("focusable");
		System.out.println(focus);

		// Left SWIPE
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) firstImg).getId(), "direction", "left", "percent", 0.75));

		// AFTER SWIPE
				String focus1 = firstImg.getAttribute("focusable");
				System.out.println(focus1);
		
		Thread.sleep(5000);
		driver.quit();

	}

	public void performSwipeAction(String direction, AndroidDriver driver) {

		Dimension size = driver.manage().window().getSize();

		int sWidth, sHeight, eWidth = 0, eHeight = 0;

		sWidth = size.getWidth() / 2;
		sHeight = size.getHeight() / 2;
		int border = 15;
		switch (direction.toUpperCase()) {

		case "DOWN":
			eWidth = size.getWidth() / 2;
			eHeight = border;
			break;
		case "UP":
			eWidth = size.getWidth() / 2;
			eHeight = size.getHeight() - border;
			break;
		case "RIGHT":
			eWidth = size.getWidth();
			eHeight = size.getHeight() / 2;
			break;
		case "LEFT":
			eWidth = border;
			eHeight = size.getHeight() / 2;
		}

		try {

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(sWidth, sHeight)).waitAction().moveTo(PointOption.point(sWidth, eHeight))
					.release().perform();

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

}
