package pk_orange_hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OrangeHRM_MouseHover_Two_Layer {

@Test
	//This is for Sign On Functionality
	public void Sign_On() throws InterruptedException
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			String Element = driver.findElement(By.linkText("Dashboard")).getText();
			System.out.println(Element);
			WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

	        Actions action = new Actions(driver);
	        action.moveToElement(admin).build().perform();
	        WebElement usermanagement = driver.findElementByLinkText("User Management");
	        action.moveToElement(usermanagement).build().perform();
	        Thread.sleep(5000);
	        driver.findElementByLinkText("Users").click();
	        // GetText
	        //GetCurrentURL
	        //GetTitle
			//driver.close();//Close will close only current chrome browser
		}
	
	
}
