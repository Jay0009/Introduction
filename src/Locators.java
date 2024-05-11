import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators
{

	public static void main(String[] args) throws InterruptedException
	{
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait to resolve the issue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//go to webpage
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Find by ID
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		
		//Find by name
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		
		//Click on checkbox by css selector tagname#id(value)
//		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		
		//Click on log in by class name
		driver.findElement(By.className("signInBtn")).click();
		
		//Get error message
		String errorText = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorText);
		
		//Thread.sleep to check and see execution
		Thread.sleep(5000);
		
		//Close driver
		driver.close();
		

	}

}
