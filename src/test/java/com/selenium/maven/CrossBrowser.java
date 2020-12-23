package com.selenium.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {

		if(browser.equalsIgnoreCase("firefox")){
			String absolutePath=System.getProperty("user.dir");
			String filepath=absolutePath+"\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",filepath);
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			String absolutePath=System.getProperty("user.dir");
			String filepath=absolutePath+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",filepath);
			driver = new ChromeDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

		@Test
		public void Flight_Login() {

		String baseurl = "http://automationpractice.com/index.php";
		driver.get(baseurl);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("email")).sendKeys("abhinay.dixit@hotmail.com");
		driver.findElement(By.name("passwd")).sendKeys("test@1234");
		driver.findElement(By.name("SubmitLogin")).click();
		driver.findElement(By.linkText("Sign out")).click();

	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
