package com.selenium.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sign_In extends ApplicationTestData {

	ChromeDriver driver;

	@Test(dataProvider="Login")
	public void Sign_On(String uname,String password)

	{

		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();
		driver.findElement(By.linkText("Sign out")).click();
	}

	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_Demo_Maven\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
