package com.selenium.maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureScreenShot {

	ChromeDriver driver;
	//String filePath = "D:\F Drive\Selenium Training Data\workspace\Selenium_Demo_Maven\Screenshot";
	
	@Test
	public void newtourscreenshot() throws Exception
	{
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("email")).sendKeys("abhinay.dixit@hotmail.com");
		driver.findElement(By.name("passwd")).sendKeys("test@1234");
		driver.findElement(By.name("SubmitLoginn")).click();
		driver.findElement(By.linkText("Sign out")).click();
        }
	
	@AfterMethod
public void teardown(ITestResult result) throws IOException  
{
	if ( ITestResult.FAILURE==result.getStatus())
	{
		 File Browserscreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Browserscreenshot, new File("D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_Demo_Maven\\Screenshot\\Login.png"));
		 
		//FileUtils.copyFile(Browserscreenshot, new File(filePath +"/"+result.getName()+"_"+System.nanoTime() + ".png"));		 
   }  
	
	driver.quit();
}
	@BeforeTest
	public void LaunchBrowser()
		
		{
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);
		 	driver = new ChromeDriver();
		 	driver.manage().window().maximize();
		}

}
