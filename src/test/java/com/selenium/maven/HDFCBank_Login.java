package com.selenium.maven;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HDFCBank_Login {

	@Test
	//This is for Sign On Functionality
	public void Sign_On()
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			//WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://netbanking.hdfcbank.com/netbanking/");
			driver.switchTo().frame("login_page");
			//driver.findElement(By.cssSelector("input[class='input_password']")).sendKeys("10000");
			 driver.findElement(By.xpath("//img[@alt='continue']")).click();
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			driver.quit();	
		}
	
}
