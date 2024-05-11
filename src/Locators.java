import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

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
		
		//Forgot password
		driver.findElement(By.linkText("Forgot your password?")).click();
				
		//After forgot password, click on name by xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		
		//Click on email and enter email
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("John@rsa.com");
		
		//deleting the inputted email by using clear and using different xpath - with index
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//Again with another email ID with css - using index
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("John@gmail.com");
		
		//Thread.sleep to check and see execution
		Thread.sleep(5000);
		
		//Close driver
		driver.close();
		

	}

}
