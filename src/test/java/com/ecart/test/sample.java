package com.ecart.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProject\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("abc");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://www.automationpractice.com");
	}

}
