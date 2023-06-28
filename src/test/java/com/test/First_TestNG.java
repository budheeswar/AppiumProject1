package com.test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rb.AutomateAddContact;
import com.rb.AutomateClock;

import io.appium.java_client.android.AndroidDriver;

public class First_TestNG {

	AndroidDriver driver;

	@Test()
	public void testAddClock() throws InterruptedException {

		AutomateClock clk = new AutomateClock();
		try {
			clk.performAutomateClock(driver);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddContact() throws InterruptedException {
		AutomateAddContact contact = new AutomateAddContact();
		try {
			contact.addContactMethod(driver);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = null;

	}

	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
