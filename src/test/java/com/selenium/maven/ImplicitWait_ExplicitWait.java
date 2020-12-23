package com.selenium.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWait_ExplicitWait extends ApplicationTestData {

	ChromeDriver driver;

	@Test(dataProvider="Login")
	public void Sign_On(String uname,String password)

	{

		driver.findElement(By.linkText("Sign in")).click();
		//-----------------ImplicitWait Example-------------
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();
		
		//----------------ExplicitWait Example--------------
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign out")));
		element.getText();
		element.click();
		//driver.findElement(By.linkText("Sign out")).click();
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
