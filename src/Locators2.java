import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2
{

	public static void main(String[] args) throws InterruptedException
	{
		String name = "rahul";
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait to resolve the issue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Get password
		String password = getPassword(driver);
		
		//go to webpage
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Find by ID
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		
		//Find by name
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		
		//Click on checkbox by css selector tagname#id(value)
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		
		//Click on log in by class name
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		
		//Getting log in message when there is only 1 tag present of that type
		String ActualloginMessage = driver.findElement(By.tagName("p")).getText();
		String expectedLoginMessageString = "You are successfully logged in.";
		
		//Compare actual vs expected message using testng Assert
		Assert.assertEquals(ActualloginMessage, expectedLoginMessageString);
		
		//Getting and comparing name after log by css
		String actualName = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		String expectedName = "Hello " + name + ",";
		Assert.assertEquals(actualName, expectedName);
		
		//Log out based on text in the element present - log out button - xpath only
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		//Thread.sleep to check and see execution
		Thread.sleep(5000);
		
		//Close driver
		driver.close();

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		
		//go to webpage
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Click on forgot password
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Sleep for 2 seconds so that the form will shift before inputting the credentials to get password.
		Thread.sleep(2000);
				
		//Click on reset css - tagname.classname
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		Thread.sleep(2000); // as page is moving
		
		//Getting password forgot message by css - parentTagname Tagname.classname 
		String passwordText = driver.findElement(By.cssSelector("form p.infoMsg")).getText();
		String password = passwordText.split("'")[1];
		return password;
	}

}
